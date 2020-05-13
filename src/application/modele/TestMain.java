package application.modele;

public class TestMain {
	
	public static void main(String [] args) {
		ZombieMilitaire z1 = new ZombieMilitaire(2, 3);
		Sprinteur s1 = new Sprinteur(1, 2);
		Tank t1 = new Tank(0, 0);
		ZombieDeTroie zt1 = new ZombieDeTroie(1, 1);
		
		System.out.println(z1.toString());
		System.out.println(s1.toString());
		System.out.println(t1.toString());
		System.out.println(zt1.toString());
	}
}
