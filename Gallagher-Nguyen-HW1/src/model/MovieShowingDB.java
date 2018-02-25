package model;

public class MovieShowingDB {

	public MovieShowing GetMovieShowing(String title){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	MovieShowing movie = db.returnMovieShowingByTitle(title);
    	db.closeConnection();
    	
    	return movie;
	}
}
