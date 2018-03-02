package model;

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
