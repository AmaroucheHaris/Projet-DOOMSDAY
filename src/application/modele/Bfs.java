package application.modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Bfs {

	private HashMap<Sommet, Sommet> associationPereFils;
	
	public Bfs(Sommet sommetDeDepart) {
		LinkedList<Sommet> file = new LinkedList<Sommet>();
		this.associationPereFils = new HashMap<Sommet, Sommet>();
		
		sommetDeDepart.setExplore(true);
		file.addFirst(sommetDeDepart);		
		while(file.size() != 0) {
			
			Sommet s = 	file.removeLast();

			
			for(Sommet sommetFils : s.getListeSommetsAccessible()) {
				if(!sommetFils.isExplore()) {
					this.associationPereFils.put(sommetFils, s);
					sommetFils.setExplore(true);
					file.addFirst(sommetFils);
				}
			}
		}
	}
	
	public HashMap<Sommet, Sommet> getAssociationPereFils() {
		return this.associationPereFils;
	}
	
	
}
