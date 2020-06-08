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

public class ControlerGameOverMenu implements Initializable {
	
	@FXML
	Button menuPrincipalButton;
	
	@FXML
	private AnchorPane aPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
	public void chargerMenuPrincipal(ActionEvent event) throws IOException {
		Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/vue/menuPrincipal.fxml"));
		aPane.getChildren().setAll(root);
	}

}
