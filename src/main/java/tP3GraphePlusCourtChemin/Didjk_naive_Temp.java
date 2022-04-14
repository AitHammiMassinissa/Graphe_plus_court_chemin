package tP3GraphePlusCourtChemin;

import org.graphstream.algorithm.generator.RandomGenerator;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class Didjk_naive_Temp {
	
	public void DidjikstraNaive(Graph graph) throws Exception {
		long debut , fin ,temp;
		int compteur=1,len=500,maximum=500;
		
		Generateur_Aleatoire graphgen = new Generateur_Aleatoire();
		RandomGenerator gen =graphgen.Gen_al(graph,6);
		
		
		BufferedWriter w = new BufferedWriter(new FileWriter("donnée/didjikstanaive.dat"));
		while(compteur<=100) {
			graphgen.demarrer_genb(gen,len);
			debut = System.currentTimeMillis();
			Dijkstra_naïve naivedidj = new Dijkstra_naïve(graph, graph.getNode(0));
			naivedidj.compute();
			fin =System.currentTimeMillis();
			temp=fin-debut;
			System.out.println("<*******Naive Didjikstra********" + graph.getNodeCount() + "> Temp d'execution : " + temp + " ms");
			w.write(String.format("%d%6d%n", graph.getNodeCount(),temp));
			graph.clear();
			compteur++;
			len=maximum * compteur;
		}
		w.close();
	}

	public static void main(String[] args) throws Exception{
	 
		Didjk_naive_Temp n = new Didjk_naive_Temp();
		Graph graph = new SingleGraph("Graph de l'algorithme naive de didjikstra");
		n.DidjikstraNaive(graph);
		
}
}