package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.paint.Color; 
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
				Group root = new Group();			
				StackPane stack = new StackPane();			
				
				/*Circle circle = new Circle();
				circle.setRadius(10);
				circle.setCenterX(100);
				circle.setCenterY(50);
				circle.setFill(Color.BROWN);*/
				Cab cab = new Cab("Rohan");
				Cab cab2 = new Cab("Dingus");	
			   
				int[] arr = {120,135,135,200};
				int[] arr1 = {165,135,187,40};
				SequentialTransition sequentialtransition = makePath(cab, arr);
				SequentialTransition sequentialtransition1 = makePath(cab2, arr1);
				
			      
			    stack.getChildren().addAll(FXMLLoader.load(getClass().getResource("/MapFXML.fxml")),cab,cab2);
			    root.getChildren().add(stack);
				
				Scene scene = new Scene(root,560,550);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				sequentialtransition.play();
				sequentialtransition1.play();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	static PathTransition addNode(Cab cab,double toX, double toY) {
		 double fromX = cab.getLayoutX();
	        double fromY = cab.getLayoutY();

	        Path path = new Path();
	        path.getElements().add(new MoveTo(fromX, fromY));
	        path.getElements().add(new LineTo(toX, toY));

	        PathTransition transition = new PathTransition();
	        transition.setPath(path);
	        transition.setNode(cab);
	        transition.setDelay(Duration.seconds(1));
	        transition.setDuration(Duration.seconds(2));
      
        return transition;
    }
	
	static PathTransition addNode(Cab cab,double toX, double toY,double fromX,double fromY) {
		 
	        Path path = new Path();
	        path.getElements().add(new MoveTo(fromX, fromY));
	        path.getElements().add(new LineTo(toX, toY));

	        PathTransition transition = new PathTransition();
	        transition.setPath(path);
	        transition.setNode(cab);
	        //transition.setDelay(Duration.seconds(1));
	        transition.setDuration(Duration.seconds(2));
     
       return transition;
   }
	private static SequentialTransition makePath (Cab cab,int[] arr)
	{
		
			SequentialTransition sequentialtransition = new SequentialTransition ();
			sequentialtransition.getChildren().add(addNode(cab,arr[0],arr[1]));
			for(int i=1;i<arr.length-1;i++)
			{
				sequentialtransition.getChildren().add(addNode(cab,arr[i],arr[i+1],arr[i-1],arr[i]));
			}
			return sequentialtransition;
	}
	
	private static class Cab extends StackPane
	{
			public Cab (String customer)
			{
				Circle circle = new Circle();
				circle.setRadius(20);
				circle.setCenterX(100);
				circle.setCenterY(50);
				circle.setFill(Color.AZURE);
				Text text = new Text(customer);
				this.getChildren().addAll(circle, text);	
				//new StackPane().getChildren().addAll(circle,text);
			}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
