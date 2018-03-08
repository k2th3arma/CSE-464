package model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SearchModel {
	private String movieName;
	private String theatreName;
	private int theatreNumber;
	private String startTime;
	private String endTime;
	private int availableSeats;
	private int price;
	private BufferedImage image;
	private int movieID;
	
	public SearchModel(){
		super();
	}

	public SearchModel(String movieName, String theatreName, int theatreNumber,
			String startTime, String endTime, int availableSeats, int price,
			BufferedImage image) {
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.theatreNumber = theatreNumber;
		this.startTime = startTime;
		this.endTime = endTime;
		this.availableSeats = availableSeats;
		this.price = price;
		this.image = image;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
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

	public int getTheatreNumber() {
		return theatreNumber;
	}

	public void setTheatreNumber(int theatreNumber) {
		this.theatreNumber = theatreNumber;
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

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
	
	
}
