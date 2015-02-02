package controller;

import traceRoutePackage.IpMatcher;


public class MainClass {

	private static IpMatcher ip;
	
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
