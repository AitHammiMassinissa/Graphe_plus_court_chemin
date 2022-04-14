package tP3GraphePlusCourtChemin;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.graphstream.algorithm.generator.RandomGenerator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.jupiter.api.BeforeEach;



public class Test {
	 	RandomGenerator gen;
	    Graph graph;
	    Dijkstra_naïve naiveDijkstra;
	    Node source;

	  @BeforeEach
	
	    void avant_tout() {
	        graph = new SingleGraph("Tester le djiksta naive");
	        gen = new RandomGenerator(4, false, true);
	        gen.addEdgeAttribute("cap"); 
	        gen.addSink(graph);
	        gen.begin();
	        for (int i = 0; i < 200; i++) {
	        	gen.nextEvents();
	        }
	        gen.end();
	        source = graph.nodeFactory().newInstance("source", graph);
	        naiveDijkstra = new Dijkstra_naïve(graph, source);
	    }

	    

	  @org.junit.jupiter.api.Test
	    void compute() {
	        assertNotNull(naiveDijkstra.getGraph(), "Erreur sur le graphe ---->    Pas de graphique pour calculer le plus court chemin");
	        assertNotNull(naiveDijkstra.getSource(), "Erreur sur le noeud source ---->  Pas de noued source ");
	        assertTrue(naiveDijkstra.QueuVide(), "Erreur sur la HashMap queu ---->   La queu n'est pas vide "); 
	    }
	  
	  @org.junit.jupiter.api.Test
	    void testgetset() {
	        assertTrue(naiveDijkstra.getGraph().equals(graph), "Erreur sur le graphe ---->  Graph null ou mis à jours");
	        assertNotNull(naiveDijkstra.getGraph(), "Erreur sur le graphe ---->  Graph null");
	        assertNotNull(naiveDijkstra.getGraph(), "Erreur sur le graphe ---->  Attributs de graph null");
	        assertTrue(naiveDijkstra.getGraph().equals(graph), "Erreur sur le graphe ---->  Attributs de graph mise à jour ");
	        assertTrue(naiveDijkstra.getSource().equals(source), "Erreur sur la source ---->  Source null ou mise à jours");
	        assertNotNull(naiveDijkstra.getSource(), "Erreur sur la source ---->  Source vide ");
	        naiveDijkstra.setSource(source); // setting source to null to test
	        assertNotNull(naiveDijkstra.getSource(), "Erreur sur la source ---->  Source toujour null");
	    }
	    
	}
