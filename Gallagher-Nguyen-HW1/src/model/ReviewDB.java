package model;

public class ReviewDB {

	//Add Methods
	public void addReview(Review review){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	db.addReview(review);
    	db.closeConnection();
	}
	
	//Get Methods
	public Review GetReviewByID(int ID){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	Review review = db.GetReviewByID(ID);
    	db.closeConnection();
    	
    	return review;
	}
	
	public Review GetReviewByMovieID(int ID){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	Review review = db.GetReviewByID(ID);
    	db.closeConnection();
    	
    	return review;
	}
	
	public Review GetReviewByShowro0m (int ID){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	Review review = db.GetReviewByID(ID);
    	db.closeConnection();
    	
    	return review;
	}
	
	//Update Methods
	public void updateReview(Review review){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	db.updateReview(review);
    	db.closeConnection();
	}
	
	//Remove Methods
	public void removeReview(Review review){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	db.removeReview(review);
    	db.closeConnection();
	}
	
}
