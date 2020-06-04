package application.controleur;

import java.io.FileNotFoundException;


import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;
import application.modele.Environnement;
import application.modele.TabMap1;
import application.modele.bfs.Coordonnes;
import application.modele.ennemis.Blesses;
import application.modele.ennemis.Kamikaze;
import application.modele.ennemis.Majin;
import application.modele.ennemis.Sprinteur;
import application.modele.ennemis.Tank;
import application.modele.ennemis.Zombie;
import application.modele.ennemis.ZombieDeTroie;
import application.modele.ennemis.ZombieMilitaire;
import application.modele.tourelles.PlacementTourelle;
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
	private int cycle;
	private int cycleSpawnZombie;

	@FXML
	private ImageView imageMilitaire;
	
	@FXML
	private ImageView imageTireurPrecision;

	@FXML
	private ImageView imageBourrin;

	@FXML
	private ImageView imageGrenadier;

	@FXML
	private ImageView imageRadar;
    
	@FXML
	private ImageView target;

	private boolean modeEdit;
	private String tourelle;
	private HashMap<Zombie, SpriteZombie> linkSpriteZombie;
	private ArrayList<PlacementTourelle> listePlacementsTourelles;
	TabMap1 map1 = new TabMap1();
	int[][] matriceMap1 = map1.getTab();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		linkSpriteZombie = new HashMap<Zombie, SpriteZombie>();
		listePlacementsTourelles = new ArrayList<PlacementTourelle>();
		modeEdit = false;
		tourelle = "";
		this.cycle = 400;
		this.cycleSpawnZombie = 0;
		mapAGenener = new ChargementMap();

		mapAGenener.genererMap(Tpane);
		// env.initSommets();

		this.env = new Environnement(960, 704);

		for(int ligne = 0; ligne<matriceMap1.length; ligne++) {
			for(int colonne = 0; colonne < matriceMap1[ligne].length; colonne++) {
				if (matriceMap1[ligne][colonne] == 4) {
					Coordonnes c = new Coordonnes(colonne, ligne);
					PlacementTourelle pt = new PlacementTourelle(c, matriceMap1);
					listePlacementsTourelles.add(pt);
				}
			}
		}
		
		for (int i = 0; i < listePlacementsTourelles.size(); i++) {
			System.out.println("X : " + listePlacementsTourelles.get(i).getTileX());
			System.out.println("X : " + listePlacementsTourelles.get(i).getTileY());
		}
		
		
//		try {
//			creerZombieAleatoire();
//			creerZombieAleatoire();
//			creerZombieAleatoire();
//			creerZombieAleatoire();
//		
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			creerZombieAleatoire();
//			creerZombieAleatoire();
//
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}

		creerPlacementTourelle(10, 0);

		animation();
		gameloop.play();

	}

	private void animation() {
		this.gameloop = new Timeline();
		this.time = 0;
		this.gameloop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame keyframe = new KeyFrame(Duration.seconds(0.017), (ev -> {

			if(this.cycle == 0) {
				if(this.cycleSpawnZombie == 0) {
					try {
						creerZombieAleatoire();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					this.cycleSpawnZombie = 250;
				}
				else {
					this.cycleSpawnZombie--;
				}
			}
			else {
				this.cycle--;
			}
			env.unTour();
			try {
				tuerZombiesMorts();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
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
			tourelle = "TireurDeBase";
		}
	}
	
	   @FXML
	    void onMouseClickedBourrin(MouseEvent event) {
		   if (modeEdit) {
				tourelle = "Bourrin";
			}
	    }

	    @FXML
	    void onMouseClickedGrenadier(MouseEvent event) {
	    	if (modeEdit) {
				tourelle = "Grenadier";
			}
	    }

	    @FXML
	    void onMouseClickedRadar(MouseEvent event) {
	    	if (modeEdit) {
				tourelle = "Radar";
			}
	    }

	    @FXML
	    void onMouseClickedTireurPrecision(MouseEvent event) {
	    	if (modeEdit) {
				tourelle = "TireurDePrecision";
			}
	    }

	@FXML
	void onMouseClickedPane(MouseEvent event) {
		if (modeEdit) {
			if (tourelle.equals("")) {
				System.out.println("Aucune tourelle sélectionnée");
			}
			else {
				int posX = (int) event.getSceneX();
				int posY = (int) event.getSceneY();
				Coordonnes c = new Coordonnes(posX, posY);
				for (PlacementTourelle pt : listePlacementsTourelles) {
					if (this.getEtatPlacementTourelle(c) && posX/32 == pt.getTileX() && posY/32 == pt.getTileY()) {
						if (tourelle.equals("TireurDeBase")) {
							this.creerTourelle("TireurDeBase", pt.getTileX()*32, pt.getTileY()*32);
							pt.setIsAvailable(false);
						}
					
					
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
		int valRand = rand.nextInt(7);
		
		Zombie z = null;
		switch(valRand) {
		case 0:
			z = new Sprinteur(env);
		break;
		
		case 1:
			z = new Blesses(env);
		break;
		
		case 2:
			z = new Kamikaze(env);
		break;
		
		case 3:
			z = new Majin(env);
		break;
		
		case 4:
			z = new Tank(env);
		break;
		
		case 5:
			z = new ZombieDeTroie(env);
		break;
		
		case 6:
			z = new ZombieMilitaire(env);
		break;
		}
		
		sp = new SpriteZombie(z);
		sp.ajouterSpriteZombie(paneCentrale);
		linkSpriteZombie.put(z, sp);
	}

//	public void creerZombie(String type, int start) throws FileNotFoundException {
//		// 7 zombies
//		
//		SpriteZombie sp;
//		Zombie z = null;
//		
//		switch(type) {
//		case "Sprinteur":
//			z = new Sprinteur(env);
//		}
//		sp = new SpriteZombie(z);
//		sp.ajouterSpriteZombie(paneCentrale);
//		linkSpriteZombie.put(z, sp);
//	}
	
	public void tuerZombie(Zombie target) throws FileNotFoundException {
		if (!target.estEnVie()) {
			// if target instanceof Zombie de troies ----> creerZombieAléatoire;
			if(target instanceof ZombieDeTroie) {
				for(int i = 0; i < 3; i++) {
					creerZombieAleatoire();
				}
			}
			target.suprimerZombie();
			SpriteZombie sz = linkSpriteZombie.get(target);
			sz.suprimerSpriteZombie(paneCentrale);
		}
	}
	
	public void tuerZombiesMorts() throws FileNotFoundException{
		ArrayList<Zombie> listeZombies = this.env.getListeZombies();
		for (int i = 0; i < listeZombies.size(); i++) {
			if (!listeZombies.get(i).estEnVie()) {
				this.tuerZombie(listeZombies.get(i));
			}
		}	
	}
	
	public ArrayList<PlacementTourelle> getAllPlacementsTourelles(){
		return this.listePlacementsTourelles;
	}
	
	public void addPlacementTourelle(PlacementTourelle pt) {
		if (!this.listePlacementsTourelles.contains(pt)) {
			this.listePlacementsTourelles.add(pt);
		}
	}
	
	public void removePlacementTourelle(PlacementTourelle pt) {
		if (this.listePlacementsTourelles.contains(pt)) {
			this.listePlacementsTourelles.remove(pt);
		}
	}
	
	public boolean getEtatPlacementTourelle(Coordonnes c){
		for (PlacementTourelle placementTourelle : this.listePlacementsTourelles) {
			if (placementTourelle.getTileX() == c.getX()/32 && placementTourelle.getTileY() == c.getY()/32) {
				return placementTourelle.getIsAvailable();
			}
		}
		return false;
	}
	
	public void creerPlacementTourelle(int x, int y){
		Coordonnes c1 = new Coordonnes(x*32,y*32);
		PlacementTourelle pt = new PlacementTourelle(c1, matriceMap1);
		if (matriceMap1[pt.getTileY()][pt.getTileX()] == 1) {
			this.addPlacementTourelle(pt);
			System.out.println("Endroit crée avec succès");
		}
		else {
			System.out.println("Erreur : Mauvais endroit");
		}
	}
	
	
	public void creerTourelle(String type, int posX, int posY) {
		switch (type) {
		case "TireurDeBase":
			Tourelle tour = new TireurDeBase(posX+8, posY, env, 10, 10, 10, 300);
			SpriteTourelle spt;
			try {
				spt = new SpriteTourelle(tour, env, posX+8, posY);
				spt.creerSpriteTourelle(paneCentrale, spt);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
		
		
		
	}
}
