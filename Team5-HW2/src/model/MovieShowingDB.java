package model;

public class MovieShowingDB {

	//Add Method
	public void addMovieShowing(MovieShowing movie){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	db.addMovieShowing(movie);
    	db.closeConnection();
	}
	//Get Method
	public MovieShowing GetMovieShowingByID(int ID){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	MovieShowing movie = db.GetMovieShowingByID(ID);
    	db.closeConnection();
    	
    	return movie;
	}
	
	public MovieShowing GetMovieShowingIDByMovieAndShowroom(int movieID, int showroomID){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	MovieShowing movie = db.GetMovieShowingIDByMovieAndShowroom(movieID, showroomID);
    	db.closeConnection();
    	
    	return movie;
	}
	
	public MovieShowing GetMovieShowingByMovie(int ID){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	MovieShowing movie = db.GetMovieShowingByMovie(ID);
    	db.closeConnection();
    	
    	return movie;
	}
	
	public MovieShowing GetMovieShowingByShowroom(int ID){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	MovieShowing movie = db.GetMovieShowingByShowroom(ID);
    	db.closeConnection();
    	
    	return movie;
	}

	//Update Method
	public void updateMovieShwoing(MovieShowing movie){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	db.updateMovieShowing(movie);
    	db.closeConnection();
	}
	
	//Remove Method
	public void removeMovieShwoing(MovieShowing movie){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	db.removeMovieShowing(movie);
    	db.closeConnection();
	}
	
}
