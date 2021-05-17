package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GeneralController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button settingsbtn;

    @FXML
    private Button supbtn;

    @FXML
    void setting(ActionEvent event) {

    }

    @FXML
    void sup(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert settingsbtn != null : "fx:id=\"settingsbtn\" was not injected: check your FXML file 'General.fxml'.";
        assert supbtn != null : "fx:id=\"supbtn\" was not injected: check your FXML file 'General.fxml'.";

    }
}
