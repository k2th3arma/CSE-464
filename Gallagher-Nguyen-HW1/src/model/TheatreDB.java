package model;

import java.util.*;

import model.Theatre;
import model.Accessor;

public class TheatreDB {
	
	public void addTheatre(Theatre theatre) {
       	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.addTheatre(theatre);
       	db.closeConnection();
    }
    
    public Theatre getTheatre(String name){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	Theatre theatre = db.returnTheatreByName(name);
    	db.closeConnection();
    	
    	return theatre;
    }
}
