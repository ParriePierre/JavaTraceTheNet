package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import traceRoutePackage.IpMatcher;

public class Controller extends Application {
	
	public IpMatcher model;
	
	public Controller()
	{
		super();
		model=MainClass.getModel();
	}
	/**
	 * Launches start(Stage arg0), start the application
	 */
	public void start()
	{	
		Application.launch(Controller.class, "");
	}
	
	/**
	 * Initializes the view
	 * Load the XML file
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("TraceTheNet!");
        Group root = new Group();
        Scene scene = new Scene(root, 640, 480, Color.WHITE);
        
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/TraceRouteInterface.fxml"));
        BorderPane bp= (BorderPane) loader.load();
                   
        root.getChildren().add(bp);
        
        primaryStage.setScene(scene);
        primaryStage.show();
	}

}
