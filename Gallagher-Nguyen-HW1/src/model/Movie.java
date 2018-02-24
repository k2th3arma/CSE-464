package model;

public class Movie {
	private String title;
	private String year;
	private String length;
	private String mpaa;
	private String description;
	private String genre;
	
	public Movie(){
		super();
	}
	public Movie(String title, String year, String length, String mpaa, String description, String genre){
		this.title = title;
		this.year = year;
		this.length = length;
		this.mpaa = mpaa;
		this.description = description;
		this.genre = genre;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getMpaa() {
		return mpaa;
	}
	public void setMpaa(String mpaa) {
		this.mpaa = mpaa;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String toString(){
		return title +" "+ year +" "+ length +" "+ mpaa +" "+ description +" "+genre;
	}
	
}
