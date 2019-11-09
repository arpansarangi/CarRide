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
	private TextField regName;
	@FXML
	private Label error;
	
		
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
    void register(ActionEvent event) {
    	
    	
    	
    		Customer customer = new Customer(regName.getText(),regUser.getText(),regPass.getText(),regPhone.getText(),regEmail.getText());
    		ArrayList<Customer> al = new ArrayList<>();
    		try
    		{
    			String path = "./src/application/data.txt";
    			File f = new File(path);
    			if(f.canWrite())
    			{
    				System.out.println(f.getAbsolutePath());
    			}
    			Customer customer1 = new Customer("wqer","qwe","qwer","qwer","qwre");
    			FileOutputStream file = new FileOutputStream(path); 
                ObjectOutputStream out = new ObjectOutputStream(file); 
                  
                // Method for serialization of object 
                out.writeObject(customer1); 
                  
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
    		/*catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("3");
			}
    		*/
                    
    		System.out.print(customer.name + customer.userName + customer.emailID + customer.password);
    		
    		
              

           	
    	
    	
    	
    	
}
    		
  
		
   }
    
    //use bindBidirectional for syncing windows
    //Customer class should implement Serializable
  	/*try { 
	
	Cab cab1;
	
    // Reading the object from a file 
    FileInputStream file = new FileInputStream 
                                 ("f.txt"); 
    ObjectInputStream in = new ObjectInputStream 
                                 (file); 

    // Method for deserialization of object 
    cab1 = (Cab)in.readObject(); 

    in.close(); 
    file.close(); 
   
    System.out.println(cab1);
    Cab.addToMap(pane, cab1);

    System.out.println(cab1.customer + cab1.dest );
    Cab cab2 = new Cab(cab1.customer,cab1.dest);
    Cab.addToMap(pane, cab2);
   

} 

catch (IOException ex) { 
    System.out.println("IOException is caught"); 
} 
catch (ClassNotFoundException ex) { 
    System.out.println("ClassNotFoundException" + 
                        " is caught"); 
} */
