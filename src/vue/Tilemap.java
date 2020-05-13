package vue;

public class Tilemap {
	private int [][] tab;
	
	public Tilemap(int [][] tab) {
		this.tab = tab;
	}
	
	public int [][] getTab(){
		return this.tab;
	}
}
