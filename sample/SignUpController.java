package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SignUpReg;

    @FXML
    private TextField SignUpPassword;

    @FXML
    private TextField SignUpLogin;

    @FXML
    private TextField SignUpName;

    @FXML
    private TextField SignUpLastName;

    @FXML
    private TextField SignUpTele;

    @FXML
    private TextField SignUpAdress;

    @FXML
    void initialize() {
        assert SignUpReg != null : "fx:id=\"SignUpReg\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert SignUpPassword != null : "fx:id=\"SignUpPassword\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert SignUpLogin != null : "fx:id=\"SignUpLogin\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert SignUpName != null : "fx:id=\"SignUpName\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert SignUpLastName != null : "fx:id=\"SignUpLastName\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert SignUpTele != null : "fx:id=\"SignUpTele\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert SignUpAdress != null : "fx:id=\"SignUpAdress\" was not injected: check your FXML file 'SignUp.fxml'.";

    }
}
