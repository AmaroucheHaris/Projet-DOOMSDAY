package application.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.modele.Environnement;
import application.modele.ennemis.Sprinteur;
import application.modele.ennemis.Zombie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SpriteZombie {
	private Zombie zombie;
	private int posX;
	private int posY;
	private ImageView sprite;
	
	public SpriteZombie(Zombie z, int x, int y) {
		this.zombie = z;
		this.posX = x;
		this.posY = y;
		this.sprite = this.zombie.initSpriteZombie(z.getX(), z.getY());
	}
	
	public void creerSpriteZombie(Pane pane, Zombie z) {
		sprite.translateXProperty().bind(z.getXProperty());
		sprite.translateYProperty().bind(z.getYProperty());
		pane.getChildren().add(this.zombie.initSpriteZombie(z.getX(), z.getY()));
	}
	
	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
	
}
