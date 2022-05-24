package com.lms.recommendlibrary.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lms.recommendlibrary.bean.BookBean;
import com.lms.recommendlibrary.dto.Recommendation;
import com.lms.recommendlibrary.proxy.AccessLibraryProxy;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {
	
	private Logger logger = LoggerFactory.getLogger(RecommendationController.class);
	
	@Autowired
	AccessLibraryProxy proxy;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/getbook/id/{id}")
	public Recommendation getBookById(@PathVariable long id) {
		logger.info("Get Book method - getBookById in RecommendationController class is invoked for the id "+id);
		Recommendation recommendation = new Recommendation();
		HashMap<String, Long> uriVariables = new HashMap<>();
		uriVariables.put("id",id);
		
		ResponseEntity<BookBean> responseEntity = new RestTemplate().getForEntity
				("http://localhost:8000/access/getbook/id/{id}", 
						BookBean.class, uriVariables);
		
		BookBean bean = responseEntity.getBody();
		recommendation.setBook(bean);		
		
		String port = environment.getProperty("local.server.port");
		recommendation.setMessage("PORT "+port);
		
		return recommendation;
	}
	
	@GetMapping("/feign/getbook/id/{id}")
	public Recommendation getBookByIdFeign(@PathVariable long id) {
		logger.info("Get Book method - getBookByIdFeign in RecommendationController class is invoked for the id "+id);
		Recommendation recommendation = new Recommendation();
		
		BookBean bean = proxy.getBookById(id);
		
		recommendation.setBook(bean);

		String port = environment.getProperty("local.server.port");
		recommendation.setMessage("PORT "+port+" Feign");
		
		return recommendation;
	}

}
