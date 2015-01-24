package controller;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class GenerateRandomAdress implements EventHandler<javafx.event.ActionEvent>  {
		
	private final TextField address;
	
	GenerateRandomAdress(TextField address)
	{
		this.address=address;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
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
		
		address.setText(sb.toString());
		
	}

}
