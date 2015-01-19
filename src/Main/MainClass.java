package Main;

import java.io.IOException;

import traceRoutePackage.*;
import view.*;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			TraceRouteExec tre = new TraceRouteExec();
			TraceRouteUI trui=new TraceRouteUI();
			Controller c=new Controller(trui,tre);
			c.start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
