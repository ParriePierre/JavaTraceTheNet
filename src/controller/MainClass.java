package controller;

import java.io.IOException;

import traceRoutePackage.IpMatcher;
import view.TraceRouteUI;


public class MainClass {

	private static IpMatcher ip;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
            ip = new IpMatcher();
			Controller c=new Controller();
			c.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static IpMatcher getModel()
	{
		return ip;
	}
	

}
