package controller;

import java.io.IOException;

import controller.Controller;
import traceRoutePackage.*;
import view.TraceRouteUI;


public class MainClass {

	/**
	 * @param args
	 */
    
	public static void main(String[] args) {
		
		try {
			//TraceRouteExec tre = new TraceRouteExec();
                        IpMatcher ip = new IpMatcher("ece.fr");
                        ip.getip();
			TraceRouteUI trui=new TraceRouteUI();
			Controller c=new Controller();
			c.setView(trui);
			c.setModel(ip);
			c.start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
