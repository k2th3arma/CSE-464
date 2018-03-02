package model;

import model.Theatre;
import model.Accessor;

public class TheatreDB {
	
	//Add method
	public void addTheatre(Theatre theatre) {
       	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.addTheatre(theatre);
       	db.closeConnection();
    }
    
	//Get Method
    public Theatre getTheatre(String name){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	Theatre theatre = db.returnTheatreByName(name);
    	db.closeConnection();
    	
    	return theatre;
    }

    //Update Method
    public void updateTheatre(Theatre theatre) {
       	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.updateTheatre(theatre);
       	db.closeConnection();
    }
    
    //Remove Method
    public void removeTheatre(Theatre theatre) {
       	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.removeTheatre(theatre);
       	db.closeConnection();
    }
}
