package com.diaspark.INB.DTO;

import javax.validation.constraints.NotEmpty;

/*
  DTO class accept as input and all input validation to be done here in this class
 */
public class RegisterUserDTO {
	
	//private long customerId; Removing this field from DTO ,as it will be generated by hibernate .We don't require it in input

	@NotEmpty(message="Please provide your first name")
	private String firstName;

	@NotEmpty(message="Please provide your last name")
	private String lastName;
	@NotEmpty(message="Please provide your user name")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotEmpty(message="Please provide your password")
	private String password;

	@NotEmpty(message="Please provide your address")
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;

	@NotEmpty(message="Please provide your city")
	private String city;

	@NotEmpty(message="Please provide your state")
	private String state;

	@NotEmpty(message="Please provide your zipcode")
	private int zip;

	private String phone;

	@NotEmpty(message="Please provide your mobile number")
	private String mobile;

	@NotEmpty(message="Please provide your email")
	private String email;
	private String accountType;

	private boolean admin;

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	
}
