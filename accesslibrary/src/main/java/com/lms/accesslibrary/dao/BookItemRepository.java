package com.lms.accesslibrary.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lms.accesslibrary.entity.book.BookItem;

@RepositoryRestResource(collectionResourceRel = "bookItem", path = "book-borrowed")
public interface BookItemRepository extends JpaRepository<BookItem, Long>{
	
	List<BookItem> findByBarcode(String barcode);
	
	BookItem findByTrackingNumber(String trackingNumber);
	
	List<BookItem> findByUserEmailOrderByCreatedTSDesc(String email);
	
	List<BookItem> findByUserIdOrderByCreatedTSDesc(long id);
	
	

}
