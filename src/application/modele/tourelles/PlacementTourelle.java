package application.modele.tourelles;

import application.modele.bfs.Coordonnes;

public class PlacementTourelle {

	private Coordonnes c;
	private boolean isAvailable;
	private int[][] matrice;
	
	public PlacementTourelle(Coordonnes c, int[][] matrice) {
		this.c = c;
		this.isAvailable = true;
		this.matrice = matrice;
	}
	
	public int getTileX() {
		return this.c.getX()/32;
	}
	
	public int getTileY() {
		return this.c.getY()/32;
	}
	
	public boolean getIsAvailable() {
		return this.isAvailable;
	}
	
	public void setIsAvailable(boolean etat) {
		this.isAvailable = etat;
	}
	

}
