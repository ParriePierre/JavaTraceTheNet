package controller;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;
import traceRoutePackage.IpMatcher;
import traceRoutePackage.TraceRouteExec;
import view.TraceRouteUI;

public class Controller extends Application {
	
	public TraceRouteUI view;
	
	public IpMatcher model;
	
	public Controller() throws Exception
	{
		
	}
	
	public void setView(TraceRouteUI view)
	{
		this.view=view;
		view.setController(this);
	}
	
	public void setModel(IpMatcher model)
	{
		this.model=model;
	}
	
	/**
	 * Launches start(Stage arg0)
	 */
	public void start()
	{	
		Application.launch(Controller.class, "");
	}
	
	/**
	 * Initialize the view
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("TraceTheNet!");
        Group root = new Group();
        Scene scene = new Scene(root, 640, 480, Color.WHITE);
        
        //view.launch();
        
        TextField getIp=new TextField();
		Label ip=new Label("IP Address");
		Button generate=new Button("Generate random address");
		Button traceIt=new Button("Trace it!");
		
		generate.setOnAction(getRandomAddress(getIp));
		traceIt.setOnAction(getTraceAction(model, getIp,primaryStage));
		
		Popup p = new Popup();
		
		p.hide();
		
		GridPane gp=new GridPane();
		BorderPane bp=new BorderPane();
		
		gp.add(ip, 1, 1);
		gp.add(getIp, 2, 1);
		gp.add(generate,3,1);
		gp.add(traceIt,4,1);
		
		bp.setTop(gp);
		
		//this.getChildren().add(bp);
        
        root.getChildren().add(bp);
        
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public GenerateRandomAdress getRandomAddress(TextField address)
	{
		return new GenerateRandomAdress(address);
	}
	
	public TraceRouteAction getTraceAction(IpMatcher model, TextField address, Stage primaryStage)
	{
		return new TraceRouteAction(model, address,primaryStage);
	}

}
