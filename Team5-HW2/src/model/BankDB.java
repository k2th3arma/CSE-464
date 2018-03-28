package model;

import java.util.ArrayList;

public class BankDB {
	//Add Method	
		public void addBank(Bank bank) {
	       	Accessor db = new Accessor();
	       	db.connectMeIn();
	       	db.addBank(bank);
	       	db.closeConnection();
	    }
	    
		//Get Method
	    
	    public Bank getBankByNumber(String number){
	    	Accessor db = new Accessor();
	    	db.connectMeIn();
	    	Bank bank = db.GetBankByNumber(number);
	    	db.closeConnection();
	    	
	    	return bank;
	    	
	    }
	    public Bank getBankByID(int ID){
	    	Accessor db = new Accessor();
	    	db.connectMeIn();
	    	Bank bank = db.GetBankByID(ID);
	    	db.closeConnection();
	    	
	    	return bank;
	    	
	    }

	    //Update Method
	    public void updateBank(Bank bank) {
	       	Accessor db = new Accessor();
	       	db.connectMeIn();
	       	db.updateBank(bank);
	       	db.closeConnection();
	    }
	    
	    //Remove Method
	    public void removeBank(Bank bank) {
	       	Accessor db = new Accessor();
	       	db.connectMeIn();
	       	db.removeBank(bank);
	       	db.closeConnection();
	    }
}
