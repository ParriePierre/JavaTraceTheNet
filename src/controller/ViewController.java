package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

/**
 * Controller class of TraceRouteInterface.xml
 * 
 * We used Scene Builder to design our application.
 * 
 * @author parrie
 *
 */
public class ViewController implements Initializable {

	public IpMatcher model;

	private static final String IPADDRESS_PATTERN = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5]))";

	private static final String STAR_PATTERN = "(\\*)";

	private static final String TIME_PATTERN = "((\\d\\d\\d)\\.(\\d\\d\\d)|(\\d\\d)\\.(\\d\\d\\d)|(\\d)\\.(\\d\\d\\d))";

	@FXML
	private TextField ipAddress;

	@FXML
	private BorderPane bp;

	private SwingNode center;

	private Graph graph;

	private View view;

	/**
	 * Initialize: - the graph and its view/viewer, which are used only for view
	 * purpose - the model
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		model = MainClass.getModel();

		graph = new SingleGraph("TraceRoute Graph");
		graph.setAutoCreate(true);

		Viewer viewer = new Viewer(graph,
				Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
		viewer.enableAutoLayout();
		view = viewer.addDefaultView(false);
		view.setSize(640, 400);

		center = new SwingNode();

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

	/**
	 * Build a string which suits an IP adress
	 */
	@FXML
	private void generateRandomIpButton() {
		Random rd = new Random();
		StringBuilder sb = new StringBuilder();
		int a, b, c, d;

		a = rd.nextInt(256);
		b = rd.nextInt(256);
		c = rd.nextInt(256);
		d = rd.nextInt(256);
		sb.append(a);
		sb.append(".");
		sb.append(b);
		sb.append(".");
		sb.append(c);
		sb.append(".");
		sb.append(d);

		ipAddress.setText(sb.toString());
	}

	/**
	 * Manage to read all IP and sort them so that it makes a tree
	 */
	@FXML
	private void traceRouteButton() {
		if (ipAddress.getText().isEmpty()) {
			ipAddress.setText("Enter an ip first");
		} else {
			try {
				String[] qqc = model.getIps(ipAddress.getText());
				int j = 3;
				List<Node> pnodelist=new ArrayList<Node>();
				List<Node> newpnodelist=new ArrayList<Node>();
				
				Node ParentNode = graph.getNode(qqc[0]);
				if (ParentNode == null) {
					graph.addNode(qqc[0]);
					ParentNode = graph.getNode(qqc[0]);
				}
				pnodelist.add(ParentNode);
				Node ActualNode = null;
				
				for (int i = 1; i < qqc.length; i++) {
					if (qqc[i] != null) {
						
						Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
						Matcher matcher = pattern.matcher(qqc[i]);
						Pattern pattern2 = Pattern.compile(STAR_PATTERN);
						Matcher matcher2 = pattern2.matcher(qqc[i]);
						Pattern pattern3 = Pattern.compile(TIME_PATTERN);
						Matcher matcher3 = pattern3.matcher(qqc[i]);
						
						if (matcher.find()) {
							try {
								graph.addNode(qqc[i]);
								ActualNode = graph.getNode(qqc[i]);
								for(int l=0; l<pnodelist.size();l++)
								{
									graph.addEdge(ActualNode.getId() + " "
										+ pnodelist.get(l).getId(),
										ActualNode.getId(), pnodelist.get(l).getId());
								}
								newpnodelist.add(ActualNode);
							} catch (IdAlreadyInUseException e) {
							}
						} else if (matcher2.find()) {
							j--;
							if (j == 0) {
								j = 3;
								pnodelist.clear();
								for(int l=0; l<newpnodelist.size(); l++)
								{
									pnodelist.add(newpnodelist.get(l));
								}
								newpnodelist.clear();
							}
						} else if (matcher3.find()) {
							j--;
							if (j == 0) {
								j = 3;
								pnodelist.clear();
								for(int l=0; l<newpnodelist.size(); l++)
								{
									pnodelist.add(newpnodelist.get(l));
								}
								newpnodelist.clear();
							}
						}
					}
				}
				for (Node n : graph) {
					n.addAttribute("ui.label", n.getId());
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
