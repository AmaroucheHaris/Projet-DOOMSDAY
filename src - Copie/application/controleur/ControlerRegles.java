package application.controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControlerRegles implements Initializable{

	 @FXML
	    private Button retour;
	 
	 @FXML
	    private AnchorPane rootPane;
	 
	 @FXML
	    private TextArea areaRegles;


	    @FXML
	    void chargeMenuPrecedent(ActionEvent event) throws IOException {
			Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("application/vue/menuPrincipal.fxml"));
	    	rootPane.getChildren().setAll(root);

	    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
