package com.lms.recommendlibrary.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lms.recommendlibrary.bean.BookBean;

//@FeignClient(name="access-library",url = "localhost:8000/access-library")
@FeignClient(name="access-library/access")
public interface AccessLibraryProxy {
	
	@GetMapping("/getbook/id/{id}")
	public BookBean getBookById(@PathVariable long id);
	
	@GetMapping("/getbook/type/{type}")
	public List<BookBean> getAllBooksByType(@PathVariable String type);
	
	@GetMapping("/getbooksbyuserid/userid/{id}")
	public List<BookBean> getAllBooksByUserId(@PathVariable long id);
	
	@GetMapping("/getallbooks/")
	public List<BookBean> getAllBooks();

}
