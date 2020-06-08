package application.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.modele.Environnement;
import application.modele.tourelles.Archer;
import application.modele.tourelles.Militaire;
import application.modele.tourelles.TireurDeBase;
import application.modele.tourelles.Tourelle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
	
public class SpriteTourelle {
	private Tourelle tourelle;
	private Environnement env;
	private Image image;
	private ImageView sprite;
	private int posX, posY;
		
	public SpriteTourelle(Tourelle tourelle, Environnement env, int posX, int posY) throws FileNotFoundException {
		this.tourelle = tourelle;
		this.env = env;
		this.env.getListeTourelles().add(tourelle);
		this.posX = posX;
		this.posY = posY;
		if(this.tourelle instanceof Militaire) {
			this.image = new Image(new FileInputStream("src/application/vue/ressources/tourelles/Militaire.png"));
			this.sprite = new ImageView(this.image);
		}
		else if(this.tourelle instanceof Archer) {
			this.image = new Image(new FileInputStream("src/application/vue/ressources/tourelles/Archer.png"));
			this.sprite = new ImageView(this.image);
		}
		this.sprite.setX(this.posX);
		this.sprite.setY(this.posY);
	}
		
	public void creerSpriteTourelle(Pane pane) {
	       pane.getChildren().add(this.sprite);
	}
	
	public void supprimerSpriteTourelle(Pane pane) {
	       pane.getChildren().remove(this.sprite);
	}
	
//	private Tourelle tourelle;
//	private Environnement env;
//	private Image image;
//	private ImageView sprite;
//	
//	public SpriteTourelle(Tourelle tourelle, Environnement env) throws FileNotFoundException {
//		this.tourelle = tourelle;
//		this.env = env;
//		this.env.getListeTourelles().add(tourelle);
//		if(this.tourelle instanceof TireurDeBase) {
//			this.image = new Image(new FileInputStream("src/application/vue/ressources/tourelles/TourelleBase.png"));
//			this.sprite = new ImageView(this.image);
//		}
//	}
//	
//	public void creerSpriteTourelle(Pane pane) {
//		this.sprite.translateXProperty().bind(tourelle.getXProperty());
//        this.sprite.translateYProperty().bind(tourelle.getYProperty());
//        pane.getChildren().add(this.sprite);
//	}			
}