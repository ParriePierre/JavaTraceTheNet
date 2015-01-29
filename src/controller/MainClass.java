package controller;

import java.io.IOException;

import traceRoutePackage.IpMatcher;
import view.TraceRouteUI;


public class MainClass {

	/**
	 * @param args
	 */
    
	public static void main(String[] args) {
		
		try {
			//TraceRouteExec tre = new TraceRouteExec();
            IpMatcher ip = new IpMatcher();
			TraceRouteUI trui=new TraceRouteUI();
			Controller c=new Controller();
			c.setView(trui);
			c.setModel(ip);
			c.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
