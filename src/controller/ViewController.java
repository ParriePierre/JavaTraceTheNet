package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingUtilities;

import org.graphstream.graph.Graph;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;

import traceRoutePackage.IpMatcher;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ViewController implements Initializable {
	
	public IpMatcher model;
	
	private static final String IPADDRESS_PATTERN
    = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
    + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
    + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
    + "([01]?\\d\\d?|2[0-4]\\d|25[0-5]))";

	@FXML
	private TextField ipAddress;
	
	@FXML
	private BorderPane bp;
	
	private SwingNode center;
	
	private Graph graph;
	
	private View view;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		model=MainClass.getModel();
		
		graph=new SingleGraph("TraceRoute Graph");
		graph.setAutoCreate(true);
        
        Viewer viewer=new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout();
        view= viewer.addDefaultView(false);
        view.setSize(640, 400);
        
        center=new SwingNode();
        
        createSwingContent(center);
        
        bp.setCenter(center);
	}
	
	private void createSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                swingNode.setContent(view);
            }
        });
    }
	
	@FXML
	private void generateRandomIpButton()
	{
		Random rd = new Random();
		StringBuilder sb=new StringBuilder();
		int a,b,c,d;
		
		a=rd.nextInt(256);
		b=rd.nextInt(256);
		c=rd.nextInt(256);
		d=rd.nextInt(256);
		sb.append(a);
		sb.append(".");
		sb.append(b);
		sb.append(".");
		sb.append(c);
		sb.append(".");
		sb.append(d);
		
		ipAddress.setText(sb.toString());
	}
	
	@FXML
	private void traceRouteButton()
	{
		if(ipAddress.getText().isEmpty())
		{
			ipAddress.setText("Enter an ip first");
		}else {
			try {
				String[] qqc =model.getIps(ipAddress.getText());
				for(int i=0; i<qqc.length;i++)
				{
					if(qqc[i] != null)
					{
						Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
						Matcher matcher = pattern.matcher(qqc[i]);
						if(matcher.find())
						{
							try
							{
								graph.addNode(qqc[i]);
							}catch(IdAlreadyInUseException e)
							{}
						} else
						{
							
						}
					}
				}
				Node previousNode=null;
				for(Node n:graph) {
					if(previousNode!=null)
						graph.addEdge(n.getId()+ " " + previousNode.getId(), n.getId(), previousNode.getId());
					previousNode=n;
					n.addAttribute("ui.label", n.getId());
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
