package model;

public class Order {

	private int orderNumber;
	private Users user;
	private Address address;
	private String orderTotal;
	private int count;
	private MovieShowing movie;
	private String status;
	
	public Order(){
		super();
	}
	
	public Order(int orderNumber, Users user, Address address, String orderTotal, int count, MovieShowing movie, String status){
		this.orderNumber = orderNumber;
		this.user = user;
		this.address = address;
		this.orderTotal = orderTotal;
		this.count = count;
		this.movie = movie;
		this.status = status;
	}

	
	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
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

	public String getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public MovieShowing getMovie() {
		return movie;
	}

	public void setMovie(MovieShowing movie) {
		this.movie = movie;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString(){
		return "{" + user +"} {"+ address +"} "+ orderTotal +" "+ count +" {"+ movie +"} "+ status;
	}
	
}
