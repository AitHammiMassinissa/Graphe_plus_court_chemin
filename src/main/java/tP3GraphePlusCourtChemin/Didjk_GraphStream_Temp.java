package tP3GraphePlusCourtChemin;

import org.graphstream.algorithm.generator.RandomGenerator;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.algorithm.Dijkstra;

public class Didjk_GraphStream_Temp {
	
	public void DidjikstraGraphstream(Graph graph) throws Exception {
		long debut , fin ,temp;
		int compteur=1,len=500,maximum=500;
		Generateur_Aleatoire graphgen = new Generateur_Aleatoire();
		RandomGenerator gen =graphgen.Gen_al(graph,6);
		
		BufferedWriter w = new BufferedWriter(new FileWriter("donnée/didjikstraGraphStream.dat"));
		while (compteur<=100) {
			graphgen.demarrer_genb(gen,len);
			debut=System.currentTimeMillis();
			Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, "result", "length");
			dijkstra.init(graph);
			dijkstra.setSource(graph.getNode(0));
			dijkstra.compute();
			fin=System.currentTimeMillis();
			temp=fin-debut;
			System.out.println("Didjikstra de graphstream ----> Noeud : " + graph.getNodeCount() + " Temp d'execution --> " + temp + " ms");
			w.write(String.format("%d%6d%n", graph.getNodeCount(),temp));
			graph.clear();
			compteur++;
			len=maximum * compteur;
			
		}
	w.close();
		}


	public static void main(String[] args) throws Exception{
		
		Didjk_GraphStream_Temp g = new Didjk_GraphStream_Temp();
		Graph graph = new SingleGraph("Graph de l'algorithme didjikstra de graphstream");
		g.DidjikstraGraphstream(graph);
		
	}
}
