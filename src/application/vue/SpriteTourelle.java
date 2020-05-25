package application.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.modele.Environnement;
import application.modele.tourelles.TireurDeBase;
import application.modele.tourelles.Tourelle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SpriteTourelle {
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
	
	private Tourelle tourelle;
	
	public void creerSpriteTourelle(Pane pane) {
//		this.tourelle.initSpriteTourelle(env, tourelle).translateXProperty().bind(tourelle.getXProperty());
//		this.tourelle.initSpriteTourelle(env, tourelle).translateYProperty().bind(tourelle.getYProperty());
        
//        pane.getChildren().add(this.tourelle.initSpriteTourelle(env, tourelle));
        pane.getChildren().add(this.tourelle.initSpriteTourelle());
	}
}