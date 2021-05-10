package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SignInReg;

    @FXML
    private Button SignInBtn;

    @FXML
    private TextField SignInPassword;

    @FXML
    private TextField SignInLogin;

    @FXML
    void Reg(ActionEvent event) throws IOException {

        Stage stage = (Stage) SignInReg.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Bank System");
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    void Vhod(ActionEvent event) {

    }


    @FXML
    void initialize() {

    }
}
