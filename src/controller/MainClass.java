package controller;

import traceRoutePackage.IpMatcher;


public class MainClass {
	/*static{System.loadLibrary("gvc");
	System.loadLibrary("cgraph");
	System.loadLibrary("cdt");
	}*/

	private static IpMatcher ip;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			//System.out.println(System.getProperty("java.library.path"));
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
