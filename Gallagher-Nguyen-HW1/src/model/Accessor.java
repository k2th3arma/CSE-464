package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
	
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
		
		
		//Connection Methods
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
		
		
		//User Methods
		public boolean findUserByUsername(String aUserName) {
			boolean userExists = false;
			String SQL = "SELECT * from Users";
		    Statement stat;
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){	
					if(aUserName.equals( rs.getString(14) )) {
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
			String SQL = "SELECT * from users";
		    Statement stat;
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){	
					if(password.equals( rs.getString(15) )) {
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
			String SQL = "SELECT * from users";
		    Statement stat;
		   
		    Users user = new Users();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					if(aUserName.equals( rs.getString(14) )) {
						user.setFirstName(rs.getString(2));
						user.setLastName(rs.getString(3));
						user.setAddress(rs.getString(4));
						user.setCity(rs.getString(5));
						user.setState(rs.getString(6));
						user.setPostalCode(rs.getString(7));
						user.setEmail(rs.getString(8));			
						user.setPhone(rs.getString(9));
						user.setBirthday(rs.getString(10));												
						user.setType(rs.getString(11));
						user.setStatus(rs.getInt(12));
						user.setNumberOfVisits(rs.getInt(13));						
						user.setUserName(rs.getString(14));
						user.setPassword(rs.getString(15));
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return user;
		}
	
		public void displayAllUsers() {
			String SQL = "SELECT * from users";
		    Statement stat;
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
			        System.out.println(rs.getString(1) + " " + rs.getString(2) +  " " + rs.getString(3)
			        		+ " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7)
			        		+ " " + rs.getString(8) + " " + rs.getString(9) );
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public int GetUserIDByName(String userName){
			String SQL = "SELECT * FROM users;";
		    Statement stat;
		   
		    int value = 0;
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(userName.equals(rs.getString(14))) {
						value = rs.getInt(1);
						
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return value;
		}
		
		public String GetUserNameByID(int ID){
			String SQL = "SELECT * FROM users;";
		    Statement stat;

		    String returnValue = "";
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(ID == rs.getInt(1)) {
						
						returnValue = rs.getString(14);
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return returnValue;
			
			
		}
		
		public Users GetUserByID(int ID){
			String SQL = "SELECT * FROM users;";
		    Statement stat;
		   
		    Users user = new Users();

			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(ID == rs.getInt(1)) {
						user.setFirstName(rs.getString(2));
						user.setLastName(rs.getString(3));
						user.setAddress(rs.getString(4));
						user.setCity(rs.getString(5));
						user.setState(rs.getString(6));
						user.setPostalCode(rs.getString(7));
						user.setEmail(rs.getString(8));			
						user.setPhone(rs.getString(9));
						user.setBirthday(rs.getString(10));												
						user.setType(rs.getString(11));
						user.setStatus(rs.getInt(12));
						user.setNumberOfVisits(rs.getInt(13));						
						user.setUserName(rs.getString(14));
						user.setPassword(rs.getString(15));
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return user;
			
			
		}
		
		public void addSingleUser(Users aUser) {
			  
			try {
			  stmt = conn.createStatement();
			  String sql;
			  
			  String firstName = aUser.getFirstName();
			  String lastName = aUser.getLastName();
			  String userName = aUser.getUserName();
			  String password = aUser.getPassword();
			  String address = aUser.getAddress();
			  String city = aUser.getCity();
			  String state = aUser.getState();
			  String postalCode = aUser.getPostalCode();
			  String email = aUser.getEmail();
			  String phone = aUser.getPhone();
			  String birthday = aUser.getBirthday(); 
			  String type = aUser.getType();
			  int status = aUser.getStatus();
			  int numberOfVisits = aUser.getNumberOfVisits();
			  

			  sql = "INSERT INTO users (FirstName, " + 
					  					"LastName, "
					  					+ "Address,"
					  					+ "City,"
					  					+ "State, "
					  					+ "PostalCode, "
					  					+ "EmailAddress, "
					  					+ "PhoneNumber, "
					  					+ "Birthday, "
					  					+ "Type,"
					  					+ "Status, "
					  					+ "NumOfVisits, "
					  					+ "Username, "
					  					+ "Password)" +
			          "VALUES ('" + firstName +
					  "', '" + lastName + 
					  "', '" + address + 
					  "', '" + city + 
					  "', '" + state +
					  "', '" + postalCode +
					  "', '" + email +
					  "', '" + phone +
					  "', '" + birthday +
					  "', '" + type +
					  "', '" + status +
					  "', '" + numberOfVisits +
					  "', '" + userName +
					  "', '" + password +
					  "')";
			  stmt.executeUpdate(sql);
			  
			  
			  } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			
		}
		
		public void updateSingleUser(Users aUser){
			try {
				  stmt = conn.createStatement();
				  String sql;
				  
				  int ID = aUser.getUserID();
				  String firstName = aUser.getFirstName();
				  String lastName = aUser.getLastName();
				  String userName = aUser.getUserName();
				  String password = aUser.getPassword();
				  String address = aUser.getAddress();
				  String city = aUser.getCity();
				  String state = aUser.getState();
				  String postalCode = aUser.getPostalCode();
				  String email = aUser.getEmail();
				  String phone = aUser.getPhone();
				  String birthday = aUser.getBirthday(); 
				  String type = aUser.getType();
				  int status = aUser.getStatus();
				  int numberOfVisits = aUser.getNumberOfVisits();
				  

				  sql = "Update users (FirstName, " + 
						  					"LastName, "
						  					+ "Address,"
						  					+ "City,"
						  					+ "State, "
						  					+ "PostalCode, "
						  					+ "EmailAddress, "
						  					+ "PhoneNumber, "
						  					+ "Birthday, "
						  					+ "Type,"
						  					+ "Status, "
						  					+ "NumOfVisits, "
						  					+ "Username, "
						  					+ "Password)" +
				          "VALUES ('" + firstName +
						  "', '" + lastName + 
						  "', '" + address + 
						  "', '" + city + 
						  "', '" + state +
						  "', '" + postalCode +
						  "', '" + email +
						  "', '" + phone +
						  "', '" + birthday +
						  "', '" + type +
						  "', '" + status +
						  "', '" + numberOfVisits +
						  "', '" + userName +
						  "', '" + password +
						  "') Where 'Id'='" + ID + "'";	
				  stmt.executeUpdate(sql);
				  
				  
				  } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				
		}
		
		public void removeSingleUser(Users aUser){
			try {
				  stmt = conn.createStatement();
				  String sql;
				  
				  int ID = aUser.getUserID();
				  
				  sql = "DELETE FROM users  Where 'Id'='" + ID + "'";	
				  
				  stmt.executeUpdate(sql);
				  
				  
				  } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
		}
		
		
		//Movie Methods
		public void addMovie(Movie movie){

			try{
				stmt = conn.createStatement();
				String sql;
				String title = movie.getTitle();
				String description = movie.getDescription();
				String thumbnail = movie.getThumbnail();
				String rating = movie.getRating();
				
				sql = "INSERT INTO movies (Movie name, Description, Thumbnail, Rating)"+
						"VALUES ('" + title +
						"', '" + description +
						"', '" + thumbnail +
						"', '" + rating +
						 "')";			
					
				
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		public Movie returnMovieByTitle(String title) {
			String SQL = "SELECT * from movies";
		    Statement stat;
		   
		    Movie movie = new Movie();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					if(title.equals( rs.getString(2) )) {
						movie.setMovieID(rs.getInt(1));
						movie.setTitle(rs.getString(2));
						movie.setDescription(rs.getString(3));
						movie.setThumbnail(rs.getString(4));
						movie.setRating(rs.getString(5));
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return movie;
		}
		
		public void updateMovie(Movie movie){
			try{
				stmt = conn.createStatement();
				String sql;
				int movieID = movie.getMovieID();
				String title = movie.getTitle();
				String description = movie.getDescription();
				String thumbnail = movie.getThumbnail();
				String rating = movie.getRating();
				
				sql = "UPDATE movies (Movie name, Description, Thumbnail, Rating)"+
						"VALUES ('" + title +
						"', '" + description +
						"', '" + thumbnail +
						"', '" + rating +
						 "') Where 'Id'='" + movieID + "'";			
					
				
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void removeMovie(Movie movie){
			try{
				stmt = conn.createStatement();
				String sql;
				int movieID = movie.getMovieID();
				
				sql = "DELETE FROM movies Where 'id'='" + movieID + "'";			
							
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		//Theatre Methods
		public void addTheatre(Theatre theatre){

			try{
				stmt = conn.createStatement();
				String sql;
				String name = theatre.getName();
				int owner = theatre.getOwner();
				String address = theatre.getAddress();
				String city = theatre.getCity();
				String state = theatre.getState();
				String postalCode = theatre.getPostalCode();

				sql = "INSERT INTO theatreBuildings (Name, Address, ownerID, City, State, PostalCode)"+
						"VALUES ('" + name +
						"', '" + address +
						"', '" + owner +
						"', '" + city +
						"', '" + state +
						"', '" + postalCode +
						 "')";			
					
				
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		public Theatre returnTheatreByName(String name) {
			String SQL = "SELECT * from theatreBuildings";
		    Statement stat;
		   
		    Theatre theatre = new Theatre();

			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					if(name.equals( rs.getString(2) )) {
						theatre.setName(rs.getString(2));
						theatre.setAddress(rs.getString(3));
						theatre.setOwner(rs.getInt(4));
						theatre.setCity(rs.getString(5));
						theatre.setState(rs.getString(6));
						theatre.setPostalCode(rs.getString(7));
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return theatre;
		}		
			
		public void updateTheatre(Theatre theatre){

			try{
				stmt = conn.createStatement();
				String sql;
				int ID = theatre.getTheatreID();
				String name = theatre.getName();
				int owner = theatre.getOwner();
				String address = theatre.getAddress();
				String city = theatre.getCity();
				String state = theatre.getState();
				String postalCode = theatre.getPostalCode();

				sql = "UPDATE theatreBuildings (Name, Address, ownerID, City, State, PostalCode)"+
						"VALUES ('" + name +
						"', '" + address +
						"', '" + owner +
						"', '" + city +
						"', '" + state +
						"', '" + postalCode +
						 "') Where 'Id'='" + ID + "'";				
					
				
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		public void removeTheatre(Theatre theatre){

			try{
				stmt = conn.createStatement();
				String sql;
				int ID = theatre.getTheatreID();
		
				sql = "DELETE FROM theatreBuildings Where 'Id'='" + ID + "'";				
					
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		//Showroom Methods
		public void addShowroom(Showroom showroom){

			try{
				stmt = conn.createStatement();
				String sql;
				int seats = showroom.getSeats();
				int theatre = showroom.getTheatre();
				
				sql = "INSERT INTO Showrooms (availableSeats, theatreBuilding)"+
						"VALUES ('" + seats +
						"', '" + theatre +
						 "')";			
					
				
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public Showroom GetShowroomByID(int ID){
			String SQL = "SELECT * from Showrooms";
		    Statement stat;   		    
		    
		    Showroom showroom = new Showroom();		
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					if(ID == rs.getInt(1) ) {
						showroom.setSeats(rs.getInt(2));
						showroom.setTheatre(rs.getInt(3));
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return showroom;
		}
		
		public ArrayList<Showroom> getShowroomByTheatre(int theatre) {
			String SQL = "SELECT * from Showrooms";
		    Statement stat;   		    
		    
		    ArrayList<Showroom> showrooms = new ArrayList<Showroom>();		
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					if(theatre == rs.getInt(3)) {
						Showroom showroom = new Showroom();
						showroom.setSeats(rs.getInt(2));
						showroom.setTheatre(rs.getInt(3));
						showrooms.add(showroom);
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return showrooms;
		}	
		
		public void updateShowroom(Showroom showroom){
			try{
				stmt = conn.createStatement();
				String sql;
				int ID = showroom.getShowroomID();
				int seats = showroom.getSeats();
				int theatre = showroom.getTheatre();
				
				sql = "UPDATE Showrooms (availableSeats, theatreBuilding)"+
						"VALUES ('" + seats +
						"', '" + theatre +
						 "') Where 'Id'='" + ID + "'";			
					
				
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void removeShowroom(Showroom showroom){
			try{
				stmt = conn.createStatement();
				String sql;
				int ID = showroom.getShowroomID();
				
				sql = "DELETE FROM Showrooms Where 'Id'='" + ID + "'";			
					
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//MovieShowing Methods
		public void addMovieShowing(MovieShowing movie){
			try{
				stmt = conn.createStatement();
				String sql;
				int price = movie.getPrice();
				int numberPurchased = movie.getNumberPurchased();
				String startTime = movie.getStartTime();
				String endTime = movie.getEndTime();
				int movieID = movie.getMovieID();
				int showroomID = movie.getShowroomID();
				
				sql = "INSERT INTO movieShowing (Price, NumberPurchased, StartTime, EndTime, movieID, showroomID)"+
						"VALUES ('" + price +
						"', '" + numberPurchased +
						"', '" + startTime +
						"', '" + endTime +
						"', '" + movieID +
						"', '" + showroomID +
						 "')";			
					
				
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public MovieShowing GetMovieShowingByID(int ID) {
			String SQL = "SELECT * FROM movieShowing;";
		    Statement stat;
		   
		    MovieShowing movie = new MovieShowing();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(ID == rs.getInt(1)) {
						movie.setPrice(rs.getInt(2));
						movie.setNumberPurchased(rs.getInt(3));
						movie.setStartTime(rs.getString(4));
						movie.setEndTime(rs.getString(5));
						movie.setMovieID(rs.getInt(6));
						movie.setShowroomID(rs.getInt(7));
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return movie;
		}
		
		public MovieShowing GetMovieShowingByMovie(int id) {
			String SQL = "SELECT * FROM movieShowing;";
		    Statement stat;
		   
		    MovieShowing movie = new MovieShowing();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(id == rs.getInt(6)) {
						movie.setPrice(rs.getInt(2));
						movie.setNumberPurchased(rs.getInt(3));
						movie.setStartTime(rs.getString(4));
						movie.setEndTime(rs.getString(5));
						movie.setMovieID(rs.getInt(6));
						movie.setShowroomID(rs.getInt(7));
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return movie;
		}
		
		public MovieShowing GetMovieShowingByShowroom(int id) {
			String SQL = "SELECT * FROM movieShowing;";
		    Statement stat;
		   
		    MovieShowing movie = new MovieShowing();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(id == rs.getInt(7)) {
						movie.setPrice(rs.getInt(2));
						movie.setNumberPurchased(rs.getInt(3));
						movie.setStartTime(rs.getString(4));
						movie.setEndTime(rs.getString(5));
						movie.setMovieID(rs.getInt(6));
						movie.setShowroomID(rs.getInt(7));
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return movie;
		}
		
		public void updateMovieShowing(MovieShowing movie){
			try{
				stmt = conn.createStatement();
				String sql;
				int Id = movie.getShowingID();
				int price = movie.getPrice();
				int numberPurchased = movie.getNumberPurchased();
				String startTime = movie.getStartTime();
				String endTime = movie.getEndTime();
				int movieID = movie.getMovieID();
				int showroomID = movie.getShowroomID();
				
				sql = "UPDATE movieShowing (Price, NumberPurchased, StartTime, EndTime, movieID, showroomID)"+
						"VALUES ('" + price +
						"', '" + numberPurchased +
						"', '" + startTime +
						"', '" + endTime +
						"', '" + movieID +
						"', '" + showroomID +
						 "') Where 'Id'='" + Id + "'";			
					
				
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void removeMovieShowing(MovieShowing movie){
			try{
				stmt = conn.createStatement();
				String sql;
				int Id = movie.getShowingID();
				
				sql = "DELETE FROM movieShowing Where 'Id'='" + Id + "'";			
					
				
				stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		
		//Review Methods
		public void addReview(Review review){
			try{
				stmt = conn.createStatement();
				String sql;
				int movieID = review.getMovieID();
				int userID = review.getUserID();
				String date = review.getDate();
				int rating = review.getRating();
				String description = review.getDescription();
						
				
				sql = "INSERT INTO customerreviews (movieID, userID, ReviewDate, Rating, Review)"+
						"VALUES ('" + movieID +
						"', '" + userID +
						"', '" + date +
						"', '" + rating +
						"', '" + description +
						 "')";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
		}
		
		public Review GetReviewByID(int ID) {
			String SQL = "SELECT * FROM customerreview;";
		    Statement stat;
		   
		    Review review = new Review();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(ID == rs.getInt(1)) {
						review.setReviewID(rs.getInt(1));
						review.setMovieID(rs.getInt(2));
						review.setUserID(rs.getInt(3));
						review.setDate(rs.getString(4));
						review.setRating(rs.getInt(5));
						review.setDescription(rs.getString(6));
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return review;
		}
		
		public Review GetReviewByMovieID(int ID) {
			String SQL = "SELECT * FROM customerreview;";
		    Statement stat;
		   
		    Review review = new Review();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(ID == rs.getInt(2)) {
						review.setReviewID(rs.getInt(1));
						review.setMovieID(rs.getInt(2));
						review.setUserID(rs.getInt(3));
						review.setDate(rs.getString(4));
						review.setRating(rs.getInt(5));
						review.setDescription(rs.getString(6));
					} 
			    }
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return review;
		}
		
		public Review GetReviewByUserID(int ID) {
			String SQL = "SELECT * FROM customerreview;";
		    Statement stat;
		   
		    Review review = new Review();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(ID == rs.getInt(3)) {
						review.setReviewID(rs.getInt(1));
						review.setMovieID(rs.getInt(2));
						review.setUserID(rs.getInt(3));
						review.setDate(rs.getString(4));
						review.setRating(rs.getInt(5));
						review.setDescription(rs.getString(6));
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return review;
		}
		
		public void updateReview(Review review){
			try{
				stmt = conn.createStatement();
				String sql;
				int ID = review.getReviewID();
				int movieID = review.getMovieID();
				int userID = review.getUserID();
				String date = review.getDate();
				int rating = review.getRating();
				String description = review.getDescription();
						
				
				sql = "UPDATE customerreviews (movieID, userID, ReviewDate, Rating, Review)"+
						"VALUES ('" + movieID +
						"', '" + userID +
						"', '" + date +
						"', '" + rating +
						"', '" + description +
						 "') Where 'Id'='" + ID + "'";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
		}
		
		public void removeReview(Review review){
			try{
				stmt = conn.createStatement();
				String sql;
				int ID = review.getReviewID();
				
				sql = "DELETE FROM customerreviews Where 'Id'='" + ID + "'";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
		}
		
		
		//Credit Card Methods
		public void addTransaction(Transaction transaction){
			try{
				stmt = conn.createStatement();
				String sql;
				String cardHolder = transaction.getCardHolderName();
				String cardNumber = transaction.getCardNumber();
				float balance = transaction.getBalance();
				String type = transaction.getCardType();
				int userID = transaction.getUserID();
				String cvv = transaction.getCVV();
				String expiration = transaction.getExpiration();
						
				
				sql = "INSERT INTO creditcards (CardHolderName, CreditCardNumber, Balance CardType, UserId, CVV, ExpirationDate)"+
						"VALUES ('" + cardHolder +
						"', '" + cardNumber +
						"', '" + balance +
						"', '" + type +
						"', '" + userID +
						"', '" + cvv +
						"', '" + expiration +
						 "')";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
		}
		
		public Transaction GetTransactionByID(int ID){
			String SQL = "SELECT * FROM creditcards;";
		    Statement stat;
		   
		    Transaction transaction = new Transaction();
		        
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(ID == rs.getInt(1)) {
						transaction.setCardHolderName(rs.getString(2));
						transaction.setCardNumber(rs.getString(3));
						transaction.setBalance(rs.getFloat(4));
						transaction.setCardType(rs.getString(5));
						transaction.setUserID(rs.getInt(6));
						transaction.setCVV(rs.getString(7));
						transaction.setExpiration(rs.getString(8));
												
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return transaction;
			
			
		}
		
		public Transaction GetTransactionByUserID(int ID){
			String SQL = "SELECT * FROM creditcards;";
		    Statement stat;
		   
		    Transaction transaction = new Transaction();
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
					
					if(ID == rs.getInt(6)) {
						transaction.setCardHolderName(rs.getString(2));
						transaction.setCardNumber(rs.getString(3));
						transaction.setBalance(rs.getFloat(4));
						transaction.setCardType(rs.getString(5));
						transaction.setUserID(rs.getInt(6));
						transaction.setCVV(rs.getString(7));
						transaction.setExpiration(rs.getString(8));
												
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return transaction;
			
			
		}
			
		public void updateTransaction(Transaction transaction){
			try{
				stmt = conn.createStatement();
				String sql;
				int ID = transaction.getCreditCardID();
				String cardHolder = transaction.getCardHolderName();
				String cardNumber = transaction.getCardNumber();
				float balance = transaction.getBalance();
				String type = transaction.getCardType();
				int userID = transaction.getUserID();
				String cvv = transaction.getCVV();
				String expiration = transaction.getExpiration();
						
				
				sql = "UPDATE creditcards (CardHolderName, CreditCardNumber, Balance CardType, UserId, CVV, ExpirationDate)"+
						"VALUES ('" + cardHolder +
						"', '" + cardNumber +
						"', '" + balance +
						"', '" + type +
						"', '" + userID +
						"', '" + cvv +
						"', '" + expiration +
						 "') Where 'Id'='" + ID + "'";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
		}
		
		public void removeTransaction(Transaction transaction){
			try{
				stmt = conn.createStatement();
				String sql;
				int ID = transaction.getCreditCardID();
				
				sql = "DELETE FROM creditcards Where 'Id'='" + ID + "'";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
		}
		
		
		//Order Methods		
		public void addOrder(Order order){
			try{
				stmt = conn.createStatement();
				String sql;

				int userID = order.getUserID();
				int cost = order.getCost();
				String date = order.getOrderDate();
				String address = order.getAddress();
				String card = order.getCardNumber();
						
				
				sql = "INSERT INTO orders (CustomerId, TotalCost, OrderDate, BillingAddress, CreditCardNumber)"+
						"VALUES ('" + userID +
						"', '" + cost +
						"', '" + date +
						"', '" + address +
						"', '" + card +
						 "')";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
			
		}
		
		public Order GetOrderByID(int ID){
			String SQL = "SELECT * FROM orders;";
		    Statement stat;
		   
		    Order order = new Order();
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(ID == rs.getInt(1)) {
						order.setOrderID(rs.getInt(1));
						order.setUserID(rs.getInt(2));
						order.setCost(rs.getInt(3));
						order.setOrderDate(rs.getString(4));
						order.setAddress(rs.getString(5));
						order.setCardNumber(rs.getString(6));
						
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return order;
			
			
		}
		
		public ArrayList<Order> GetOrdersByUser(int ID){
			String SQL = "SELECT * FROM orders;";
		    Statement stat;
		   
		    ArrayList<Order> orders = new ArrayList<Order>();
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(ID == rs.getInt(2)) {
						Order order = new Order();
						
						order.setOrderID(rs.getInt(1));
						order.setUserID(rs.getInt(2));
						order.setCost(rs.getInt(3));
						order.setOrderDate(rs.getString(4));
						order.setAddress(rs.getString(5));
						order.setCardNumber(rs.getString(6));
						
						orders.add(order);
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return orders;
			
			
		}
		
		public void UpdateOrder(Order order){
			try{
				stmt = conn.createStatement();
				String sql;
				int orderID = order.getOrderID();
				int userID = order.getUserID();
				int cost = order.getCost();
				String date = order.getOrderDate();
				String address = order.getAddress();
				String card = order.getCardNumber();
						
				
				sql = "Update orders (CustomerId, TotalCost, OrderDate, BillingAddress, CreditCardNumber)"+
						"VALUES ('" + userID +
						"', '" + cost +
						"', '" + date +
						"', '" + address +
						"', '" + card +
						 "') Where 'Id'='" + orderID + "'";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
			
		}
		
		public void removeOrder(Order order){
			try{
				stmt = conn.createStatement();
				String sql;
				int orderID = order.getOrderID();

				sql = "DELETE FROM orders Where 'Id'='" + orderID + "'";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		
		//Order Items Methods
		public void addOrderItems(OrderItems order){
			try{
				stmt = conn.createStatement();
				String sql;

				int orderID = order.getOrderID();
				int showingID = order.getShowingID();
				int count = order.getCount();
						
				
				sql = "INSERT INTO orderitems (OrderId, ShowingID, Quantity)"+
						"VALUES ('" + orderID +
						"', '" + showingID +
						"', '" + count +
						 "')";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
			
		}
		
		public OrderItems GetOrderItemsByID(int ID){
			String SQL = "SELECT * FROM orderitems;";
		    Statement stat;
		   
		    OrderItems order = new OrderItems();
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(ID == rs.getInt(1)) {
						order.setItemID(rs.getInt(1));
						order.setOrderID(rs.getInt(2));
						order.setShowingID(rs.getInt(3));
						order.setCount(rs.getInt(4));
						
						
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return order;
			
			
		}
		
		public OrderItems GetOrderItemsByOrder(int ID){
			String SQL = "SELECT * FROM orderitems;";
		    Statement stat;
		    
		    OrderItems order = new OrderItems();
		    
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				
				while (rs.next()){
										
					if(ID == rs.getInt(2)) {
						order.setItemID(rs.getInt(1));
						order.setOrderID(rs.getInt(2));
						order.setShowingID(rs.getInt(3));
						order.setCount(rs.getInt(4));
					} 
			    }
				
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return order;
			
			
		}
		
		public void UpdateOrderItems(OrderItems order){
			try{
				stmt = conn.createStatement();
				String sql;
				int itemID = order.getItemID();
				int orderID = order.getOrderID();
				int showingID = order.getShowingID();
				int count = order.getCount();
						
				
				sql = "Update orderitems (OrderId, ShowingID, Quantity)"+
						"VALUES ('" + orderID +
						"', '" + showingID +
						"', '" + count +
						 "') Where 'Id'='" + itemID + "'";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
			
		}
		
		public void removeOrderItems(OrderItems order){
			try{
				stmt = conn.createStatement();
				String sql;
				int itemID = order.getItemID();

				sql = "DELETE FROM orderitems Where 'Id'='" + itemID + "'";
				
				 stmt.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
			
		}
		
		
		
		
		
		
		
		
		
		//Other Methods
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
		
		
		
		
			
		


}
