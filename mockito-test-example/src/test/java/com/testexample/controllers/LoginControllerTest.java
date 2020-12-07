package com.testexample.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mockito.runners.MockitoJUnitRunner;

import com.testexample.entities.User;
import com.testexample.services.IUserService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
	
	@Mock
	private IUserService userService;

	
	@InjectMocks
	private LoginController loginController;
	
	
	@Before
	public void setup () {
		//MockitoAnnotations.initMocks(this) ; // use this or 
		//@RunWith (MockitoJUnitRunner.class) 
		// Mockito anotasyonlarýnýn bu class uzerinden calýþmasý için kullanýlýyor.
	}
	
//givenUserIsValidWhenAuthenticateThenReturnHomePage
	@Test
	public void testAuthentication() throws Exception {
		final User userStub= new User();
		userStub.setPassword("password");
		userStub.setUserName("user");
		
		//Act
		Mockito.when(userService.authenticate(userStub)).thenReturn(true);
		
		final String  redirect= loginController.authenticate(userStub);
		Assert.assertEquals("homePage", redirect);
		Mockito.verify(userService,new Times(1)).authenticate(Mockito.any(User.class));
		//Mockito verify ile kontrol ekleyebiliriz UserService in authenticate methodu herhangi bir user objesi alarak çalýþtýmý 
		
	}
	
}
