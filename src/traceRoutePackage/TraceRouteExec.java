package traceRoutePackage;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TraceRouteExec {

    String chaine = "";
    String adress;
    
    /**
     * Launche the Fakeroute process and store the entire output in a string
     * @param Adress
     * The adress of the server to trace
     * @throws IOException
     * @throws InterruptedException
     */
    public TraceRouteExec(String Adress, int mode) throws IOException, InterruptedException {
        adress = Adress;
        //Launches the sub process
        Process p =null;
        switch(mode)
        {
        case 0: p = Runtime.getRuntime().exec("java -jar fakeroute.jar " + adress);
        		break;
        		
        case 1: p = Runtime.getRuntime().exec("java -jar fakeroute.jar " + adress);
        		break;
        		
        case 2: p = Runtime.getRuntime().exec("tracert " +adress);
        		break;
        	
        default: System.out.print("Error, no mode selected!\n");
        }
        //Process p = Runtime.getRuntime().exec("java -jar fakeroute.jar " + adress);
        //Process p = Runtime.getRuntime().exec("traceroute " + adress);

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
