//IMPORT PROPER PACKAGES LATER
package application;

import java.io.Serializable;

public class Customer implements Serializable {
    String name;
     int id;
     String currentLocation;
     String destination;
     String userName;
     String password;
     String phoneNumber;
     String emailID;
     int wallet;
    //COMMENT THIS SHIT LATER  
    //Change destination, CurrentLocation to null;
    public Customer(String name, String userName, String password, String phoneNumber, String emailID)
    {
        this.name = name;
       // this.currentLocation = currentLocation;
        //this.destination = destination;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailID = emailID;
       // this.wallet = wallet;
    }
    
    public static Customer deserialize(String username, String pass)
    {
    		ArrayList<Customer> al = new ArrayList<>();	
    		String path = "./src/application/data.txt";
    		FileInputStream fis = new FileInputStream(path);
    		ObjectInputStream ois = new ObjectInputStream(fis);
    		a1 = (ArrayList<Customer>)ois.readObject(fis);
    		oos.close();
    		fis.close();
    		for(Customer it : al)
    		{
    		 	if(it.userName = username && it.password == pass)
    		 		return it;
    	 	}
    	 	return NULL;
    }	

    //Call to display the current balance
    int balance()
    {
        return wallet;
    }
    //Call before booking a ride to check wether the customer has enough balance in his waller(300 Rs atleast)
    Boolean isEnough()
    {
        return (wallet >= 300);   
    }
    //Add money to the wallet
    void addBalance(int incr)
    {
        this.wallet += incr;
    }
}
