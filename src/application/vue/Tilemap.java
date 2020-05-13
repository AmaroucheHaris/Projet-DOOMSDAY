package application.vue;

public class Tilemap {
	private int [][] tab;
	
	public Tilemap(final int [][] tab) {
		this.tab = tab;
	}
	
	public int [][] getTab(){
		return this.tab;
	}
}
