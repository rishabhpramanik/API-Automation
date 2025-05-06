package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	@Test(description = "Verify the Forgot Password API is working")
	public void forgotPassword() {
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("megankizun@gmailbrt.com");
		Assert.assertEquals(200, response.statusCode());
		System.out.println(response.asPrettyString());
	}
}	
