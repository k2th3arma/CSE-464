package model;

public class TransactionDB {

	
	public void addTranaction(Transaction transaction){
		Accessor db = new Accessor();
       	db.connectMeIn();
       	db.addTransaction(transaction);
       	db.closeConnection();
	}
	
	public Transaction GetTransactionByID(int ID){
    	Accessor db = new Accessor();
       	db.connectMeIn();
       	Transaction transaction = db.GetTransactionByID(ID);
       	db.closeConnection();
       	
       	return transaction;
    }
    
    public Transaction GetTransactionByUser(String userName){
    	Accessor db = new Accessor();
       	db.connectMeIn();
       	Transaction transaction = db.GetTransactionByUser(userName);
       	db.closeConnection();
       	
       	return transaction;
    }
}
