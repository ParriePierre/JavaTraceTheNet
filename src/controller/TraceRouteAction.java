package controller;

import traceRoutePackage.TraceRouteExec;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import traceRoutePackage.IpMatcher;

public class TraceRouteAction implements EventHandler<javafx.event.ActionEvent> {
	
	private final IpMatcher model;
	
	private final TextField address;
	
	private final Stage primaryStage;
	
	TraceRouteAction(IpMatcher model, TextField address, Stage primaryStage)
	{
		this.model=model;
		this.address=address;
		this.primaryStage=primaryStage;
	}

	@Override
	public void handle(ActionEvent arg0) {
		if(address.getText().isEmpty())
		{
			final Popup p=new Popup();
			Label l = new Label("No adress entered");
			Button hide = new Button("OK");
			hide.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					p.hide();					
				}
			});
			GridPane gp=new GridPane();
			gp.add(l,0,0);
			gp.add(hide, 0, 1);
			p.getContent().addAll(gp);
			p.show(primaryStage);
		}
		else
		{
			
		}
	}

}
