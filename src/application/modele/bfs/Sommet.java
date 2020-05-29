package application.modele.bfs;

import java.util.ArrayList;

public class Sommet {
	private Coordonnes coordonnes;
	private boolean explore;
	private ArrayList<Sommet> listeSommetsAccessible;
	//private Sommet sommetPere;
	//private double distance = 1000;
	
	public Sommet(Coordonnes coord) {
		this.coordonnes = coord;
		this.explore = false;
		this.listeSommetsAccessible = new ArrayList<Sommet>();
		//this.sommetPere = null;
	}
	
	public void ajouterListeSommetAccessible(Sommet sommet) {
		this.listeSommetsAccessible.add(sommet);
	}

	public Coordonnes getCoordonnes() {
		return coordonnes;
	}

	public void setCoordonnes(Coordonnes coordonnes) {
		this.coordonnes = coordonnes;
	}

	public boolean isExplore() {
		return explore;
	}

	public void setExplore(boolean explore) {
		this.explore = explore;
	}

	public ArrayList<Sommet> getListeSommetsAccessible() {
		return listeSommetsAccessible;
	}

	

//	public Sommet getSommetPere() {
//		return this.sommetPere;
//	}
//
//	public void setSommetPere(Sommet sommetPere) {
//		this.sommetPere = sommetPere;
//	}

//	public double getDistance() {
//		return distance;
//	}
//
//	public void setDistance(double distance) {
//		this.distance = distance;
//	}
	
	public void ajouterSommet(Sommet s) {
		if(!this.listeSommetsAccessible.contains(s)) {
			//System.out.println(s);
			this.listeSommetsAccessible.add(s);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordonnes == null) ? 0 : coordonnes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sommet other = (Sommet) obj;
		if (coordonnes == null) {
			if (other.coordonnes != null)
				return false;
		} else if (!coordonnes.equals(other.coordonnes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sommet [coordonnes=" + coordonnes + ", listeSommetsAccessible=" + listeSommetsAccessible.size() + "]";
	}

//	public boolean contain(Sommet s) {
//		if(s.getCoordonnes().getX() == this.coordonnes.getX() && s.getCoordonnes().getY() == this.coordonnes.getY()) {
//			return true;
//		}
//		for(Sommet sommet : this.listeSommetsAccessible) {
//			if(s.getCoordonnes().getX() == sommet.getCoordonnes().getX() && s.getCoordonnes().getY() == sommet.getCoordonnes().getY()) {
//				return true;
//			}
//		}
//		return false;
//	}
	
//	public void afficheFils() {
//		for(Sommet s : listeSommetsAccessible) {
//			System.out.println("fils : " + "x= " + s.getCoordonnes().getX() + "y= " + s.getCoordonnes().getY());
//		}
//	}
	
	public boolean estAdjacent(Sommet s) {
		if(this.coordonnes.estAdjacent(s.getCoordonnes())) {
			return true;
		}
		return false;
	}
	
	
}
