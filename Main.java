package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import java.io.Serializable;

import application.Main.Cab;
import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
				Group root = new Group();
			 	
			    root.getChildren().add(FXMLLoader.load(getClass().getResource("MapFXML.fxml")));
			    
				
				Scene scene = new Scene(root,860,800);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				
				
				
				
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static class Cab extends StackPane implements Serializable
	{
			String customer;
			String dest;


			public Cab (String customer,String dest)
			{	
				this.customer=customer;
				this.dest=dest;
				
				//Put a try\catch thing here?
				Circle circle = new Circle();
				circle.setRadius(10);
				circle.setCenterX(118);
				circle.setCenterY(431);				
				circle.setFill(Color.AZURE)
				;
				Text text = new Text(customer + "\n" + dest);
				StackPane overlay = new StackPane();
				Rectangle rect = new Rectangle(60,60);
				overlay.getChildren().addAll(rect,text);
				rect.setFill(Color.BURLYWOOD);
				overlay.setVisible(false);
				
				this.getChildren().addAll(circle, overlay);
				
				this.setOnMouseEntered(new EventHandler<MouseEvent>()
		        {
					@Override
					public void handle(MouseEvent arg0) {						

		            	overlay.setVisible(true);
					}
		        });
				this.setOnMouseExited(new EventHandler<MouseEvent>()
		        {
					@Override
					public void handle(MouseEvent arg0) {						

		            	overlay.setVisible(false);
					}
		        });
			}
			
			// For curves,search passed array for relevant nodes and for append curves for those nodes
			public static PathTransition addNode(Cab cab,double toX, double toY) 
			{
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
			        //transition.setDelay(Duration.seconds(5));
			        transition.setDuration(Duration.seconds(2));
		     
		       return transition;
		   }
			 
			 
			static SequentialTransition makePath (Cab cab,int[] arrX,int[] arrY)
			{
				
					SequentialTransition sequentialtransition = new SequentialTransition ();
					//sequentialtransition.getChildren().add(addNode(cab,arrX[0],arrY[0]));
					for(int i=1;i<arrX.length;i++)
					{
						sequentialtransition.getChildren().add(addNode(cab,arrX[i],arrY[i],arrX[i-1],arrY[i-1]));
						//System.out.println("adding" + arrX[i] + ' '+arrY[i]);
					}
					return sequentialtransition;
			}
			
			static void drop(Cab cab,int[] arrX,int[]arrY)
			{
				
				SequentialTransition sequentialtransition = Cab.makePath(cab, arrX, arrY);
				sequentialtransition.play();
			}
			 
			
			public static void addToMap(Pane pane,Cab cab)
				{
				 	//System.out.println(cab+"called");
					pane.getChildren().add(cab);
				}
			 
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
