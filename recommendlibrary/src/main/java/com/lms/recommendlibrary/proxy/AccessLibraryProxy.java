package com.lms.recommendlibrary.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lms.recommendlibrary.bean.BookBean;

//@FeignClient(name="access-library",url = "localhost:8000/access-library")
@FeignClient(name="access-library/access")
public interface AccessLibraryProxy {
	
	@GetMapping("/getbook/id/{id}")
	public BookBean getBookById(@PathVariable long id);

}
