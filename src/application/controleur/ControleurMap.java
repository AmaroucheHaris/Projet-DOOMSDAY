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
import application.modele.ennemis.Sprinteur;
import application.modele.ennemis.Zombie;
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

		CreerPlacementTourelle(10, 0);

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
	    void onMouseClickedBourrin(MouseEvent event) {
		   if (modeEdit) {
				tourelle = "bourrin";
			}
	    }

	    @FXML
	    void onMouseClickedGrenadier(MouseEvent event) {
	    	if (modeEdit) {
				tourelle = "grenadier";
			}
	    }

	    @FXML
	    void onMouseClickedRadar(MouseEvent event) {
	    	if (modeEdit) {
				tourelle = "radar";
			}
	    }

	    @FXML
	    void onMouseClickedTireurPrecision(MouseEvent event) {
	    	if (modeEdit) {
				tourelle = "tireur";
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
				for (PlacementTourelle placementTourelle : listePlacementsTourelles) {
					if (this.getEtatPlacementTourelle(c) && posX/32 == placementTourelle.getTileX() && posY/32 == placementTourelle.getTileY()) {
						if (tourelle.equals("militaire")) {
							Tourelle tour = new TireurDeBase(posX, posY, env, 10, 10, 10, 30);
							SpriteTourelle spt;
							try {
								spt = new SpriteTourelle(tour, env, placementTourelle.getTileX()*32, placementTourelle.getTileY()*32);
								spt.creerSpriteTourelle(paneCentrale, spt);
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
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
		int valRand = rand.nextInt(1);
		
		Zombie z = null;
		switch(valRand) {
		case 0:
			z = new Sprinteur(env);
			
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
	
	public void tuerZombie(Zombie target) {
		if (!target.estEnVie()) {
			target.suprimerZombie();
			SpriteZombie sz = linkSpriteZombie.get(target);
			sz.suprimerSpriteZombie(paneCentrale);
		}
	}
	
	public void tuerZombiesMorts(){
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
	
	public void CreerPlacementTourelle(int x, int y){
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
}
