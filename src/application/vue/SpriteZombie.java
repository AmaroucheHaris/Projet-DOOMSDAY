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
	private Environnement env;
	private Image image;
	private ImageView sprite;
	
	public SpriteZombie(Zombie zombie) throws FileNotFoundException {
		this.zombie = zombie;
		this.env = zombie.getEnvironnement();
		this.env.getListeZombies().add(zombie);
		if(this.zombie instanceof Sprinteur) {
			this.image = new Image(new FileInputStream("src/application/vue/ressources/zombies/zombieImmobile.png"));
			this.sprite = new ImageView(this.image);
		}
	}
	
	public void ajouterSpriteZombie(Pane pane) {
		this.sprite.translateXProperty().bind(zombie.getXProperty());
        this.sprite.translateYProperty().bind(zombie.getYProperty());
        pane.getChildren().add(this.sprite);
	}
	
	public void suprimerSpriteZombie(Pane pane) {
		this.sprite.translateXProperty().unbind();
        this.sprite.translateYProperty().unbind();
		pane.getChildren().remove(this.sprite);
	}
	
}
