package application.modele.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Bfs {

	private HashMap<Sommet, Sommet> associationPereFils;
	
	public Bfs(Graphe graphe) {
		LinkedList<Sommet> file = new LinkedList<Sommet>();
		this.associationPereFils = new HashMap<Sommet, Sommet>();
		
		Sommet sommetDeDepart = graphe.getSommetDeDepart(new Coordonnes(448, 672));
		sommetDeDepart.setExplore(true);
		file.addFirst(sommetDeDepart);		
		while(file.size() != 0) {
			
			Sommet s = 	file.removeLast();
//			System.out.println(s);
//			System.out.println(s.getListeSommetsAccessible());

			for(Sommet sommetFils : s.getListeSommetsAccessible()) {
				if(!sommetFils.isExplore()) {
					this.associationPereFils.put(sommetFils, s);
					sommetFils.setExplore(true);
					file.addFirst(sommetFils);
				}
			}
		}
//		System.out.println(this.associationPereFils);
	}
	
	public HashMap<Sommet, Sommet> getAssociationPereFils() {
		return this.associationPereFils;
	}
	
	
}
