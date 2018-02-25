package model;

public class Review {

	private String description;
	private int rating;
	private Users user;
	private Movie movie;
	
	public Review(){
		super();
	}
	
	public Review(String description, int rating, Users user,  Movie movie ){
		this.description = description;
		this.rating = rating;
		this.user = user;
		this.movie = movie;
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	@Override
	public String toString(){
		return description +" "+ rating +" {"+ user +"} {"+ movie + "}";
	}
	
	
}
