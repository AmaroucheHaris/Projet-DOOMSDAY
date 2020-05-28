package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;
import application.modele.Environnement;
import application.modele.ennemis.Sprinteur;
import application.modele.ennemis.Zombie;
import application.modele.tourelles.TireurDeBase;
import application.modele.tourelles.Tourelle;
import application.vue.ChargementMap;
import application.vue.SpriteTourelle;
import application.vue.SpriteZombie;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
	private ChargementMap mapAGenerer;	

    @FXML
    private ImageView imageMilitaire;
    @FXML
    private ImageView target;
	

    private boolean modeEdit;
    private String tourelle;
    private Tourelle tour;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		modeEdit = false;
		tourelle = "";
		mapAGenerer = new ChargementMap();
		
		mapAGenerer.genererMap(Tpane);
		//env.initSommets();
		
		this.env = new Environnement(960, 704, mapAGenerer);
			
			int posXz = 10;
			int posYz = 10;
			Zombie z = new Sprinteur(posXz, posYz);
			SpriteZombie sp;
			

			sp = new SpriteZombie(z, posXz, posYz);
			
			env.initZombie();
			sp.creerSpriteZombie(paneCentrale, z);

		
		
		animation();
		gameloop.play();

	}
	
	private void animation() {
		this.gameloop = new Timeline();
		this.time = 0;
		this.gameloop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame keyframe = new KeyFrame(Duration.seconds(0.017), (ev ->{
			
				env.unTour();
			time++;
		})
		);
		gameloop.getKeyFrames().add(keyframe);

	}
	
    @FXML
    void onMouseClickedOn(MouseEvent event) {
    	modeEdit = true;
    	
    }
	
    @FXML
    void onMouseClickedOff(MouseEvent event) {
    	tourelle = "";
    	modeEdit = false;
    	
    }	
	
    @FXML
    void onMouseClickedMilitaire(MouseEvent event) {
    	if (modeEdit) {
    		tourelle = "militaire";
		}
    }
    
    @FXML
    void onMouseClickedPane(MouseEvent event) {
	    if (modeEdit) {
	    	if (tourelle.equals("")) {
	    		System.out.println("Aucune tourelle sélectionnée");
	    	}
	    	
	    	else {
	    		if (tourelle.equals("militaire")) {
		    		int posX = (int) event.getSceneX();
				    int posY = (int) event.getSceneY();
				    this.tour = new TireurDeBase(posX, posY, env, 10, 10, 10, 300);
				    SpriteTourelle spt;

				    spt = new SpriteTourelle(tour, posX, posY);
					spt.creerSpriteTourelle(paneCentrale, spt);
				}

			}
	    		
		}
    } 
    
}
