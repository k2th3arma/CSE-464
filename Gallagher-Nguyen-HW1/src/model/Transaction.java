package model;

public class Transaction {

	private String cardNumber;
	private String month;
	private String year;
	private String expiration;
	private Users user;
	private Address address;
	private int code;
	
	public Transaction(){
		super();
	}
	
	public Transaction(String cardNumber, String month, String year, Users user, Address address, int code){
		this.cardNumber = cardNumber;
		this.month = month;
		this.year = year;
		this.expiration = month +"/"+ year;
		this.user = user;
		this.address = address;
		this.code = code;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getExpiration() {
		return this.month + "/" + this.year;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString(){
		return cardNumber +" "+ month +"/"+ year +" {"+ user +"} {"+ address +"} "+ code;
	}
	
	
}
