package model;

public class Theatre {
	private int theatreID;
	private String name;
	private String address;
	private int owner;
	private String city;
	private String state;
	private String postalCode;
	
	public Theatre(){
		super();
	}
	public Theatre(String name, String address, int owner, String city, String state, String postalCode){
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		
	}
	public int getTheatreID() {
		return theatreID;
	}
	public void setTheatreID(int theatreID) {
		this.theatreID = theatreID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
}
