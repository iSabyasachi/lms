package com.lms.accesslibrary.bo;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.accesslibrary.dao.BookItemRepository;
import com.lms.accesslibrary.entity.library.book.Book;
import com.lms.accesslibrary.entity.library.book.BookItem;
import com.lms.accesslibrary.entity.library.user.User;
import com.lms.accesslibrary.enums.BookItemStatus;
import com.lms.accesslibrary.enums.BookStatus;
import com.lms.accesslibrary.utility.DateFormatUtility;
import com.lms.accesslibrary.utility.FineCalculatorUtility;

@Component
public class BookItemBO {
	@Autowired
	BookItemRepository bookItemRepository;
	
	public List<BookItem> findByBarcode(String barcode) {
		return bookItemRepository.findByBarcode(barcode);
	};
	
	public BookItem findByTrackingNumber(String trackingNumber) {
		return bookItemRepository.findByTrackingNumber(trackingNumber);
	};
	
	public List<BookItem> findByUserIdOrderByCreatedTSDesc(long id){
		List<BookItem> bookItems = bookItemRepository.findByUserIdOrderByCreatedTSDesc(id);		
		return bookItems;
	};
	
	public BookItem findByUserEmailOrderByCreatedTSDesc(String email){
		List<BookItem> bookItems = bookItemRepository.findByUserEmailOrderByCreatedTSDesc(email);		
		if(bookItems != null && bookItems.size() > 0) {
			return bookItems.get(0);
		}
		return null;
	};
	
	
	public boolean checkout(Book book,BookItem bookItem, long userId) {
	    if(book.getIsReferenceOnly().equals("1")) {
	      return false;
	    }	    
	    bookItem.setStatus(BookStatus.LOANED.name());
	    return true;
	  }

	public void save(BookItem bookItem) {
		bookItemRepository.save(bookItem);		
	}
	
	public BookItem loan(User librarian, User member, Book book, String bookItemStatus) {
		Set<BookItem> bookItems = book.getBookItems();
		/*Create a new Book Item*/
		BookItem bookItem = new BookItem();
		bookItem.setLibrarianId((int)librarian.getId());
		bookItem.setBarcode(book.getBarcode());
		bookItem.setTrackingNumber(BookItemBO.generateOrderTrackingNumber());
		bookItem.setBorrowedDate(new Date());
		bookItem.setDueDate(DateFormatUtility.calculateDueDate());		
		if(BookItemStatus.RESERVEREQUEST.name().equals(bookItemStatus)) {
			bookItem.setActive(0);			
		}else {
			bookItem.setActive(1);
			book.setStatus(BookStatus.LOANED.name());
			member.setTotalNumBooksCheckedOut(member.getTotalNumBooksCheckedOut() + 1);
		}
		bookItem.setStatus(bookItemStatus);		
		bookItem.setUser(member);		
		bookItem.setBook(book);		
		bookItem.setCreatedTS(Timestamp.from(Instant.now()));
		bookItem.setUpdatedTS(Timestamp.from(Instant.now()));
		bookItems.add(bookItem);			
		
		this.save(bookItem);
		return bookItem;
	}
	
	public BookItem checkinBook(User librarian, User member, BookItem activeBookItem) {
		Book book = activeBookItem.getBook();
		Set<BookItem> bookItems = book.getBookItems();
		activeBookItem.setStatus(BookItemStatus.CHECKEDIN.name());		
		member.setTotalNumBooksCheckedOut(member.getTotalNumBooksCheckedOut() - 1);		
		/*Calculate total Fine*/
		double totalFine = FineCalculatorUtility.calculateFine(activeBookItem.getDueDate());
		if(totalFine > 0) {
			member.setTotalFine(totalFine);
		}
		activeBookItem.setUser(member);
		activeBookItem.setActive(0);	
		activeBookItem.setCheckinDate(Timestamp.from(Instant.now()));
		book.setStatus(BookStatus.AVAILABLE.name());		
		activeBookItem.setBook(book);
		activeBookItem.setUpdatedTS(Timestamp.from(Instant.now()));
		bookItems.add(activeBookItem);		
		this.save(activeBookItem);
		return activeBookItem;
	}
	
	public BookItem approveReserveRequest(User librarian, User member, BookItem reservedBookItem) {
		reservedBookItem.setActive(1);
		reservedBookItem.setBorrowedDate(Timestamp.from(Instant.now()));
		reservedBookItem.setStatus(BookItemStatus.CHECKEDOUT.name());
		reservedBookItem.getBook().setStatus(BookStatus.LOANED.name());		
		reservedBookItem.setUpdatedTS(Timestamp.from(Instant.now()));
		reservedBookItem.setTrackingNumber(BookItemBO.generateOrderTrackingNumber());					
		this.save(reservedBookItem);
		return reservedBookItem;
	}
	public static String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
	
	public BookItem fetchActiveBookItem(Set<BookItem> bookItems) {
		Optional<BookItem> bookItemOpt = bookItems!= null && bookItems.size() > 0 
				? bookItems.stream().filter(d -> d.getActive() == 1).findFirst() : null;
		return bookItemOpt != null && bookItemOpt.isPresent() ? bookItemOpt.get() : null;
	}
	
	public BookItem fetchReserveRequestBookItem(Set<BookItem> bookItems) {
		Optional<BookItem> bookItemOpt =  bookItems!= null && bookItems.size() > 0 
				? bookItems.stream().filter(d -> d.getStatus().equals(BookItemStatus.RESERVEREQUEST.name())).findFirst() : null;
		return bookItemOpt != null && bookItemOpt.isPresent() ? bookItemOpt.get() : null;		
	}
	
	public boolean isInvalidReturn(Set<BookItem> bookItems, User member) {
		if(null != bookItems && bookItems.size() > 0 && bookItems
				.stream()
				.anyMatch(d -> 
				d.getActive() == 1 &&
				d.getUser().getId()== member.getId() &&
				!d.getStatus().equals(BookItemStatus.CHECKEDOUT.name()))) {
			return true;
		}
		return false;
	}
	
	
}
