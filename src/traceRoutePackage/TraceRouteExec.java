package traceRoutePackage;

import java.io.IOException;
import java.io.InputStream;
import java.lang.Process;
import java.lang.ProcessBuilder;

public class TraceRouteExec {
	public TraceRouteExec() throws IOException, InterruptedException
	{
		//Create a process builder that contains the command and its arguments
		ProcessBuilder pb = new ProcessBuilder("traceroute","-n","google.com");
		
		//Launches the sub process
		Process p = pb.start();
		
		//Get its output stream
		InputStream in=p.getInputStream();
		
		//Wait for the process to end
		p.waitFor();
		
		char buff=' ';
		int test=0;
		//read the output
			//read the first character
		test= in.read();
		buff=(char) test;
		while(test!=-1)
		{
			//print a character
			System.out.print(buff);
			//read the next
			test= in.read();
			buff=(char) test;
		}
	}
}
