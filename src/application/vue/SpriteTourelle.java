package application.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.modele.Environnement;
import application.modele.Tourelle;
import application.modele.TireurDeBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SpriteTourelle {
	private Tourelle tourelle;
	private Environnement env;
	private Image image;
	private ImageView sprite;
	
	public SpriteTourelle(Tourelle tourelle, Environnement env) throws FileNotFoundException {
		this.tourelle = tourelle;
		this.env = env;
		this.env.getListeTourelles().add(tourelle);
		if(this.tourelle instanceof TireurDeBase) {
			this.image = new Image(new FileInputStream("src/application/vue/ressources/tourelles/TourelleBase.png"));
			this.sprite = new ImageView(this.image);
		}
	}
	
	public void creerSpriteTourelle(Pane pane) {
		this.sprite.translateXProperty().bind(tourelle.getXProperty());
        this.sprite.translateYProperty().bind(tourelle.getYProperty());
        pane.getChildren().add(this.sprite);
	}
}