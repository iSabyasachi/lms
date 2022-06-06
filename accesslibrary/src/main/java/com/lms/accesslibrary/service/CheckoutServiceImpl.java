package com.lms.accesslibrary.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.accesslibrary.bean.BookBean;
import com.lms.accesslibrary.bo.BookBO;
import com.lms.accesslibrary.bo.BookItemBO;
import com.lms.accesslibrary.bo.UserBO;
import com.lms.accesslibrary.constant.Constants;
import com.lms.accesslibrary.dto.Checkout;
import com.lms.accesslibrary.dto.CheckoutResponse;
import com.lms.accesslibrary.entity.Book;
import com.lms.accesslibrary.entity.BookItem;
import com.lms.accesslibrary.entity.User;
import com.lms.accesslibrary.enums.BookItemStatus;
import com.lms.accesslibrary.enums.BookStatus;
import com.lms.accesslibrary.enums.UserType;
import com.lms.accesslibrary.utility.DateFormatUtility;
import com.lms.accesslibrary.utility.LibraryUtility;

@Service
public class CheckoutServiceImpl implements ICheckoutService {
	
	@Autowired
	private CheckoutResponse response;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private BookBO bookBO;
	
	@Autowired
	private BookItemBO bookItemBO;
	
	String errCode = "";
	@Override
	/**
	 * Input :
	 * librarian.id
	 * member.id
	 * book.barcode
	 *  
	 * Output :
	 * response
	 * */
	public CheckoutResponse checkoutBookItem(Checkout checkout) {
		/*Find the librarian detail*/		
		String librarianId = String.valueOf(checkout.getLibrarian().getId());		
		User librarian = userBO.findRegisteredUser(librarianId, UserType.LIBRARIAN.name());
		if(librarian == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.LIBRARIAN.name()+".");
			return response;
		}
		
		/*Find the member detail*/		
		String memberId = String.valueOf(checkout.getMember().getId());		
		User member = userBO.findRegisteredUser(memberId, UserType.MEMBER.name());
		if(member == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.MEMBER.name()+".");
			return response;
		}
		
		if (member.getTotalNumBooksCheckedOut() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
			errCode= "The member has already checked-out maximum number of books";
			response.setMessage(errCode);	
			return response;
		}
		
		/*Find the Book Details - By BarCode*/
		String barcode = checkout.getBook().getBarcode();
		System.out.println("barcode "+barcode);
		Book book = bookBO.findBybarcode(barcode);
		
		if(BookStatus.LOANED.name().equals(book.getStatus())) {
			response.setMessage("FAILED!!! The book is not available to checkout.");	
			return response; 
		}
		
		/*Create a new Book Item*/
		BookItem bookItem=bookItemBO.loan(librarian, member, book, BookItemStatus.CHECKEDOUT.name());
		response.setMessage("You have successfully checkedout the book with Bar Code ->: "+bookItem.getBarcode());
		BookBean bookBean = new BookBean();
		LibraryUtility.copyProperties(bookItem.getBook(), bookBean);
		response.setBook(bookBean);	
		return response;
	}

	@Override
	/**
	 * Input :
	 * librarian.id
	 * member.id
	 * member.finePaid (optional)
	 * book.barcode
	 *  
	 * Output :
	 * response
	 * */
	public CheckoutResponse returnBookItem(Checkout checkout) {		
		/*Find the librarian detail*/	
		String librarianId = String.valueOf(checkout.getLibrarian().getId());		
		User librarian = userBO.findRegisteredUser(librarianId, UserType.LIBRARIAN.name());
		if(librarian == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.LIBRARIAN.name()+".");
			return response;
		}
		
		/*Find the member detail*/		
		String memberId = String.valueOf(checkout.getMember().getId());		
		User member = userBO.findRegisteredUser(memberId, UserType.MEMBER.name());
		if(member == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.MEMBER.name()+".");
			return response;
		}
		
		/*Find the Book Details - By BarCode*/
		String barcode = checkout.getBook().getBarcode();
		System.out.println("barcode "+barcode);
		Book book = bookBO.findBybarcode(barcode);
		
		Set<BookItem> bookItems = book.getBookItems();
		if(bookItemBO.isInvalidReturn(bookItems, member)) {
			response.setMessage("FAILED!!! The book cannot be returned.");	
			return response; 
		}
		
		BookItem activeBookItem = bookItemBO.fetchActiveBookItem(bookItems);		
		activeBookItem = bookItemBO.checkinBook(librarian, member, activeBookItem);
		
		//Check if any reserved request is present
		BookItem reservedBookItem = bookItemBO.fetchReserveRequestBookItem(bookItems);		
		String reserveMsg = "";
		if(null != reservedBookItem) {
			reservedBookItem = bookItemBO.approveReserveRequest(librarian, member, reservedBookItem);			
			reserveMsg = "You have successfully checkedout the book with Tracking Number : "+reservedBookItem.getTrackingNumber();
		}		
		response.setMessage("You have successfully returned the book with Tracking Number : "+activeBookItem.getTrackingNumber()+" and "+reserveMsg);	
		
		return response;				
	}	
	@Override
	/**
	 * Input :
	 * librarian.id
	 * member.id
	 * book.barcode
	 *  
	 * Output :
	 * response
	 * */
	public CheckoutResponse renewBookItem(Checkout checkout) {
		/*Find the librarian detail*/		
		String librarianId = String.valueOf(checkout.getLibrarian().getId());		
		User librarian = userBO.findRegisteredUser(librarianId, UserType.LIBRARIAN.name());
		if(librarian == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.LIBRARIAN.name()+".");
			return response;
		}
		
		/*Find the member detail*/		
		String memberId = String.valueOf(checkout.getMember().getId());		
		User member = userBO.findRegisteredUser(memberId, UserType.MEMBER.name());
		if(member == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.MEMBER.name()+".");
			return response;
		}else if(member.getTotalFine() > 0) {
			response.setMessage("FAILED!!! You cannot renew as you have total fine $"+member.getTotalFine()+".");
			return response;
		}
		
		/*Find the Book Details - By BarCode*/
		String barcode = checkout.getBook().getBarcode();
		System.out.println("barcode "+barcode);
		Book book = bookBO.findBybarcode(barcode);
		
		Set<BookItem> bookItems = book.getBookItems();
		if(null != bookItems && bookItems.size() > 0) {
			if(bookItems
					.stream()
					.anyMatch(d -> 
					d.getUser().getId()!= member.getId() && 
					d.getActive() != 1 && 
					!d.getStatus().equals(BookItemStatus.CHECKEDOUT.name()))) {
				response.setMessage("FAILED!!! The book cannot be renewed as it is already checkedout.");	
				return response; 
			}else if(bookItems
					.stream()
					.anyMatch(d -> 
					d.getStatus().equals(BookItemStatus.RESERVEREQUEST.name()))) {
				response.setMessage("FAILED!!! The book cannot be renewed as it is reserved.");	
				return response;
			}
		}
		
		BookItem bookItem = bookItems.stream().filter(d -> d.getActive() == 1).findFirst().get();
		bookItem.setStatus(BookItemStatus.RENEWED.name());		
		bookItem.setBook(book);
		bookItem.setDueDate(DateFormatUtility.calculateDueDateForRenewal(bookItem.getDueDate()));
		bookItem.setUpdatedTS(Timestamp.from(Instant.now()));
		bookItems.add(bookItem);
		
		//bookItemRepository.save(bookItem);
		bookItemBO.save(bookItem);
		
		response.setMessage("You have successfully renewed the book with Bar Code : "+bookItem.getTrackingNumber());	
		return response;
	}

	@Override
	/**
	 * Input :
	 * librarian.id
	 * member.id
	 * member.finePaid
	 *  
	 * Output :
	 * response
	 * */
	public CheckoutResponse payFine(Checkout checkout) {		
		/*Find the librarian detail*/		
		String librarianId = String.valueOf(checkout.getLibrarian().getId());		
		User librarian = userBO.findRegisteredUser(librarianId, UserType.LIBRARIAN.name());
		if(librarian == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.LIBRARIAN.name()+".");
			return response;
		}
		
		/*Find the member detail*/		
		String memberId = String.valueOf(checkout.getMember().getId());		
		User member = userBO.findRegisteredUser(memberId, UserType.MEMBER.name());
		if(member == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.MEMBER.name()+".");
			return response;
		}
		
		/*Find the Book Details - By BarCode*/
		double totalFine = member.getTotalFine();
		//Check the amount submitted by the member to pay the fine
		double finePaid = checkout.getMember().getFinePaid();
		if(finePaid != totalFine) {
			errCode = "FAILURE! Incorrect fine amount!!!";
			response.setMessage(errCode);
		}else {
			member.setFinePaid(totalFine);
			member.setTotalFine(0.0);
			userBO.save(member);
			//userRepository.save(member);
			response.setMessage("SUCCESS! The total fine now is $0.00.");
		}
		
	    return response;
	}

	@Override
	/**
	 * Input :
	 * librarian.id
	 * member.id
	 *  
	 * Output :
	 * response
	 * */
	public CheckoutResponse getFine(Checkout checkout) {		
		/*Find the librarian detail*/		
		String librarianId = String.valueOf(checkout.getLibrarian().getId());		
		User librarian = userBO.findRegisteredUser(librarianId, UserType.LIBRARIAN.name());
		if(librarian == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.LIBRARIAN.name()+".");
			return response;
		}
		
		/*Find the member detail*/		
		String memberId = String.valueOf(checkout.getMember().getId());		
		User member = userBO.findRegisteredUser(memberId, UserType.MEMBER.name());
		if(member == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.MEMBER.name()+".");
			return response;
		}
		
		response.setMessage("Total Fine for the User "+memberId+" is : $"+member.getTotalFine());
		return response;
	}

	@Override
	public CheckoutResponse reserveBook(Checkout checkout) {
		
		/*Find the librarian detail*/		
		String librarianId = String.valueOf(checkout.getLibrarian().getId());		
		User librarian = userBO.findRegisteredUser(librarianId, UserType.LIBRARIAN.name());
		if(librarian == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.LIBRARIAN.name()+".");
			return response;
		}
		
		/*Find the member detail*/		
		String memberId = String.valueOf(checkout.getMember().getId());		
		User member = userBO.findRegisteredUser(memberId, UserType.MEMBER.name());
		if(member == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.MEMBER.name()+".");
			return response;
		}
		
		if (member.getTotalNumBooksCheckedOut() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
			errCode= "The member has already checked-out maximum number of books";
			response.setMessage(errCode);	
			return response;
		}
		
		/*Find the Book Details - By BarCode*/
		String barcode = checkout.getBook().getBarcode();
		System.out.println("barcode "+barcode);
		Book book = bookBO.findBybarcode(barcode);
		
		String status = book.getStatus();
		
		BookItem bookItem = null;
		if(status.equals(BookStatus.LOANED.name())) {
			bookItem=bookItemBO.loan(librarian, member, book, BookItemStatus.RESERVEREQUEST.name());
			response.setMessage("You have successfully reserved the book with Bar Code : "+bookItem.getBarcode());	
		}else if(status.equals(BookStatus.NEW.name()) || status.equals(BookStatus.AVAILABLE.name())) {
			bookItem=bookItemBO.loan(librarian, member, book, BookItemStatus.CHECKEDOUT.name());
			response.setMessage("You have successfully checkedout the book with Bar Code : "+bookItem.getBarcode());	
		}else {
			response.setMessage("FAILED!!! The book cannot be reserved.");
		}
		return response;
	}

}
