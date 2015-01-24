package view;

import controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class TraceRouteUI extends Parent{
	
	public Controller controller;
	
	static private final int WIDTH = 640;

	static private final int HEIGHT = 480;
	
	public TextField getIp;
	
	public TraceRouteUI()
	{
		
	}
	
	public void setController(Controller controller)
	{
		this.controller=controller;
	}
	
	public int getWidth()
	{
		return WIDTH;
	}
	
	public int getHeight()
	{
		return HEIGHT;
	}
	
	/**
	 * Creates the view of the project
	 */
	public void launch() {
		//JFXPanel fxPanel = new JFXPanel();
		getIp=new TextField();
		Label ip=new Label("IP Address");
		Button generate=new Button("Generate random address");
		Button traceIt=new Button("Trace it!");
		
		GridPane gp=new GridPane();
		BorderPane bp=new BorderPane();
		
		gp.add(ip, 1, 1);
		gp.add(getIp, 2, 1);
		gp.add(generate,3,1);
		gp.add(traceIt,4,1);
		
		bp.setTop(gp);
		
		this.getChildren().add(bp);
	}
	
	
}
