package application.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.modele.TabMap1;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class ChargementMap {
	
	private TabMap1 tab = new TabMap1();
	int [][] map = tab.getTab();
	
	public void genererMap(TilePane tPane) {
		Image i1 = null;
		Image i2 = null;
		Image i3 = null;
		
		
		try {
			 i1 = new Image(new FileInputStream("src/application/vue/ressources/tiles/sol.png"));
			 i2 = new Image(new FileInputStream("src/application/vue/ressources/tiles/route.png"));
			 i3 = new Image(new FileInputStream("src/application/vue/ressources/tiles/lave.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ImageView img = null;
		
		
		for(int ligne = 0; ligne<map.length; ligne++) {
			for(int colonne = 0; colonne < map[ligne].length; colonne++) {

				img = new ImageView();
				
				switch (map[ligne][colonne]) {
				
					case 1:
						img.setImage(i1);
						break;

					case 2: 
						img.setImage(i2);
						break;

					case 3: 
						img.setImage(i3);
						break;
				}

				tPane.getChildren().add(img);
			}
	}
}

	public int[][] getMap() {
		return map;
	}

}
