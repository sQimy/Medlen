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
    private Button SettingsBtn;

    @FXML
    private Button supbtn;

    @FXML
    private Button CredHistoryBtn;

    @FXML
    private Button InsuranceBtn;

    @FXML
    void CredHistoryAction(ActionEvent event) {

    }

    @FXML
    void SettingsAction(ActionEvent event) {

    }

    @FXML
    void TakeCreditAction(ActionEvent event) {

    }

    @FXML
    void TakeInsurance(ActionEvent event) {

    }

    @FXML
    void sup(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert SettingsBtn != null : "fx:id=\"SettingsBtn\" was not injected: check your FXML file 'General.fxml'.";
        assert supbtn != null : "fx:id=\"supbtn\" was not injected: check your FXML file 'General.fxml'.";
        assert CredHistoryBtn != null : "fx:id=\"CredHistoryBtn\" was not injected: check your FXML file 'General.fxml'.";
        assert InsuranceBtn != null : "fx:id=\"InsuranceBtn\" was not injected: check your FXML file 'General.fxml'.";

    }
}
