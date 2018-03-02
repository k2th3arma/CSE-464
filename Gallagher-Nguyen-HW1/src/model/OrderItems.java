package model;

public class OrderItems {

	private int itemID;
	private int orderID;
	private int showingID;
	private int count;
	
	public OrderItems(){
		super();
	}

	public OrderItems(int orderID, int showingID, int count) {
		this.orderID = orderID;
		this.showingID = showingID;
		this.count = count;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getShowingID() {
		return showingID;
	}

	public void setShowingID(int showingID) {
		this.showingID = showingID;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
