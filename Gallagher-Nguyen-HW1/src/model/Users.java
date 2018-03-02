package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Users {

		private int userID;
		private String firstName;
		private String lastName;
		private String userName;
		private String password;
		private String address;
		private String city;
		private String state;
		private String postalCode;
		private String email;
		private String phone;
		private String birthday;
		private String type;
		private int status;
		private int numberOfVisits;
		private boolean log;
		
		public Users() {
			super();
		}
		public Users(	String firstName, 
						String lastName, 
						String userName, 
						String password,
						String address,
						String city,
						String state,
						String postalCode,
						String email, 
						String phone,
						String birthday,						 
						String type,
						int status,
						int numberOfVisits) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.password = password;
			this.address = address;
			this.city = city;
			this.state = state;
			this.postalCode = postalCode;
			this.email = email;
			this.phone = phone;
			this.birthday = birthday;			
			this.type = type;
			this.status = status;
			this.numberOfVisits = numberOfVisits;
		}
		public int getUserID() {
			return userID;
		}
		public void setUserID(int userID) {
			this.userID = userID;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean getLog(){
			return this.log;
		}
		public void setLog(boolean log){
			this.log = log;
		}	
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		public String getBirthday() {
			return birthday;
		}
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public int getNumberOfVisits() {
			return numberOfVisits;
		}
		public void setNumberOfVisits(int numberOfVisits) {
			this.numberOfVisits = numberOfVisits;
		}
		@Override
		public String toString(){
			return firstName +" "+ lastName +" "+ userName + " "+ password +" "+ email +" "+ address +" "+ type;
		}
	
	public void registerUser(Users aUser, String propFilePath) {
		
		Properties p = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			p.load(fis);
			p.setProperty(aUser.getUserName(), aUser.getPassword());
			p.store(new FileOutputStream(propFilePath), null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	// validateUser
	// removeUser
	
	
}
