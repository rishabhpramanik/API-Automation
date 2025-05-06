package com.base;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	private final static String BASE_URI = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;

	public BaseService() {
		// Setting the Base URI
		// It will be common for every request
		requestSpecification = given().baseUri(BASE_URI); 
	}
	
	// Setting the Authorization token
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}	
		
	// For Post Request
	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	// For Post Request, using Base URI directly
	protected Response postRequest(String base_url, Object payload, String endpoint) {
		return requestSpecification.baseUri(base_url).contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	// For Get request
	protected Response getRequest(String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).get(endpoint);
	}
	
	protected Response putRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
}
