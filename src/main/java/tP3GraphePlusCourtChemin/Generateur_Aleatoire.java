package tP3GraphePlusCourtChemin;



import org.graphstream.algorithm.generator.RandomGenerator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

public class Generateur_Aleatoire {
	public RandomGenerator Gen_al(Graph graph ,double avrage_degree){
		RandomGenerator random_gen = new RandomGenerator(avrage_degree,false,false);
		random_gen.addEdgeAttribute("cap");
		random_gen.addSink(graph);
		return random_gen;
	}
	
	public void demarrer_genb(RandomGenerator gn , int nb_nd) {
		gn.begin();
		for (int i=0;i<nb_nd;i++) {
			gn.nextEvents();
		}
		gn.end();
	}
	

	
}
