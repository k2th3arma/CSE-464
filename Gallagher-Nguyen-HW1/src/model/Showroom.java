package model;

public class Showroom {
	private String theatre;
	private int capacity;
	private int roomNumber;
	
	public Showroom(){
		super();
	}
	
	public Showroom(String theatre, int capacity, int roomNumber){
		this.theatre = theatre;
		this.capacity = capacity;
		this.roomNumber = roomNumber;
	}

	public String getTheatre() {
		return theatre;
	}

	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	@Override
	public String toString(){
		return theatre +", "+ capacity +", "+ roomNumber;
	}
	
}
