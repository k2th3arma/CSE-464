package model;

import model.Showroom;
import model.Movie;

public class MovieShowing {

	private Movie movie;
	private Showroom showroom;
	private int seatSold;
	private int seatCount;
	private String price;
	private String startTime;
	private String endTime;
	
	public MovieShowing(){
		super();
	}
	
	public MovieShowing(Movie movie, Showroom showroom, int seatSold, int seatCount, String price, String startTime, String endTIme){
		this.movie = movie;
		this.showroom = showroom;
		this.seatSold = seatSold;
		this.seatCount = seatCount;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Showroom getShowroom() {
		return showroom;
	}

	public void setShowroom(Showroom showroom) {
		this.showroom = showroom;
	}
	
	public int getSeatSold() {
		return seatSold;
	}

	public void setSeatSold(int seatSold) {
		this.seatSold = seatSold;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	@Override
	public String toString(){
		return "{"+movie +"} {"+ showroom +"} "+ seatSold +" "+ seatCount +" "+ price +" "+ startTime +" "+ endTime;
	}
	
}
