package com.lms.accesslibrary.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lms.accesslibrary.entity.library.book.Book;
import com.lms.accesslibrary.entity.library.user.User;

@Repository
@Transactional
public class BookDAO extends BaseDAO implements iBookDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public Book insertBook(Book book){
	   return entityManager.merge(book);
	}

	public Book updateBook(Book book){
	   return entityManager.merge(book);
	}
	
	public Book getBookById(long id) {
	    return entityManager.find(Book.class, id);                
	}
	
	public void deleteBookById(int id){
		Book book = entityManager.find(Book.class, id);
	    entityManager.remove(book);
	}

	@Override
	public Book getBookByBarcode(String barcode) {
		TypedQuery<Book> query =  entityManager.createNamedQuery("getBookByBarcode", Book.class);
		query.setParameter("barcode", barcode);
		return query.getSingleResult();		
	}
	
	@Override
	public List<Book> getBookByType(String type) {
		String sql = "SELECT * FROM T_BOOK WHERE TYPE = ?";		
		List<Book> books = jdbcTemplate.query(sql, 
												new BookMapper(),
												new Object[] {type});
		return books;
	}
}
