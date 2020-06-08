package application.controleur;

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
import javafx.stage.Stage;

public class ControlerMainMenu implements Initializable {

	@FXML
    private Button lancerJeu;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button regles;

    @FXML
    void commencerPartie(ActionEvent event) throws IOException {
		Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/vue/vue1.fxml"));
		rootPane.getChildren().setAll(root);
    }

    @FXML
    void afficherRegles(ActionEvent event) throws IOException {
    	Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/vue/regles.fxml"));
    	rootPane.getChildren().setAll(root);

    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
