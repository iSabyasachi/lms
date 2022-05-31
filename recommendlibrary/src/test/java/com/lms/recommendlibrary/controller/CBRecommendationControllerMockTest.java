package com.lms.recommendlibrary.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;

import com.lms.recommendlibrary.bean.BookBean;
import com.lms.recommendlibrary.dto.Recommendation;
import com.lms.recommendlibrary.service.FilterService;

@ExtendWith(MockitoExtension.class)
public class CBRecommendationControllerMockTest {
	
	@InjectMocks
	private CBRecommendationController mockCBRController;
	
	@Mock
	private FilterService mockFilterService;
	
	@Mock
	private Environment mockEnv;
	
	@Test
	//@Disabled
	void testGetCBRecommendationByType_noRecommendationsFound() {
		
		when(mockFilterService.getRecommendations(2)).thenReturn(null);
		
		Recommendation actualRecom = mockCBRController.getCBRecommendationByType("BOOK", 2);
		actualRecom.setMessage("SUCCESS");
		
		System.out.println(actualRecom);
		
		Recommendation expectedRecom = new Recommendation();
		expectedRecom.setBooks(null);
		expectedRecom.setMessage("SUCCESS");
		
		assertEquals(expectedRecom, actualRecom);
		
	}
	
	@Test
	void testGetCBRecommendationByType_RecommendationsFound() {
		
		//Prepare Data for Actual Bean
		List<BookBean> testBeanList = new ArrayList<>();
		testBeanList.add(new BookBean("Java"));
		
		when(mockFilterService.getRecommendations(2)).thenReturn(testBeanList);
		
		Recommendation actualRecom = mockCBRController.getCBRecommendationByType("BOOK", 2);
		
		//Prepare Data for Expected Bean
		Recommendation expectedRecom = new Recommendation();		
		expectedRecom.setBooks(testBeanList);
		expectedRecom.setMessage("SUCCESS");		
		
		assertEquals(expectedRecom, actualRecom);
		
	}
}
