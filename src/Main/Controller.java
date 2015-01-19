package Main;

import view.*;
import traceRoutePackage.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller extends Application {
	
	public final TraceRouteUI view;
	
	public final TraceRouteExec model;
	
	public Controller(TraceRouteUI view, TraceRouteExec model)
	{
		this.view=view;
		this.model=model;
		view.setController(this);
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
        Scene scene = new Scene(root, view.getWidth(), view.getHeight(), Color.WHITE);
        
        view.launch();
        
        root.getChildren().add(view);
        
        primaryStage.setScene(scene);
        primaryStage.show();
	}

}
