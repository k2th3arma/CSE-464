package model;

import java.util.*;

public class OrderDB {

	//Add Method
	public void addOrder(Order order){
		Accessor db = new Accessor();
       	db.connectMeIn();
       	db.addOrder(order);
       	db.closeConnection();
	}
	
	//Get Methods
	public Order GetOrderByID(int ID){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	Order order = db.GetOrderByID(ID);
    	db.closeConnection();
    	
    	return order;
		
	}
	
	public ArrayList<Order> GetOrdersByUser(int ID){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	ArrayList<Order> order = db.GetOrdersByUser(ID);
    	db.closeConnection();
    	
    	return order;
	}
	
	//Update Methods
	public void updateOrder(Order order){
		Accessor db = new Accessor();
       	db.connectMeIn();
       	db.UpdateOrder(order);
       	db.closeConnection();
	}
	
	//Remove Method
	public void removeOrder(Order order){
		Accessor db = new Accessor();
       	db.connectMeIn();
       	db.removeOrder(order);
       	db.closeConnection();
	}
}
