package application.controleur;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class ControlerMainMenu implements Initializable {

	@FXML
    private Button lancerJeu;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button regles;
    
    protected Media musiqueDuJeu;
    protected static MediaPlayer mpMusiqueDuJeu;

    @FXML
    void commencerPartie(ActionEvent event) {
		Pane root = null;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("application/vue/vue1.fxml"));
		} catch (IOException e) {
			System.out.println("vue1.fxml est introuvable");
			e.printStackTrace();
		}
		rootPane.getChildren().setAll(root);
    }

    @FXML
    void afficherRegles(ActionEvent event){
    	Pane root = null;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("application/vue/regles.fxml"));
		} catch (IOException e) {
			System.out.println("regles.fxml est introuvable");
			e.printStackTrace();
		}
    	rootPane.getChildren().setAll(root);

    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rootPane.setStyle("-fx-background-image: none");
		rootPane.setStyle("-fx-background-color: #202020");
		this.creerMpMusiqueDuJeu();
		this.mpMusiqueDuJeu.setAutoPlay(true);
		
	}
	
	public void creerMpMusiqueDuJeu() {
		this.musiqueDuJeu = new Media(new File("src/application/vue/ressources/sounds/in-the-house-in-the-heartbeat.mp3").toURI().toString());
		this.mpMusiqueDuJeu = new MediaPlayer(musiqueDuJeu);
	}

}
