package application.controleur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

import application.modele.Environnement;
import application.modele.Sprinteur;
import application.modele.TabMap1;
import application.modele.Zombie;
import application.vue.SpriteZombie;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class ControleurMap implements Initializable {

	@FXML
	private TilePane Tpane;
	@FXML
	private Pane paneCentrale;
	
	private Environnement env;
	private Timeline gameloop;
	private int time;
	private TabMap1 mapAGenerer;	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		mapAGenerer = new TabMap1();
		
		mapAGenerer.genererMap(Tpane);
		//env.initSommets();
		
		this.env = new Environnement(960, 704, mapAGenerer);
		
		
			SpriteZombie sp;
			try {
				sp = new SpriteZombie(new Sprinteur(0, 96), env);
				env.initZombie();
				sp.creerSpriteZombie(paneCentrale);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			 
		
		
		animation();
		gameloop.play();

	}
	
	private void animation() {
		this.gameloop = new Timeline();
		this.time = 0;
		this.gameloop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame keyframe = new KeyFrame(Duration.seconds(0.017), (ev ->{
			
				System.out.println("un tour");
				env.unTour();
			time++;
		})
		);
		gameloop.getKeyFrames().add(keyframe);

	}	
}
