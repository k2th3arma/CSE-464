package model;

public class ManageOrder {
	private int orderID;
	private String movieName;
	private String theatreName;
	private int tickets;
	private int total;
	private String date;
	private String startTime;
	
	public ManageOrder(){
		super();
	}

	public ManageOrder(String movieName, String theatreName, int tickets,
			int total, String date, String startTime) {
		super();
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.tickets = tickets;
		this.total = total;
		this.date = date;
		this.startTime = startTime;
	}
	
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
}
