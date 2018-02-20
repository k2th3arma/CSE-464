package model;

import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	
	
public class Accessor {

	

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		
		// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		//static final String DB_URL = "jdbc:mysql://localhost/MVCApp"; 
		final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/rgallagher";
		//final String DB_URL ="rgallagher@cse.unl.edu:3306";
		

		//  Database credentials
		static final String USER = "rgallagher"; // Replace with your CSE_LOGIN
		static final String PASS = "9RaFi8";   // Replace with your CSE MySQL_PASSWORD
		
		public void createUsersTable() {
			  
			try {
			  stmt = conn.createStatement();
			
			  String sql;
			  sql = "DROP TABLE IF EXISTS Users";
			  stmt.executeUpdate(sql);

			  sql = "CREATE TABLE Users " +
			          "(ID INT NOT NULL AUTO_INCREMENT," +
			          " First_Name VARCHAR(255), " + 
			          " Last_Name VARCHAR(255), " + 
			          " User_Name VARCHAR(255), " + 
			          " Password VARCHAR(255)," +
			          "PRIMARY KEY(ID))"; 

			  stmt.executeUpdate(sql);

//			  sql = "INSERT INTO Users (First_Name, Last_Name, User_Name, Password)" +
//			          "VALUES ('Richard', 'Feynman', 'feynman', '1234')";
//			  stmt.executeUpdate(sql);
			  
			  
			  } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			
		}
		
		
		public void addSingleUser(Users aUser) {
			  
			try {
			  stmt = conn.createStatement();
			  String sql;
			  
			  String firstName = aUser.getFirstName();
			  String lastName = aUser.getLastName();
			  String userName = aUser.getUserName();
			  String password = aUser.getPassword();
			  

			  sql = "INSERT INTO Users (First_Name, Last_Name, User_Name, Password)" +
			          "VALUES ('" + firstName +
					  "', '" + lastName + 
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
					if(aUserName.equals( rs.getString(4) )) {
						aUser.setFirstName(rs.getString(2));
						aUser.setLastName(rs.getString(3));
						aUser.setUserName(rs.getString(4));
						aUser.setPassword(rs.getString(5));
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
			        System.out.println(rs.getString(1) + " " + rs.getString(2) +  " " + rs.getString(3)
			        		+ " " + rs.getString(4) + " " + rs.getString(5));
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
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
