package model;

public class ReviewDB {

	
	public Review GetReviewByMovie(String title){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	Review review = db.returnReviewByTitle(title);
    	db.closeConnection();
    	
    	return review;
	}
	
	public void addReview(Review review){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	db.addReview(review);
    	db.closeConnection();
	}
}
