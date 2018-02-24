package model;

public class Theatre {
	private String name;
	private Address address;
	private String owner;
	private String roomCount;
	
	public Theatre(){
		super();
	}
	public Theatre(String name, Address address, String owner, String roomCount){
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.roomCount = roomCount;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getRoomCount() {
		return roomCount;
	}	
	public void setRoomCount(String roomCount) {
		this.roomCount = roomCount;
	}
	@Override
	public String toString(){
		return name +", "+ address.toString() +" "+owner+" "+roomCount;
	}
}
