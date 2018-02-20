package model;

import model.Accessor;
import model.Users;

public class UsersDB {
	

    public void registerUser(Users aUser) {
       	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.addSingleUser(aUser);
       	db.closeConnection();
    }
    
    public boolean validateUserByUsername(String aUserName) {
    	    boolean userExists = false;
    	    Accessor db = new Accessor();
       	db.connectMeIn();
       	userExists = db.findUserByUsername(aUserName);
       	db.closeConnection();
       	
       	return userExists;
    }
    
    public boolean validateUserByPassword(String password) {
	    boolean passwordMatches = false;
	    Accessor db = new Accessor();
   	    db.connectMeIn();
   	    passwordMatches = db.findUserByPassword(password);
   	    db.closeConnection();
   	
   	    return passwordMatches;
    }
    
    
    public Users getUser(String aUserName) {   
    	Accessor db = new Accessor();
	   	db.connectMeIn();
	   	Users aUser = db.returnUserByUsername(aUserName);
	   	db.closeConnection();
	   	
	   	return aUser;
    }

}
