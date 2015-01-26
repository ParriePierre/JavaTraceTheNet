package Main;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import traceRoutePackage.TraceRouteExec;

public class MainClass {

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

    public static void main(String[] args) throws IOException, InterruptedException {
        Pattern pattern;
        Matcher matcher;
        String ip;
        String[] ips = new String[200];
        TraceRouteExec trace = new TraceRouteExec();
        ip = trace.getIp();
        int i = 0;
        System.out.println(ip);

        try {

            pattern = Pattern.compile(IPADDRESS_PATTERN);
            matcher = pattern.matcher(ip);
            while (matcher.find()) {

                ips[i] = matcher.group();

                System.out.println(ips[i]);
                i++;
            }
        } catch (PatternSyntaxException pse) {
            pse.printStackTrace();
        }
    }

}
