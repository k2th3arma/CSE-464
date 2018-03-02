package model;

public class Movie {
	private int movieID;
	private String title;
	private String description;
	private String thumbnail;
	private String rating;
	
	public Movie(){
		super();
	}
	public Movie(String title, String description, String thumbnail, String rating){
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.rating = rating;
	
	}
	
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
}
