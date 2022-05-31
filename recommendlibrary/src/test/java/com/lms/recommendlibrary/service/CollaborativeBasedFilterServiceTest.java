package com.lms.recommendlibrary.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lms.recommendlibrary.proxy.AccessLibraryProxy;

@ExtendWith(MockitoExtension.class)
public class CollaborativeBasedFilterServiceTest {
	
	@InjectMocks
	private CollaborativeBasedFilterService mockService;
	
	@Mock
	private AccessLibraryProxy mockProxy;
	
	@Test
	void testGetRecommendations_noRecommendationsFound() {
		when(mockProxy.getAllBooksByUserId(2)).thenReturn(new ArrayList<>());
		assertEquals(new ArrayList<>(), mockService.getRecommendations(2));
	}

}
