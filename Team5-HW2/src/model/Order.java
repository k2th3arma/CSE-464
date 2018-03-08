package model;

public class Order {

	private int orderID;
	private int userID;
	private int cost;
	private String orderDate;
	private String address;
	private String cardNumber;
	private int showingID;
	private String tickets;
	
	public Order(){
		super();
	}

	public Order(int userID, int cost, String orderDate, String address, String cardNumber) {
		this.userID = userID;
		this.cost = cost;
		this.orderDate = orderDate;
		this.address = address;
		this.cardNumber = cardNumber;
	}
	
	public int getShowingID() {
		return showingID;
	}

	public void setShowingID(int showingID) {
		this.showingID = showingID;
	}

	public String getTickets() {
		return tickets;
	}

	public void setTickets(String tickets) {
		this.tickets = tickets;
	}

	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
	
}
