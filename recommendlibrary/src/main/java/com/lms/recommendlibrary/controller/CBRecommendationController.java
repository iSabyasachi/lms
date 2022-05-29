package com.lms.recommendlibrary.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.lms.recommendlibrary.service.CBRecommenderService;
import com.lms.recommendlibrary.service.COLBRecommenderService;
import com.lms.recommendlibrary.service.iRecommendService;

@RestController
@RequestMapping("/recommend")
public class CBRecommendationController {
	
	private Logger logger = LoggerFactory.getLogger(CBRecommendationController.class);
	
	///@Autowired
	AccessLibraryProxy proxy;	
	
	@Autowired
	@Qualifier("CBS")
	private iRecommendService recommenderService;		
	
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/getcbrecommendation/type/{type}/userid/{id}")
	public Recommendation getCBRecommendationByType(@PathVariable String type, @PathVariable long id) {
		logger.info("Get Recommendation By Type in CBRecommendationController class is invoked for the user id "+id);		
		
		Recommendation recommendation = new Recommendation();		
		List<BookBean> books = recommenderService.recommendBooks(id);
		recommendation.setBooks(books);
		
		String port = environment.getProperty("local.server.port");
		recommendation.setPort("PORT "+port+" Feign");
		recommendation.setMessage("SUCCESS");
		return recommendation;
	}
	
	
	@GetMapping("/getbook/id/{id}")
	public Recommendation getBookById(@PathVariable long id) {
		logger.info("Get Book method -> getBookById in RecommendationController class is invoked for the id "+id);
		Recommendation recommendation = new Recommendation();
		HashMap<String, Long> uriVariables = new HashMap<>();
		uriVariables.put("id",id);
		
		ResponseEntity<BookBean> responseEntity = new RestTemplate().getForEntity
				("http://localhost:8000/access/getbook/id/{id}", 
						BookBean.class, uriVariables);
		
		BookBean bean = responseEntity.getBody();
		List<BookBean> bookBeans = new ArrayList<>();
		bookBeans.add(bean);
		
		recommendation.setBooks(bookBeans);		
		
		String port = environment.getProperty("local.server.port");
		recommendation.setMessage("PORT "+port);
		
		return recommendation;
	}
	
	@GetMapping("/feign/getbook/id/{id}")
	public Recommendation getBookByIdFeign(@PathVariable long id) {
		logger.info("Get Book method - getBookByIdFeign in RecommendationController class is invoked for the id "+id);
		Recommendation recommendation = new Recommendation();
		
		BookBean bean = proxy.getBookById(id);
		
		List<BookBean> bookBeans = new ArrayList<>();
		bookBeans.add(bean);
		
		recommendation.setBooks(bookBeans);

		String port = environment.getProperty("local.server.port");
		recommendation.setPort("PORT "+port+" Feign");
		recommendation.setMessage("SUCCESS");
		return recommendation;
	}

}
