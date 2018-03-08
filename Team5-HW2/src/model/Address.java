package model;

public class Address {
	
	private String street;
	private String city;
	private String state;
	private String zip;
	private String user;
	
	public Address(){
		super();
	}
	public Address(String street, String city, String state, String zip, String user){
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.user = user;
	}
	public String getUser(){
		return user;
	}
	public void setUser(String user){
		this.user = user;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Override
	public String toString(){
		return street +","+ city +","+ state +","+ zip;
	}
	
}
