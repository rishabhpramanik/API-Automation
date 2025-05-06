package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.models.requests.SignupRequest;
import com.base.AuthService;

import io.restassured.response.Response;

public class AccountCreationTest {
	@Test
	public void accountCreationTest(){
		/*
		 * { "username": "string", "password": "string", "email": "string", "firstName":
		 * "string", "lastName": "string", "mobileNumber": "1618902534" }
		 */
		SignupRequest signUpRequest = new SignupRequest
										.Builder()
										.userName("MarkJoel")
										.email("megankizun@gmailbrt.com")
										.firstName("Mark")
										.lastName("Joel")
										.password("Abc@123")
										.mobileNumber("8989898989")
										.build();
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		Assert.assertEquals(response.statusCode(), 200);
	}
}
