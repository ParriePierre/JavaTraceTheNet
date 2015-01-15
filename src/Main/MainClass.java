package Main;

import java.io.IOException;
import traceRoutePackage.TraceRouteExec;


public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
            char[] ip;
            TraceRouteExec trace = new TraceRouteExec();
            ip = trace.getIp();
            System.out.println(ip[0]);
	}

}
