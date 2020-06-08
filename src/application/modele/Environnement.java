package application.modele;

import java.util.ArrayList;


import application.modele.bfs.Graphe;
import application.modele.ennemis.Sprinteur;
import application.modele.ennemis.Zombie;
import application.modele.tourelles.Tourelle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Environnement {
	
	private int width,height;
	//private int nbTours;
	
	private boolean mancheEnCours;
	
	private ArrayList<Zombie> listeZombie;
	private ArrayList<Tourelle> listeTourelle;
	//private ArrayList<Coordonnes> listeCoordonnes;
	private Graphe graphe;
	private TabMap1 tab;
	private IntegerProperty money;
	
	public Environnement(int width, int height) {
		this.width = width;
		this.height = height;
		this.tab = new TabMap1();
		this.mancheEnCours = false;
		listeZombie = new ArrayList<Zombie>();
	//	listeTourelle = new ArrayList<Tourelle>();
		listeTourelle = new ArrayList<Tourelle>();
		this.money = new SimpleIntegerProperty(100);
		//this.nbTours = 0;
		//this.listeCoordonnes = new ArrayList<Coordonnes>();
		System.out.println("construction graphe");
		this.graphe = new Graphe(tab.getTab());
		System.out.println("graphe" + this.graphe);
//		graphe.initSommets(this.tab.getTab());
//		graphe.bfs();
//		graphe.afficher();
				
	}
	
	public void unTour() {
		this.mancheEnCours = true;
		for(Zombie currentZombie : this.listeZombie) {
			//Coordonnes test = this.graphe.plusProcheCoord(currentZombie);
			//System.out.println("x= " + test.getX() + "    " +"y = " + test.getY());
			System.out.println(currentZombie);
			currentZombie.agit();
			
//			Coordonnes test = plusProcheCoord(currentZombie);
//			System.out.println("x= " + test.getX() + "    " +"y = " + test.getY());
//			currentZombie.agit(test);
		}
		
		
//		for(Tourelle currentTourelle : this.listeTourelle) {
//			currentTourelle.agit();
//		}
		for(Tourelle currentTourelle : this.listeTourelle) {
			currentTourelle.agir();
		}
		this.mancheEnCours = false;
	}
	
//	public void initZombie() {
//		for(Zombie z : this.listeZombie) {
//			z.setSommetsDest(this.graphe.plusProcheCoord(z));
//		}
//	}
	public boolean getMancheEnCours() {
		return this.mancheEnCours;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public ArrayList<Zombie> getListeZombies(){
		return this.listeZombie;
	}
	
	public void deleteZombie(Zombie target) {
		this.listeZombie.remove(target);
	}
	
	

	public ArrayList<Tourelle> getListeTourelles(){
		return this.listeTourelle;
	}
	
	
	
//	public Coordonnes plusProcheCoord(Zombie zombie) {
//		boolean test = false;
//		if(zombie.getCoordonnesDest() != null) {
//			return zombie.getCoordonnesDest();
//		}
//		double distance = 1000;
//		Coordonnes coordMinimal = new Coordonnes(0, 0);
//		//System.out.println(listeCoordonnes.size());
//		for(Coordonnes coord : this.listeCoordonnes) {
//			if(zombie.distance(coord) != 0) {
//				if(distance > zombie.distance(coord)) {
//				distance = zombie.distance(coord);
//				coordMinimal.setX(coord.getX());
//				coordMinimal.setY(coord.getY());
//
//				}
//			}
//		}
//		//zombie.setCoordonneesDest(coordMinimal);
//		return coordMinimal;
//	}
	
	public Graphe getGraphe() {
		return this.graphe;
	}
	
	public IntegerProperty getMoneyProperty() {
		return money;
	}
	
	public int getMoney() {
		return this.money.getValue();
	}
	
	public void setMoney(int money) {
		this.money.setValue(money);
	}
	
	public void updateMoneyUp(Zombie zombie) {
//		int money = Integer.parseInt(this.labelMoney.getText());
//		if(zombie instanceof Sprinteur) {
//			labelMoney.setText(String.valueOf(money + 10));
//		}
		
		if(zombie instanceof Sprinteur) {
			 this.setMoney((this.getMoney() + 10));
		}
	}
	
	public boolean checkMoneyDown(Tourelle tourelle) {
//		int money = Integer.parseInt(this.labelMoney.getText());
//		if(money - tourelle.getValeurAchat() < 0) {
//			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//			return true;
//		}
//		System.out.println("zajhbfiefneoiajfoaj^fpâzejifà");
//		return false;
		
		if(this.getMoney() - tourelle.getValeurAchat() < 0) {
			return true;
		}
		return false;
	}
	
	public void moneyAsc(Tourelle tourelle) {
			this.setMoney((this.getMoney() + (tourelle.getValeurAchat()/2)));
	}
	
	public void moneyDesc(Tourelle tourelle) {
			this.setMoney((this.getMoney() - tourelle.getValeurAchat()));
	}
	
	
}
