//IMPORT PROPER PACKAGES LATER
package com.mycompany.arabella;

public class customer {
    private String name;
    private int id;
    private String currentLocation;
    private String destination;
    private String userName;
    private String password;
    private String phoneNumber;
    private String emailID;
    private int wallet;
    //COMMENT THIS SHIT LATER   
    customer(String name, int id, String currentLocation, String destination, String userName, String password, String phoneNumber, String emailID, int wallet)
    {
        this.name = name;
        this.id = id;
        this.currentLocation = currentLocation;
        this.destination = destination;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailID = emailID;
        this.wallet = wallet;
    }
    //Call to display the current balance
    int balance()
    {
        return wallet;
    }
    //Call before booking a ride to check wether the customer has enough balance in his waller(300 Rs atleast)
    bool isEnough()
    {
        reteurn (wallet >= 300);   
    }
    //Add money to the wallet
    void addBalance(int incr)
    {
        this.wallet += incr;
    }
}
