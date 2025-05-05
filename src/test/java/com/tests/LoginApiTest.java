package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import com.base.AuthService;

import io.restassured.response.Response;

public class LoginApiTest {
	@Test(description = " Verify if the login API is working")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("Skywalker", "Apimaster@123$");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class); // De-serialize the JSON object
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getEmail(), "rpcoc908@gmail.com");
		Assert.assertEquals(loginResponse.getUsername(), "Skywalker");
	}
	
	
}
