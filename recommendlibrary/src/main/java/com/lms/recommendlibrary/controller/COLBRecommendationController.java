package com.lms.recommendlibrary.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.recommendlibrary.bean.BookBean;
import com.lms.recommendlibrary.dto.Recommendation;
import com.lms.recommendlibrary.service.FilterService;

@RestController
@RequestMapping("/recommend")
public class COLBRecommendationController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	@Qualifier("COLBF")
	private FilterService filterService;	
	
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/getcolbrecommendation/type/{type}/userid/{id}")
	public Recommendation getCOLBRecommendationByType(@PathVariable String type, @PathVariable long id) {
		logger.info("Get Recommendation By Type in COLBRecommendationController class is invoked for the id "+id);
		
		Recommendation recommendation = new Recommendation();		
		List<BookBean> books = filterService.getRecommendations(id);
		recommendation.setBooks(books);
		
		String port = environment.getProperty("local.server.port");
		recommendation.setPort("PORT "+port+" Feign");
		recommendation.setMessage("SUCCESS");
		return recommendation;
	}
}
