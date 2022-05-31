package com.lms.searchlibrary.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SearchServiceTest {
	
	@Test
	@Disabled
	public void testFindIndex() {
		//1. Create object of the class
		SearchService searchService = new SearchService();
		
		//2. Call method
		int result = searchService.findIndex(new int[] {1,2,3}, 2);
		
		//3. Compare the actual result to the expected
		assertEquals(1, result);		
	}
	
	@Test
	public void testSearchForNumber() {
		//1. Create object of the class
		SearchService searchService = new SearchService();
		
		//2. Call method
		boolean result = searchService.searchForNumber(new int[] {1,2,3}, 2);
		
		//3. Compare the actual result to the expected
		assertEquals(true, result);
	}
	
	@Test
	public void testfindIndex_numberInArray() {
		//1. Create object of the class
		SearchService searchService = new SearchService();		
		
		//2. Compare the actual result to the expected
		assertEquals(1, searchService.findIndex(new int[] {1,2,3}, 2));
	}
	
	@Test
	public void testfindIndex_numberNotInArray() {
		//1. Create object of the class
		SearchService searchService = new SearchService();		
		
		//3. Compare the actual result to the expected
		assertEquals(-1, searchService.findIndex(new int[] {1,2,3}, 4));
	}
	
	@Test
	public void testfindIndex_emptyArray() {
		//1. Create object of the class
		SearchService searchService = new SearchService();		
		
		//3. Compare the actual result to the expected
		assertEquals(-1, searchService.findIndex(new int[] {}, 1));
	}
}
