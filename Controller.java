package application;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import application.Main.Cab;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Controller implements Initializable {

	@FXML
	private Pane pane;
	
	double[] arrX = new double[8];
	double[] arrY = new double[8];
	int i=0;
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	
    	
    }
    @FXML
    void btn(ActionEvent event) {
    	 System.out.println(this+"called");
     	Cab cab = new Cab("Rohan", "Yeet Land");
 		//Cab cab2 = new Cab("Dingus");
 		
 		Cab.addToMap(pane, cab);
 		Cab.drop(cab);
 		System.out.println(Arrays.toString(arrX));
 		System.out.println(Arrays.toString(arrY));
 		
    }
    @FXML
    void pt(MouseEvent event) {
    	if(i<8) {
    	 arrX[i]= event.getX();
    	 arrY[i]= event.getY();
    	 i++;
    	}
		
   }
}
