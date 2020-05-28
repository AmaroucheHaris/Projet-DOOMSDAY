package application.vue;


import application.modele.ennemis.Zombie;
import javafx.beans.property.IntegerProperty;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SpriteZombie {
	private ImageView sprite;
	private Zombie zombie;
	private int posX, posY;
	
//	public SpriteZombie(Zombie zombie, Environnement env) throws FileNotFoundException {
//		this.zombie = zombie;
//		this.env = env;
//		this.env.getListeZombies().add(zombie);
//		if(this.zombie instanceof Sprinteur) {
//			this.image = new Image(new FileInputStream("src/application/vue/ressources/zombies/zombieImmobile.png"));
//			this.sprite = new ImageView(this.image);
//		}
//	}
	
	public SpriteZombie(Zombie zombie, int posX, int posY) {
		this.zombie = zombie;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void creerSpriteZombie(Pane pane, Zombie z) {
		this.sprite.translateXProperty().bind(z.getXProperty());
        this.sprite.translateYProperty().bind(z.getYProperty());
        pane.getChildren().add(z.initSpriteZombie(this.getX(), this.getY()));
	}
	
	public IntegerProperty getX() {
		return this.zombie.getXProperty();
	}
	
	public IntegerProperty getY() {
		return this.zombie.getYProperty();
	}
}
