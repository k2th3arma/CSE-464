package model;

public class Showroom {
	private int showroomID;
	private int seats;
	private int theatre;
	
	public Showroom(){
		super();
	}
	
	public Showroom(int seats, int theatre){
		this.theatre = theatre;
		this.seats = seats;
	}
	public int getShowroomID() {
		return showroomID;
	}
	public void setShowroomID(int showroomID) {
		this.showroomID = showroomID;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getTheatre() {
		return theatre;
	}
	public void setTheatre(int theatre) {
		this.theatre = theatre;
	}

	
	
}
