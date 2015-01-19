package view;

import Main.*;
import javafx.scene.Parent;

public class TraceRouteUI extends Parent{
	
	public Controller controller;
	
	static private final int WIDTH = 640;

	static private final int HEIGHT = 480;
	
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

	public void launch() {
		
	}
	
	
}
