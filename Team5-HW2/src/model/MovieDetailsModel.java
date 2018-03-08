package model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MovieDetailsModel {
	
	private String movieName;
	private String description;
	private String rating;
	private BufferedImage image;
	private String theatreName;
	private int showroomID;
	private String startTime;
	private String endTime;
	private int availableSeats;
	private int price;
	private int movieID;
	
	public MovieDetailsModel(){
		super();
	}

	public MovieDetailsModel(String movieName, String description,
			String rating, BufferedImage image, String theatreName,
			int showroomNumber, String startTime, String endTime,
			int availableSeats, int price, int movieID) {
		this.movieName = movieName;
		this.description = description;
		this.rating = rating;
		this.image = image;
		this.theatreName = theatreName;
		this.showroomID = showroomNumber;
		this.startTime = startTime;
		this.endTime = endTime;
		this.availableSeats = availableSeats;
		this.price = price;
		this.movieID = movieID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
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

	public int getShowroomID() {
		return showroomID;
	}

	public void setShowroomID(int showroomNumber) {
		this.showroomID = showroomNumber;
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

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	
	
	
}
