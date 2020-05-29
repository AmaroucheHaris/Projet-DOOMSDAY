package application.controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
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
	private ChargementMap mapAGenener;

	@FXML
	private ImageView imageMilitaire;
	@FXML
	private ImageView target;

	private boolean modeEdit;
	private String tourelle;
	private HashMap<Zombie, SpriteZombie> linkSpriteZombie;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		linkSpriteZombie = new HashMap<Zombie, SpriteZombie>();
		modeEdit = false;
		tourelle = "";
	
		mapAGenener = new ChargementMap();

		mapAGenener.genererMap(Tpane);
		// env.initSommets();

		this.env = new Environnement(960, 704);

		try {
			creerZombieAleatoire();
			creerZombieAleatoire();
			creerZombieAleatoire();
			creerZombieAleatoire();
			creerZombieAleatoire();
			creerZombieAleatoire();
			creerZombieAleatoire();
			creerZombieAleatoire();
			creerZombieAleatoire();
			creerZombieAleatoire();
			creerZombieAleatoire();
			creerZombieAleatoire();
			creerZombieAleatoire();

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

		KeyFrame keyframe = new KeyFrame(Duration.seconds(0.017), (ev -> {

			env.unTour();
			tuerZombiesMorts();
			time++;
		}));
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
				System.out.println("Aucune tourelle s�lectionn�e");
			}

			else {
				if (tourelle.equals("militaire")) {
					int posX = (int) event.getSceneX();
					int posY = (int) event.getSceneY();
//					SpriteTourelle spt;
//
//					try {
//						spt = new SpriteTourelle(new Militaire(posX, posY, env, 10, 10, 10, 100), env);
//						spt.creerSpriteTourelle(paneCentrale);
//					} catch (FileNotFoundException e) {
//						e.printStackTrace();
//					}
//				}
					Tourelle tour = new TireurDeBase(posX, posY, env, 10, 10, 10, 30);
					SpriteTourelle spt;

					try {
						spt = new SpriteTourelle(tour, env, posX, posY);
						spt.creerSpriteTourelle(paneCentrale, spt);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void creerZombieAleatoire() throws FileNotFoundException {
		// 7 zombies
		
		SpriteZombie sp;
		Random rand = new Random();
		// mettre à l'interieur de rand.nextInt() le nombre de type de zombie
		int valRand = rand.nextInt(1);
		
		Zombie z;
		switch(valRand) {
		case 0:
			z = new Sprinteur(env);
			sp = new SpriteZombie(z);
			sp.ajouterSpriteZombie(paneCentrale);
			linkSpriteZombie.put(z, sp);
		}
	}
	
	public void tuerZombie(Zombie target) {
		if (!target.estEnVie()) {
			target.suprimerZombie();
			SpriteZombie sz = linkSpriteZombie.get(target);
			sz.suprimerSpriteZombie(paneCentrale);
		}
	}
	
	public void tuerZombiesMorts(){
		ArrayList<Zombie> listeZombies = this.env.getListeZombies();
		for (Zombie zombie : listeZombies) {
			if (!zombie.estEnVie()) {
				this.tuerZombie(zombie);
			}
		}	
	}
}
