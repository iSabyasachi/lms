package com.lms.searchlibrary.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.lms.searchlibrary.bean.BookBean;

@FeignClient(name="access-library/access")
public interface AccessLibraryProxy {
	
	@GetMapping("/getallbooks")
	public List<BookBean> getAllBooks();

}
