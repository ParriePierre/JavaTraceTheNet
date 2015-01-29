package controller;

import java.io.IOException;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import view.TraceRouteUI;

public class Controller extends Application {
	
	public TraceRouteUI view;
	
	public IpMatcher model;
	
	@FXML
	private TextField ipAddress;
	
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
        
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/TraceRouteInterface.fxml"));
        BorderPane bp= (BorderPane) loader.load();
            
        //view.launch();
        /*
        TextField getIp=new TextField();
		Label ip=new Label("IP Address");
		Button generate=new Button("Generate random address");
		Button traceIt=new Button("Trace it!");
		BorderPane bp=new BorderPane();
		
		generate.setOnAction(getRandomAddress(getIp));
		traceIt.setOnAction(getTraceAction(model, getIp,primaryStage, this));
		
		Popup p = new Popup();
		
		p.hide();
		
		GridPane gp=new GridPane();
		
		gp.add(ip, 1, 1);
		gp.add(getIp, 2, 1);
		gp.add(generate,3,1);
		gp.add(traceIt,4,1);
		
		bp.setTop(gp);
		*/
        
        root.getChildren().add(bp);
        
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	@FXML
	private void generateRandomIpButton()
	{
		Random rd = new Random();
		StringBuilder sb=new StringBuilder();
		int a,b,c,d;
		
		a=rd.nextInt(256);
		b=rd.nextInt(256);
		c=rd.nextInt(256);
		d=rd.nextInt(256);
		sb.append(a);
		sb.append(".");
		sb.append(b);
		sb.append(".");
		sb.append(c);
		sb.append(".");
		sb.append(d);
		
		ipAddress.setText(sb.toString());
	}
	
	@FXML
	private void traceRouteButton()
	{
		if(ipAddress.getText().isEmpty())
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
			//p.show(primaryStage);
		}else {
			try {
				String[] qqc = model.getIps(ipAddress.getText());
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
