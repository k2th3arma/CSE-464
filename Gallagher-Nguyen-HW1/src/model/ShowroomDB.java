package model;

import java.util.*;

public class ShowroomDB {

	//Add Method	
	public void addShowroom(Showroom showroom) {
       	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.addShowroom(showroom);
       	db.closeConnection();
    }
    
	//Get Method
    public ArrayList<Showroom> getShowroom(int theatre){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	ArrayList<Showroom> showroom = db.getShowroomByTheatre(theatre);
    	db.closeConnection();
    	
    	return showroom;
    }
    
    public int getShowroomSeats(int ID){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	int showroom = db.GetShowroomSeats(ID);
    	db.closeConnection();
    	
    	return showroom;
    	
    }

    //Update Method
    public void updateShowroom(Showroom showroom) {
       	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.updateShowroom(showroom);
       	db.closeConnection();
    }
    
    //Remove Method
    public void removeShowroom(Showroom showroom) {
       	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.removeShowroom(showroom);
       	db.closeConnection();
    }
    
}
