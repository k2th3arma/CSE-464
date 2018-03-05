package model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShoppingCart {
	private String movieName;
	private int movieID;
	private int tickets;
	private int userID;
	private BufferedImage image;
	private String theatreName;
	private String startTime;
	private int price;
	
	public ShoppingCart(){
		super();
	}

	public ShoppingCart(String movieName, int movieID, int tickets, int userID,
			BufferedImage image, String theatreName, String startTime, int price) {
		this.movieName = movieName;
		this.movieID = movieID;
		this.tickets = tickets;
		this.userID = userID;
		this.image = image;
		this.theatreName = theatreName;
		this.startTime = startTime;
		this.price = price;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		BufferedImage img = null;
		try {
		img = ImageIO.read(new ByteArrayInputStream(image));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		this.image = img;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
