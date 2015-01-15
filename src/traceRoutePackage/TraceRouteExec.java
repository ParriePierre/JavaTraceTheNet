package traceRoutePackage;

import fr.ece.fauberte.fakeroute.trace.FakeTraceGenerator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Process;
import java.lang.ProcessBuilder;

public class TraceRouteExec {
    char[] ip;
    public TraceRouteExec() throws IOException, InterruptedException {
        /*FakeTraceGenerator generator = new FakeTraceGenerator("ece.fr");
        
        System.out.println(generator.generate());*/
       
        
        //Create a process builder that contains the command and its arguments
        ProcessBuilder pb = new ProcessBuilder();

        //Launches the sub process
        Process p =  Runtime.getRuntime().exec("Java -jar fakeroute.jar ece.fr");

        //Get its output stream
        InputStream in = p.getInputStream();

        //Wait for the process to end
        p.waitFor();
        
        
        char buff = ' ';
        int test = 0;
        int i = 0;
		//read the output
        //read the first character
        test = in.read();
        buff = (char) test;
        
        ip[i] = buff;
       
        while (test != -1) {
            //print a character
           // System.out.print(buff);
            //read the next
           ip[i] = buff;
           i++;
           test = in.read();
           buff = (char) test;
        }
    }
    
    public char[] getIp(){
                return ip;
    }
}
