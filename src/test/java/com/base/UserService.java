package com.base;

import com.api.models.requests.ProfileRequest;

import io.restassured.response.Response;

public class UserService extends BaseService {
	private static String BASE_PATH = "/api/users/";
	
	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH + "profile");
	}
	
	public Response updateProfile(String token, ProfileRequest payload) {
		setAuthToken(token);
		return putRequest(payload, BASE_PATH + "profile");
	}
}
