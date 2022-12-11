package com.lms.batchlibrarymongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.batchlibrarymongo.domain.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Long>{
	
	@Query("{id:'?0'}")
    Book findItemById(String id);
	
	@Query("{title:'?0'}")
    Book findItemByTitle(String title);
	
	@Query(value="{type:'?0'}", fields="{'ISBN' : 1, 'title' : 1}")
    List<Book> findAll(String type);
}
