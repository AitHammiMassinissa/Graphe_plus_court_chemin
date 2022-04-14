package tP3GraphePlusCourtChemin;




import org.graphstream.algorithm.Dijkstra;
import org.graphstream.algorithm.Toolkit;
import org.graphstream.algorithm.generator.RandomGenerator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Tester_temp_deux_version {
	
    private static void applyParameters(Graph g) {
        // On vérifie le graphe
        System.setProperty("org.graphstream.ui", "swing");
        // On améliore la qualité du graphe
        g.setAttribute("ui.quality");
        g.setAttribute("ui.antialias");
        // On applique un style css au graphe
        g.setAttribute("ui.stylehseet", "url('donnée/feuilledestyle.css')");

		// On affiche les noms des noeuds du graphe sur l'image
        g.forEach(n -> n.setAttribute("ui.label", n.getId()));
    }
    
    
    
	public static void main(String[] args) {
	
	
		Thread threadnaive = new Thread(()->{
			try {
				Didjk_naive_Temp.main(args);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	   Thread threagraphstreamdidj = new Thread(()->{
			try {
				Didjk_GraphStream_Temp.main(args);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	    threadnaive.start();
		threagraphstreamdidj.start();
		
   
	
	
	
	/****************************************************Autres test *******************************************/
	   
	 /*	
		 System.out.println("\n<-------------------- Générateurs de graphes Test ------------------->\n");
	        Graph graphExemple1 = new SingleGraph("Exemple 1");
	        Generateur_Aleatoire g = new Generateur_Aleatoire();
	        RandomGenerator g1= g.Gen_al(graphExemple1, 5);
	        g.demarrer_genb(g1, 2);
	        applyParameters(graphExemple1);
	        graphExemple1.display();
	  */
		

	 /*	
		System.out.println("\n<--------------------Liste des plus courts chemins Naive didjkstra  ------------------->\n");

		 	Graph graphExemple2 = new SingleGraph("Exemple 1");
	        Generateur_Aleatoire g = new Generateur_Aleatoire();
	        RandomGenerator g1= g.Gen_al(graphExemple2, 10);
	        g.demarrer_genb(g1, 5);
	        applyParameters(graphExemple2);
	        graphExemple2.display();
	        Node s = graphExemple2.getNode(0);
	        Node d = Toolkit.randomNode(graphExemple2);
		
     Dijkstra_naïve naiveDijkstra = new Dijkstra_naïve(graphExemple2,s );
     naiveDijkstra.compute();
   
     System.out.println("Liste des plus courts chemins entre le noeud source " + s.getIndex() + " et les autres noeuds de graphe :\n");
     for (Node node : graphExemple2) {
         System.out.print("Noeud " + s + "->" + node + " : ");
         if ((double) node.getAttribute("distance") ==  Double.POSITIVE_INFINITY){
             System.out.print("distance = Infinity\n");
         }
         else {
             System.out.print("distance = " + node.getAttribute("distance") + "\n");
         }
     }
     
  */ 
	/*	
	  System.out.println("\n<--------------------Liste des plus courts chemins didjikstra graphstream------------------->\n");
	    Graph graphExemple1 = new SingleGraph("Exemple 1");
      Generateur_Aleatoire g = new Generateur_Aleatoire();
      RandomGenerator g1= g.Gen_al(graphExemple1, 10);
      g.demarrer_genb(g1, 5);
      applyParameters(graphExemple1);
      graphExemple1.display();
      Node s = graphExemple1.getNode(0);
      Node d = Toolkit.randomNode(graphExemple1);

      System.out.println("--> Test d'algorithme de Dijkstra de GraphStream :\n");

      // Utilisation de l'algorithme de Dijkstra de GraphStream
      Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, "result", "length");
		dijkstra.init(graphExemple1);
		dijkstra.setSource(s);
		dijkstra.compute();

  
      System.out.println("Liste des plus courts chemins entre le noeud source " + s.getIndex() + " et les autres noeuds de graphe :\n");
      for (Node node : graphExemple1) {
          System.out.printf("Noeud %s->%s : distance =%6.2f%n", dijkstra.getSource(), node, dijkstra.getPathLength(node));
      }
*/
	}
}
