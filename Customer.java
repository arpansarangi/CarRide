//IMPORT PROPER PACKAGES LATER
package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
    String name;
     int id;
     String currentLocation;
     String destination;
     String userName;
     String password;
     String phoneNumber;
     String emailID;
     static int wallet;
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
    //Call to display the current balance
    public static int balance()
    {
        return wallet;
    }
    //Call before booking a ride to check wether the customer has enough balance in his waller(300 Rs atleast)
    public static Boolean isEnough()
    {
        return (wallet >= 300);   
    }
    //Add money to the wallet
    public void addBalance(Customer customer,int incr)
    {
        Customer.wallet += incr;
    }
    
    public static void serialize(Customer customer)
    {
    	ArrayList<Customer> al = new ArrayList<>();
		try
		{
			String path = "./src/application/data.txt";
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			al = (ArrayList<Customer>)ois.readObject();
			ois.close();
			fis.close();
			al.add(customer);
			FileOutputStream file = new FileOutputStream(path); 
            ObjectOutputStream out = new ObjectOutputStream(file);  
            out.writeObject(al);       
            out.close(); 
            file.close(); 
			
			 
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("2");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("3");
		}
		
                
		System.out.print(customer.name + customer.userName + customer.emailID + customer.password);
    }
    
    public static Customer deserialize(String username, String pass)
    {
    		try {
    			ArrayList<Customer> al = new ArrayList<>();	
        		String path = "./src/application/data.txt";
        		FileInputStream fis = new FileInputStream(path);
        		ObjectInputStream ois = new ObjectInputStream(fis);
        		al = (ArrayList<Customer>)ois.readObject();
        		ois.close();
        		fis.close();
        		for(Customer it : al)
        		{
        		 	if(username.equals(it.userName) && pass.equals(it.password))
        		 		return it;
        	 	}
        	 	return null;
    		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		finally
    		{
    			System.out.println("deserialized");
    		}
    }	
    
}
