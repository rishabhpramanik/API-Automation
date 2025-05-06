package com.tests;

import org.testng.annotations.Test;

import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import com.base.AuthService;
import com.base.UserService;

import io.restassured.response.Response;

public class GetProfileInfoTest {
	@Test
	public void getProfileTest() {
		// Token Generation
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("Skywalker", "Abc@1234"));
		LoginResponse loginResponse = response.as(LoginResponse.class); // Returns object of Login Response
		String token = loginResponse.getToken(); // Getting the token from login response
		System.out.println(token);
		
		// Passing the token as payload to authenticate
		UserService userService = new UserService();
		response = userService.getProfile(token);
		
//		System.out.println(response.asPrettyString()); 
		
		// Deserialiing the JSON format to POJO
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		// Printing the username from the body
		System.out.println(userProfileResponse.getUsername());
	}
}
