package tP3GraphePlusCourtChemin;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;


public class Dijkstra_naïve {
	Graph graph; 
    Node source;
    HashMap<Node, Double> queue;
    public Dijkstra_naïve(Graph graph, Node noeud_source) {
        this.graph = graph;
        this.source = noeud_source;
        this.queue = new HashMap<Node, Double>();
    }
    private void init() {
        for (Node n : graph.getEachNode()) {
            n.addAttribute("distance", n.getId().equals(source.getId()) ? 0 : Double.POSITIVE_INFINITY);
            n.addAttribute("parent", new Stack<Node>());
        }
    }
 
    public void compute() {
    	init();
        queue.put(source, source.getAttribute("distance"));
        while (queue.size() != 0) {
            Node noued_courant = getMinDistanceNode(queue.keySet());
            Iterator<Edge> Iterator_Edge = noued_courant.getLeavingEdgeIterator();
            queue.remove(noued_courant);
            while (Iterator_Edge.hasNext()) {
                Edge Edge_Courant = Iterator_Edge.next();
                Node Noud_op = Edge_Courant.getTargetNode();
                if(! queue.containsKey(Noud_op)) {
                    Double Distance_Noued_Courant = noued_courant.getAttribute("distance");
                    Double Poid_Edge = Edge_Courant.getAttribute("cap");
                    Double somme = Distance_Noued_Courant + Poid_Edge;
                    Double Distance_Noued_op = Noud_op.getAttribute("distance");
                    if (Distance_Noued_op > somme) {
                    	Noud_op.setAttribute("distance", somme);
                    	Noud_op.setAttribute("parent", noued_courant);
                        queue.put(Noud_op, Noud_op.getAttribute("distance"));
                    }
                }
            }
        }
    }
		    /**
		     * 
		     * @param nodes
		     * @return Node
		     */
		    private Node getMinDistanceNode(Set<Node> nodes) {
		        Node Min_Distance_Noued = null;
		        Double Min_Distance = Double.MAX_VALUE;
		        for (Node node : nodes) {
		            Double Noued_Ditance = node.getAttribute("distance");
		            if (Noued_Ditance < Min_Distance) {
		            	Min_Distance = Noued_Ditance;
		            	Min_Distance_Noued = node;
		            }
		        }
		        return Min_Distance_Noued;
		    }
			/**
			 * 
			 * @return graph
			 */
				public Graph getGraph() {
					return graph;
				}
			/**
			 * 
			 * @return source
			 */
				public Node getSource() {
					return source;
				}
			/**
			 * 
			 * @return HashMap<Node, Double>
			 */
				public HashMap<Node, Double> getQueue() {
					return queue;
				}
			/**
			 * 
			 * @param graph
			 */
				public void setGraph(Graph graph) {
					this.graph = graph;
				}
			/**
			 * 
			 * @param source
			 */
				public void setSource(Node source) {
					this.source = source;
				}
			/**
			 * @param HashMap<Node, Double> queue
			 */
				public void setQueue(HashMap<Node, Double> queue) {
					this.queue = queue;
				}
			/**
			 *  @return boolean
			 */
				 public boolean QueuVide() {
				        return queue.isEmpty();
				    }
			  
			}


