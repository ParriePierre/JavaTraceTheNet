package traceRoutePackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Process;
import java.lang.ProcessBuilder;

public class TraceRouteExec {
	public TraceRouteExec() throws IOException, InterruptedException {
		// Launches the sub process
		Process p = Runtime.getRuntime().exec("java -jar fakeroute.jar ece.fr");

		// Get its output stream
		InputStream in = p.getInputStream();

		// Wait for the process to end
		p.waitFor();
		
		String chaine="";
		InputStreamReader ipsr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(ipsr);

		String ligne;
		while ((ligne = br.readLine()) != null) {
			System.out.println(ligne);
			chaine += ligne + "\n";
		}
		br.close();
	}
}
