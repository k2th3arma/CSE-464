package model;

import java.util.*;

import model.Movie;
import model.Accessor;

public class MovieDB {

    public void addMovie(Movie movie) {
       	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.addMovie(movie);
       	db.closeConnection();
    }
    
    public Movie getMovie(String title){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	Movie movie = db.returnMovieByTitle(title);
    	db.closeConnection();
    	
    	return movie;
    }
    public ArrayList<Movie> getMovieByYear(String year){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	ArrayList<Movie> movie = db.returnMovieByYear(year);
    	db.closeConnection();
    	
    	return movie;
    }
    public ArrayList<Movie> getMovieByLength(String length){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	ArrayList<Movie> movie = db.returnMovieByLength(length);
    	db.closeConnection();
    	
    	return movie;
    }
    public ArrayList<Movie> getMovieByMpaa(String mpaa){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	ArrayList<Movie> movie = db.returnMovieByMpaa(mpaa);
    	db.closeConnection();
    	
    	return movie;
    }
    public ArrayList<Movie> getMovieByGenre(String genre){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	ArrayList<Movie> movie = db.returnMovieByGenre(genre);
    	db.closeConnection();
    	
    	return movie;
    }
}
