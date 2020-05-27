package application.vue;

import application.modele.tourelles.Tourelle;
import javafx.scene.layout.Pane;

public class SpriteTourelle {
	
	private Tourelle tourelle;
	private int posX, posY;
	
	public SpriteTourelle(Tourelle tourelle, int posX, int posY) {
		this.tourelle = tourelle;
		this.posX = posX;
		this.posY = posY;
	}
	public void creerSpriteTourelle(Pane pane, SpriteTourelle tour) {
        pane.getChildren().add(this.tourelle.initSpriteTourelle(tour.getX(), tour.getY()));
	}
	
	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
}