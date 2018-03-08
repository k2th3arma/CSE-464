package util;

import java.util.*;

import model.Address;

public class Utilities {

	public Utilities(){
		super();
	}
	
	public Address splitDBEntry(String entry, String user){
		
		String[] columns = entry.split(",");
		Address address = new Address(columns[0], columns[1], columns[2], columns[3], user);
		return address;
		
	}
	
	
	public boolean Check(String one, String two){
		if(one.equals(two)){
			return true;
		}
		else{
			return false;
		}
	}
}
