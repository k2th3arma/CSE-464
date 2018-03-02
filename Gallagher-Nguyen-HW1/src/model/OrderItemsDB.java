package model;

public class OrderItemsDB {

	//Add Method
	public void addOrderItems(OrderItems order){
		Accessor db = new Accessor();
       	db.connectMeIn();
       	db.addOrderItems(order);
       	db.closeConnection();
	}
	
	//Get Methods
	public OrderItems GetOrderItemsByID(int ID){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	OrderItems order = db.GetOrderItemsByID(ID);
    	db.closeConnection();
    	
    	return order;
		
	}
	
	public OrderItems GetOrdersItemsByUser(int ID){
		Accessor db = new Accessor();
    	db.connectMeIn();
    	OrderItems order = db.GetOrderItemsByOrder(ID);
    	db.closeConnection();
    	
    	return order;
	}
	
	//Update Method
	public void updateOrder(OrderItems order){
		Accessor db = new Accessor();
       	db.connectMeIn();
       	db.UpdateOrderItems(order);
       	db.closeConnection();
	}
	
	//Remove Method
	public void removeOrder(OrderItems order){
		Accessor db = new Accessor();
       	db.connectMeIn();
       	db.removeOrderItems(order);
       	db.closeConnection();
	}
}
