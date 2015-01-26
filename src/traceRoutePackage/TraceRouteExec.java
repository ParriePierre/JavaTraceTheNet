package traceRoutePackage;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TraceRouteExec {

    String chaine = "";

    public TraceRouteExec() throws IOException, InterruptedException {

        //Launches the sub process
        Process p = Runtime.getRuntime().exec("Java -jar fakeroute.jar ece.fr");

        //Get its output stream
        InputStream in = p.getInputStream();

        //Wait for the process to end
        p.waitFor();
        InputStreamReader ipsr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(ipsr);
        String ligne;
        while ((ligne = br.readLine()) != null) {
            chaine += ligne + "\n";
        }

    }

    public String getIp() {
        return chaine;
    }
}
