package com.example.model;


public class Address {

	private String postcode;
	
	private String street;
	
	private String state;

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address{" +
				"postcode='" + postcode + '\'' +
				", street='" + street + '\'' +
				", state='" + state + '\'' +
				'}';
	}
}
