package model;

import java.util.*;

public class OrderDB {

	public void addOrder(Order order){
		Accessor db = new Accessor();
       	db.connectMeIn();
       	db.addOrder(order);
       	db.closeConnection();
	}
	
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
}
