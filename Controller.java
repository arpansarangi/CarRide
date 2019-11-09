package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.io.*;

import application.Main.Cab;
import application.Customer;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class Controller implements Initializable {

	@FXML 
	private Pane pane;
	@FXML 
	BorderPane borderpane;
	@FXML
	private TextField regUser;
	@FXML
	private TextField regPass;
	@FXML
	private TextField regPhone;
	@FXML
	private TextField regEmail;
	@FXML
	private TextField loginUser;
	@FXML
	private TextField loginPass;
	@FXML
	private TextField regName;
	@FXML
	private Label error;
	@FXML
	private Label exist;
	
		
	double[] arrX = new double[8];
	double[] arrY = new double[8];
	int i=0;	
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	
    	
    }
    @FXML
    void btn(ActionEvent event) {
    	// System.out.println(this+"called");
     	try {
     		Cab cab = new Cab("Azure Rathalos", "Charge Blade");
     		int[] arrX = {118, 151, 233, 262,295, 323, 295, 267, 268, 242};
			int[] arrY = {431, 421, 402, 370,335, 291, 276, 311, 310, 284};
     		
     		FileOutputStream fout=new FileOutputStream("f.txt");  
     		  ObjectOutputStream out=new ObjectOutputStream(fout);  
     		  out.writeObject(cab);  
     		  out.flush();  
     		  //closing the stream  
     		  out.close();  
     		 System.out.println(cab);
     		Cab.addToMap(pane, cab);
     		Cab.drop(cab,arrX,arrY);
     	}catch(Exception e){System.out.println(e);}
 		System.out.println(Arrays.toString(arrX));
 		System.out.println(Arrays.toString(arrY));
 		
 		
 		
    }
    @FXML
    void pt(MouseEvent event) {
    	 System.out.print(event.getX() + " ");
         System.out.print(event.getY() + "\n");
		
   }
    @FXML
    void btn1(ActionEvent event) {
    	
    	
    	try {
    		
    		Stage stage = new Stage();
			Group root = new Group();
		 	
		    root.getChildren().add(FXMLLoader.load(getClass().getResource("Login.fxml")));
		    
			
			Scene scene = new Scene(root,358,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
			
			
			
			
	} catch(Exception e) {
		e.printStackTrace();
	}
    }
    
    
    @SuppressWarnings("unchecked")
	@FXML
    void register(ActionEvent event) throws ClassNotFoundException {	
    	Customer customer = new Customer(regName.getText(),regUser.getText(),regPass.getText(),regPhone.getText(),regEmail.getText());
    	ArrayList<Customer> al = new ArrayList<>();
		try
		{
		String path = "./src/application/data.ser";
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
    
    @FXML
    void login(ActionEvent event)
    {
    	Customer c1 = null;
    	try {
    		String username = loginUser.getText();
    		String pass = loginPass.getText();
			ArrayList<Customer> al = new ArrayList<>();	
    		String path = "./src/application/data.ser";
    		FileInputStream fis = new FileInputStream(path);
    		ObjectInputStream ois = new ObjectInputStream(fis);
    		al = (ArrayList<Customer>)ois.readObject();
    		System.out.println(al);
    		ois.close();
    		fis.close();
    		for(Customer it : al)
    		{
    			System.out.print(it.name + it.userName +  it.password+it.emailID);
    		 	if(username.equals(it.userName) && pass.equals(it.password))
    		 	{
    		 		c1 = it;
    		 	}
    	 	}
    	 	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException dika rha hai");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Why is the class not found?");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(c1 == null)
    	{
    			exist.setOpacity(1.00);
    	}
    	else
    	{
    		System.out.println("Well");
    	}
    }
  
		
   }
