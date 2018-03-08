package model;

import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;

import model.Movie;
import model.Accessor;

public class MovieDB {

	//Add Methods
    public void addMovie(Movie movie) {
       	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.addMovie(movie);
       	db.closeConnection();
    }
    
    //Get Methods
    public Movie getMovie(String title){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	Movie movie = db.returnMovieByTitle(title);
    	db.closeConnection();
    	
    	return movie;
    }
    
    public byte[] getImage(int ID){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	byte[] movie = db.GetImageByID(ID);
    	db.closeConnection();
    	
    	return movie;
    }
    
    public Movie getMovieByMovieID(int ID){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	Movie movie = db.GetMovieByID(ID);
    	db.closeConnection();
    	
    	return movie;
    }
    
    public ArrayList<Movie> GetMovies(){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	ArrayList<Movie> movie = db.GetAllMovies();
    	db.closeConnection();
    	
    	return movie;
    }
    
    //Update Methods
    public void updateMovie(Movie movie){
    	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.updateMovie(movie);
       	db.closeConnection();
    }
    
    //Remove Methods
    public void removeMovie(Movie movie){
    	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.removeMovie(movie);
       	db.closeConnection();
    }
}
