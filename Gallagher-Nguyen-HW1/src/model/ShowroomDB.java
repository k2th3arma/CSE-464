package model;

import java.util.*;

public class ShowroomDB {

	public void addShowroom(Showroom showroom) {
       	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.addShowroom(showroom);
       	db.closeConnection();
    }
    
    public ArrayList<Showroom> getShowroom(String theatre){
    	Accessor db = new Accessor();
    	db.connectMeIn();
    	ArrayList<Showroom> showroom = db.getShowroomByTheatre(theatre);
    	db.closeConnection();
    	
    	return showroom;
    }
}
