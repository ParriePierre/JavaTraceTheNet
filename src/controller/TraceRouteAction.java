package controller;

import java.io.IOException;

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
	
	private IpMatcher model;
	
	private final TextField address;
	
	private final Controller ct;
	
	private final Stage primaryStage;
	
	TraceRouteAction(IpMatcher model, TextField address, Stage primaryStage, Controller ct)
	{
		this.model=model;
		this.address=address;
		this.primaryStage=primaryStage;
		this.ct=ct;
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
			try {
				ct.traceRoute(address.getText());
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
