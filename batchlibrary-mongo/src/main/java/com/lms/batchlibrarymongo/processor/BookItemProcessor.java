package com.lms.batchlibrarymongo.processor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.lms.batchlibrarymongo.domain.Book;
import com.lms.batchlibrarymongo.model.BookDetail;

@Component
public class BookItemProcessor implements ItemProcessor<BookDetail, Book>{
	private static final Logger log = LoggerFactory.getLogger(BookItemProcessor.class);
	
	@Override
	public Book process(BookDetail item) throws Exception {
		log.info("processing book data.....{}", item);
		
		Book transformedBook = new Book();
		transformedBook.setId(item.getId());		
		transformedBook.setISBN(item.getISBN());		
		transformedBook.setBarcode(item.getBarcode());		
		transformedBook.setTitle(item.getTitle());		
		transformedBook.setType(item.getType());		
		transformedBook.setSubject(item.getSubject());		
		transformedBook.setPublisher(item.getPublisher());
		
		LocalDate localDate = LocalDate.parse(item.getPublicationDate());
		Date publicationDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		transformedBook.setPublicationDate(publicationDate);		
		transformedBook.setLanguage(item.getLanguage());		
		transformedBook.setNumberOfPages(item.getNumberOfPages());		
		transformedBook.setAuthor(item.getAuthor());		
		transformedBook.setDescription(item.getDescription());		
		transformedBook.setGenre(item.getGenre());		
		transformedBook.setIsReferenceOnly(item.getIsReferenceOnly());		
		transformedBook.setActive(item.getActive());		
		transformedBook.setUnit(item.getUnit());		
		transformedBook.setRackNum(item.getRackNum());		
		transformedBook.setStatus(item.getStatus());		
        return transformedBook;
	}

}
