package model;

public class TransactionDB {

	//Add Method
	public void addTranaction(Transaction transaction){
		Accessor db = new Accessor();
       	db.connectMeIn();
       	db.addTransaction(transaction);
       	db.closeConnection();
	}
	
	//Get Methods
	public Transaction GetTransactionByID(int ID){
    	Accessor db = new Accessor();
       	db.connectMeIn();
       	Transaction transaction = db.GetTransactionByID(ID);
       	db.closeConnection();
       	
       	return transaction;
    }
    
    public Transaction GetTransactionByUserID(int ID){
    	Accessor db = new Accessor();
       	db.connectMeIn();
       	Transaction transaction = db.GetTransactionByUserID(ID);
       	db.closeConnection();
       	
       	return transaction;
    }
    
    //Update Methods
    public void updateTranaction(Transaction transaction){
		Accessor db = new Accessor();
       	db.connectMeIn();
       	db.updateTransaction(transaction);
       	db.closeConnection();
	}
    
    //Remove Methods
    public void removeTranaction(Transaction transaction){
		Accessor db = new Accessor();
       	db.connectMeIn();
       	db.removeTransaction(transaction);
       	db.closeConnection();
	}
}
