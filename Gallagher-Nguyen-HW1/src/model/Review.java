package model;

public class Review {
	private int reviewID;
	private int movieID;
	private int userID;
	private String userName;
	private String date;
	private int rating;
	private String description;
	
	public Review(){
		super();
	}
	
	public Review(int movieID, int userID, String date, int rating, String description){
		this.movieID = movieID;
		this.userID = userID;
		this.description = description;
		this.rating = rating;
		this.date = date;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	
	
	
}
