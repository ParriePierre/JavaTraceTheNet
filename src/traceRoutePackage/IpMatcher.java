package traceRoutePackage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class IpMatcher {

    /**
     * @param args
     */
    private static final String IPADDRESS_PATTERN
            = "(\\*)|"
            + "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5]))|"
            + "((\\d\\d\\d)\\.(\\d\\d\\d)|(\\d\\d)\\.(\\d\\d\\d)|(\\d)\\.(\\d\\d\\d))";
    
    /**
     * Launch Fakeroute and store the result in the returned table
     * 
     * @param adress
     * The adress of the server to ping as URL or IP adress
     * @return
     * Returns a table of all the times and IPs find by traceroute.
     * @throws IOException
     * @throws InterruptedException
     */
    public String[] getIps(String adress) throws IOException, InterruptedException{
        Pattern pattern;
        Matcher matcher;
        String ip;
        String[] ips=new String[200];
        
        //System.out.print(adress);
      
        TraceRouteExec trace = new TraceRouteExec(adress);
        ip = trace.getIp();
        int i = 0;
        
        System.out.println(ip);
        
        try {

        	pattern = Pattern.compile(IPADDRESS_PATTERN);
        	matcher = pattern.matcher(ip);
        	while (matcher.find()) {

        		ips[i] = matcher.group();
        		i++;
        	}
        } catch (PatternSyntaxException pse) {
        	pse.printStackTrace();
        }
        
		return ips;
    }
   
}
