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
	
//	public SpriteZombie(Zombie zombie, Environnement env) throws FileNotFoundException {
//		this.zombie = zombie;
//		this.env = env;
//		this.env.getListeZombies().add(zombie);
//		if(this.zombie instanceof Sprinteur) {
//			this.image = new Image(new FileInputStream("src/application/vue/ressources/zombies/zombieImmobile.png"));
//			this.sprite = new ImageView(this.image);
//		}
//	}
	
	public SpriteZombie(Zombie z, int x, int y) {
		this.zombie = z;
		this.posX = x;
		this.posY = y;
	}
	
	public void creerSpriteZombie(Pane pane, Zombie z) {
		ImageView test = this.zombie.initSpriteZombie(z.getX(), z.getY());
		pane.getChildren().add(test);
		test.translateXProperty().bind(z.getXProperty());
		test.translateYProperty().bind(z.getYProperty());
	}
	
	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
	
}
