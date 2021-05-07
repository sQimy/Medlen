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
import javafx.stage.Stage;

public class SignInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SingInReg;

    @FXML
    private Button SignInBtn;

    @FXML
    private TextField SignInPassword;

    @FXML
    private TextField SignInLogin;


    @FXML
    void initialize() {
     SingInReg.setOnAction(event ->
     {
         SingInReg.getScene().getWindow().hide();

         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("/sample/SignUp.fxml"));

         try {
             loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }

         Parent root = loader.getRoot();
         Stage stage = new Stage();
         stage.setScene(new Scene(root));
         stage.showAndWait();

     });

    }
}
