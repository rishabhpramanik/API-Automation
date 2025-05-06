package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.models.requests.LoginRequest;
import com.api.models.requests.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import com.base.AuthService;
import com.base.UserService;

import io.restassured.response.Response;

public class UpdateProfileTest {
	@Test
	public void updateProfile() {
		AuthService authService = new AuthService();
		LoginRequest loginRequest = new LoginRequest("Skywalker", "Abc@1234");
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		String token = loginResponse.getToken();
		
		UserService userService = new UserService();
		response = userService.getProfile(token);
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getFirstName(), "Scott"); // Checking the Profile is correct
		
		ProfileRequest profileRequest = new ProfileRequest
										.Builder()
										.firstName("Scott")
										.lastName("Markham")
										.email("rpcoc908@gmail.com")
										.mobileNumber("0987654321")
										.build();		
		response = userService.updateProfile(token, profileRequest);
		System.out.println(response.asPrettyString());
	}
}
