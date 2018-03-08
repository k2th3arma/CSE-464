package util;
import java.sql.*;

import model.Users;

public class Accessor {
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;

	private String user = "rgallagher";
	private String pass = "9RaFi8";
	private String DB_URL = "jdbc:mysql://cse.unl.edu:3306/rgallagher";
	
	public Accessor()
	{		
	}
	
	public void PopulateUsers() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver"); 
		conn = DriverManager.getConnection(DB_URL, user, pass);		
		
		
		Statement stmt = conn.createStatement();  		
		ResultSet rs = stmt.executeQuery("select * from Users");  
		
		
		while(rs.next())
		{  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		}
		conn.close(); 
	}
	
	public void addSingleUser(Users aUser) {
		  
		try {
		  stmt = conn.createStatement();
		  String sql;
		  
		  String userName = aUser.getUserName();
		  String password = aUser.getPassword();
		  

		  sql = "INSERT INTO Users (username, password)" +
		          "VALUES ('"  + 
				  "', '" + userName + 
				  "', '" + password + "')";
		  stmt.executeUpdate(sql);
		  
		  
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
	
	public boolean findUserByUsername(String aUserName) {
		boolean userExists = false;
		String SQL = "SELECT * from Users";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){	
				if(aUserName.equals( rs.getString(4) )) {
					userExists = true;
				}    
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userExists;
	}
	
	public boolean findUserByPassword(String password) {
		boolean passwordMatches = false;
		String SQL = "SELECT * from Users";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){	
				if(password.equals( rs.getString(5) )) {
					passwordMatches = true;
				}    
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return passwordMatches;
	}
	
	
	public Users returnUserByUsername(String aUserName) {
		String SQL = "SELECT * from Users";
	    Statement stat;
	   
	    Users aUser = new Users();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
				if(aUserName.equals( rs.getString(2) )) {
					aUser.setUserName(rs.getString(2));
					aUser.setPassword(rs.getString(3));
				} 
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aUser;
	}

	
	public void displayAllUsers() {
		String SQL = "SELECT * from Users";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
		        System.out.println(rs.getString(1) + " " + rs.getString(2) +  " " + rs.getString(3));
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void connectMeIn() {
		try{
			//Register the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit (-1);
		}
		try {
			 //Open a connection
			conn = DriverManager.getConnection(DB_URL, user, pass);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
}
