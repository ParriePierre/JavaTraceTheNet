package controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import traceRoutePackage.IpMatcher;

public class Controller extends Application {
	
	public IpMatcher model;
	
	@FXML
	private BorderPane bp;
	
	public Controller()
	{
		super();
		model=MainClass.getModel();
	}
	/**
	 * Launches start(Stage arg0)
	 */
	public void start()
	{	
		Application.launch(Controller.class, "");
	}
	
	/**
	 * Initialize téhe view
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("TraceTheNet!");
        Group root = new Group();
        Scene scene = new Scene(root, 640, 480, Color.WHITE);
        
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/TraceRouteInterface.fxml"));
        bp= (BorderPane) loader.load();
                   
        root.getChildren().add(bp);
        
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public GenerateRandomAdress getRandomAddress(TextField address)
	{
		return new GenerateRandomAdress(address);
	}
	
	public TraceRouteAction getTraceAction(IpMatcher model, TextField address, Stage primaryStage, Controller ct)
	{
		return new TraceRouteAction(model, address,primaryStage, ct);
	}
	
	public String[] traceRoute (String address) throws IOException, InterruptedException
	{
		return model.getIps(address);
	}

}
