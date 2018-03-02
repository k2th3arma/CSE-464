package model;

public class MovieShowing {
	private int showingID;
	private int price;
	private int numberPurchased;
	private String startTime;
	private String endTime;
	private int movieID;
	private int showroomID;
	
	public MovieShowing(){
		super();
	}
	
	public MovieShowing(int price, int numberPurchased, String startTime, String endTime, int movieID, int showroomID){
		this.price = price;
		this.numberPurchased = numberPurchased;
		this.startTime = startTime;
		this.endTime = endTime;
		this.movieID = movieID;
		this.showroomID = showroomID;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumberPurchased() {
		return numberPurchased;
	}
	public void setNumberPurchased(int numberPurchased) {
		this.numberPurchased = numberPurchased;
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public int getShowroomID() {
		return showroomID;
	}
	public void setShowroomID(int showroomID) {
		this.showroomID = showroomID;
	}

	public int getShowingID() {
		return showingID;
	}

	public void setShowingID(int showingID) {
		this.showingID = showingID;
	}
	
	
	
}
