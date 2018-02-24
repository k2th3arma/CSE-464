package model;

import model.Accessor;
import model.Address;

public class AddressDB {

    public void addAddress(Address address) {
       	Accessor db = new Accessor();
       	db.connectMeIn();
       	db.addAddress(address);
       	db.closeConnection();
    }
}
