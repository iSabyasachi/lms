package com.lms.accesslibrary.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.accesslibrary.entity.library.book.Book;


@RepositoryRestResource(collectionResourceRel = "book", path = "books")
public interface BookRepository extends JpaRepository<Book, String>{
	Book findByISBN(@RequestParam("ISBN") String ISBN);
	
	Book findBybarcode(@RequestParam("barcode") String barcode);

    Page<Book> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);
}
