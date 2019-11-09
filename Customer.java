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
}
