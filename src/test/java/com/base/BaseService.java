package com.base;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	private final static String BASE_URI = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URI);
	}
	
	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
}
