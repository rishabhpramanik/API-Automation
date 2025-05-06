package com.api.models.requests;

public class SignupRequest {
	private String username;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	
	public SignupRequest(String username, String email, String password, String firstName,
			String lastName, String mobileNumber) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
		
	public static class Builder{
		private String username;
		private String email;
		private String password;
		private String firstName;
		private String lastName;
		private String mobileNumber;
		
		public Builder userName(String username) {
			this.username = username;
			return this; // Return the current object of Builder class
		}
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public Builder mobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}
		
		public SignupRequest build() {
			SignupRequest signupRequest = new SignupRequest(username, password, email, firstName, lastName,
					mobileNumber);
			return signupRequest;
		}
	}
}
