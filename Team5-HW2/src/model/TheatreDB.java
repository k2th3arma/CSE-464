package model;

import model.Theatre;
import model.Accessor;
import java.util.*;

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
    
    public ArrayList<Theatre> getTheatres(int ID){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	ArrayList<Theatre> theatre = db.GetTheatresByOwnerID(ID);
    	db.closeConnection();
    	
    	return theatre;
    }
    
    public ArrayList<Theatre> getAllTheatres(){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	ArrayList<Theatre> theatre = db.GetTheatres();
    	db.closeConnection();
    	
    	return theatre;
    }
    
    public String getTheatreName(int ID){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	String theatre = db.GetTheatreName(ID);
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
