package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import util.Utilities;
	
	
public class Accessor {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		
		// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/rgallagher";
		
		//  Database credentials
		static final String USER = "rgallagher"; 
		static final String PASS = "9RaFi8";   
		
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
		
		public Transaction GetTransactionByID(int ID){
			String SQL = "SELECT * FROM Transaction;";
		    Statement stat;
		   
		    Transaction transaction = new Transaction();
		    
		    Utilities util = new Utilities();
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(ID == rs.getInt(1)) {
						transaction.setCardNumber(rs.getString(2));
						transaction.setMonth(rs.getString(3));
						transaction.setYear(rs.getString(4));
						transaction.setUser(GetUserByID(rs.getInt(5)));
						transaction.setAddress(util.splitDBEntry(rs.getString(6), transaction.getUser().getUserName()));
						transaction.setCode(rs.getInt(7));
												
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return transaction;
			
			
		}
		
		public Transaction GetTransactionByUser(String userName){
			String SQL = "SELECT * FROM Transaction;";
		    Statement stat;
		   
		    Transaction transaction = new Transaction();
		    
		    Utilities util = new Utilities();
		    
		    int ID = GetUserIDByName(userName);
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					
					if(ID == rs.getInt(5)) {
						transaction.setCardNumber(rs.getString(2));
						transaction.setMonth(rs.getString(3));
						transaction.setYear(rs.getString(4));
						transaction.setUser(GetUserByID(rs.getInt(5)));
						transaction.setAddress(util.splitDBEntry(rs.getString(6), transaction.getUser().getUserName()));
						transaction.setCode(rs.getInt(7));
												
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return transaction;
			
			
		}
		
		public void addTransaction(Transaction transaction){
			try{
				stmt = conn.createStatement();
				String sql;
				String cardNumber = transaction.getCardNumber();
				String month = transaction.getMonth();
				String year = transaction.getYear();
				int user_ID = GetUserIDByName(transaction.getUser().getUserName());
				String address = transaction.getAddress().toString();
				int code = transaction.getCode();
						
				
				sql = "INSERT INTO Transaction (card_number, month, year, user_id, address, code)"+
						"VALUES ('" + cardNumber +
						"', '" + month +
						"', '" + year +
						"', '" + user_ID +
						"', '" + address +
						"', '" + code +
						 "')";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
		}
		
		public Review returnReviewByTitle(String title) {
			String SQL = "SELECT * FROM Review;";
		    Statement stat;
		   
		    Review review = new Review();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(title.equals( rs.getString(5) )) {
						review.setDescription(rs.getString(2));
						review.setRating(rs.getInt(3));
						review.setUser(GetUserByID(rs.getInt(4)));
						review.setMovie(returnMovieByTitle(rs.getString(5)));
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return review;
		}
		
		public int GetUserIDByName(String userName){
			String SQL = "SELECT * FROM Users;";
		    Statement stat;
		   
		    Users user = new Users();
		    int value = 0;
		    Utilities util = new Utilities();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(userName.equals(rs.getString(4))) {
						value = rs.getInt(1);
						
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return value;
		}
		
		public Users GetUserByID(int ID){
			String SQL = "SELECT * FROM Users;";
		    Statement stat;
		   
		    Users user = new Users();
		    
		    Utilities util = new Utilities();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(ID == rs.getInt(1)) {
						user.setFirstName(rs.getString(2));
						user.setLastName(rs.getString(3));
						user.setUserName(rs.getString(4));
						user.setPassword(rs.getString(5));
						user.setPhone(rs.getString(6));
						user.setAddress(util.splitDBEntry(rs.getString(7), rs.getString(4)));
						user.setEmail(rs.getString(8));
						user.setType(rs.getString(9));
						
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return user;
			
			
		}
		
		public MovieShowing returnMovieShowingByTitle(String title) {
			String SQL = "SELECT * FROM MovieShowing;";
		    Statement stat;
		   
		    MovieShowing movie = new MovieShowing();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(title.equals( rs.getString(2) )) {
						movie.setMovie(returnMovieByTitle(rs.getString(2)));
						movie.setShowroom(GetShowroomByID(rs.getInt(3)));
						movie.setSeatSold(rs.getInt(4));
						movie.setSeatCount(rs.getInt(5));
						movie.setPrice(rs.getString(6));
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return movie;
		}
		
		public void addShowroom(Showroom showroom){

			try{
				stmt = conn.createStatement();
				String sql;
				String theatre = showroom.getTheatre();
				int capacity = showroom.getCapacity();
				int roomNumber = showroom.getRoomNumber();
				
				sql = "INSERT INTO Theatre (theatre, capacity, room_number)"+
						"VALUES ('" + theatre +
						"', '" + capacity +
						"', '" + roomNumber +
						 "')";			
					
				
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public Showroom GetShowroomByID(int ID){
			String SQL = "SELECT * from Showroom";
		    Statement stat;   		    
		    
		    Showroom showroom = new Showroom();		
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					if(ID == rs.getInt(1) ) {
						//showroom = new Showroom(rs.getString(2),rs.getInt(3),rs.getInt(4));
						showroom.setTheatre(rs.getString(2));
						showroom.setCapacity(rs.getInt(3));
						showroom.setRoomNumber(rs.getInt(4));
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return showroom;
		}
		
		public ArrayList<Showroom> getShowroomByTheatre(String theatre) {
			String SQL = "SELECT * from Showroom";
		    Statement stat;   		    
		    
		    ArrayList<Showroom> showrooms = new ArrayList<Showroom>();		
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					if(theatre.equals( rs.getString(2) )) {
						Showroom showroom = new Showroom(rs.getString(2),rs.getInt(3),rs.getInt(4));
						showrooms.add(showroom);
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return showrooms;
		}	
		
		public void addTheatre(Theatre theatre){

			try{
				stmt = conn.createStatement();
				String sql;
				String name = theatre.getName();
				String owner = theatre.getOwner();
				String address = theatre.getAddress().toString();
				String roomCount = theatre.getRoomCount();
				
				
				
				sql = "INSERT INTO Theatre (name, owner, address, theatre_rooms)"+
						"VALUES ('" + name +
						"', '" + owner +
						"', '" + address +
						"', '" + roomCount +
						 "')";			
					
				
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		public Theatre returnTheatreByName(String name) {
			String SQL = "SELECT * from Theatres";
		    Statement stat;
		   
		    Theatre theatre = new Theatre();
		    Utilities util = new Utilities();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					if(name.equals( rs.getString(1) )) {
						theatre.setName(rs.getString(1));
						theatre.setOwner(rs.getString(2));
						theatre.setAddress(util.splitDBEntry(rs.getString(3), rs.getString(2)));
						theatre.setRoomCount(rs.getString(4));
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return theatre;
		}		
		
		public void addMovie(Movie movie){

			try{
				stmt = conn.createStatement();
				String sql;
				String title = movie.getTitle();
				String year = movie.getYear();
				String length = movie.getLength();
				String mpaa = movie.getMpaa();
				String description = movie.getDescription();
				String genre = movie.getGenre();
				
				sql = "INSERT INTO Movie (title, year, length, mpaa, description, genre)"+
						"VALUES ('" + title +
						"', '" + year +
						"', '" + length +
						"', '" + mpaa +
						"', '" + description +
						"', '" + genre +
						 "')";			
					
				
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		public Movie returnMovieByTitle(String title) {
			String SQL = "SELECT * from Movies";
		    Statement stat;
		   
		    Movie movie = new Movie();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					if(title.equals( rs.getString(1) )) {
						movie.setTitle(rs.getString(1));
						movie.setYear(rs.getString(2));
						movie.setLength(rs.getString(3));
						movie.setMpaa(rs.getString(4));
						movie.setDescription(rs.getString(5));
						movie.setGenre(rs.getString(6));
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return movie;
		}
		
		public ArrayList<Movie> returnMovieByYear(String year) {
			String SQL = "SELECT * from Movies";
		    Statement stat;   
		    
		    
		    ArrayList<Movie> movies = new ArrayList<Movie>();		
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					if(year.equals( rs.getString(2) )) {
						Movie movie = new Movie(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6) );
						movies.add(movie);
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return movies;
		}
		
		public ArrayList<Movie> returnMovieByLength(String length) {
			String SQL = "SELECT * from Movies";
		    Statement stat;   
		    
		    
		    ArrayList<Movie> movies = new ArrayList<Movie>();		
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					if(length.equals( rs.getString(3) )) {
						Movie movie = new Movie(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6) );
						movies.add(movie);
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return movies;
		}

		public ArrayList<Movie> returnMovieByMpaa(String mpaa) {
			String SQL = "SELECT * from Movies";
		    Statement stat;   
		    
		    
		    ArrayList<Movie> movies = new ArrayList<Movie>();		
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					if(mpaa.equals( rs.getString(4) )) {
						Movie movie = new Movie(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6) );
						movies.add(movie);
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return movies;
		}

		public ArrayList<Movie> returnMovieByGenre(String genre) {
			String SQL = "SELECT * from Movies";
		    Statement stat;   
		    
		    
		    ArrayList<Movie> movies = new ArrayList<Movie>();		
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					if(genre.equals( rs.getString(6) )) {
						Movie movie = new Movie(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6) );
						movies.add(movie);
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return movies;
		}
		
		public void addAddress(Address address){
			try{
				stmt = conn.createStatement();
				String sql;
				String street = address.getStreet();
				String city = address.getCity();
				String state = address.getState();
				String zip = address.getZip();
				String user = address.getUser();
				
				sql = "INSERT INTO Address (street, city, state, zip, user)"+
						"VALUES ('" + street +
						"', '" + city +
						"', '" + state +
						"', '" + zip +
						"', '" + user +
						 "')";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
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
			  String email = aUser.getEmail();
			  String phone = aUser.getPhone();
			  String address = aUser.getAddress().toString();
			  String type = aUser.getType();
			  

			  sql = "INSERT INTO Users (First_Name, Last_Name, User_Name, Password, phone_number, address, email, type)" +
			          "VALUES ('" + firstName +
					  "', '" + lastName + 
					  "', '" + userName + 
					  "', '" + password + 
					  "', '" + phone +
					  "', '" + address +
					  "', '" + email +
					  "', '" + type +
					  "')";
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
			        		+ " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7)
			        		+ " " + rs.getString(8) + " " + rs.getString(9));
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
