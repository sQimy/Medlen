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
import javafx.scene.input.MouseEvent;
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
    private Button SignIntest;

    @FXML
    private Button SignInBtn;

    @FXML
    private TextField SignInPassword;

    @FXML
    private TextField SignInLogin;

    @FXML
    void SignInLogClicked(MouseEvent event) {
        SignInLogin.setStyle("-fx-background-color: #3a3c4978;-fx-text-fill: #c7fcec;");
        SignInPassword.setStyle("-fx-background-color: #3a3c49;-fx-text-fill: #c7fcec;");
    }

    @FXML
    void SigInPassClick(MouseEvent event) {
        SignInPassword.setStyle("-fx-background-color: #3a3c4978; -fx-text-fill: #c7fcec;");
        SignInLogin.setStyle("-fx-background-color: #3a3c49;-fx-text-fill: #c7fcec;");
    }


    @FXML
    void Reg(ActionEvent event) throws IOException {

        Stage stage = (Stage) SignInReg.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.setTitle("Bank System");
        stage.setScene(new Scene(root, 906, 591));
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void Vhod(ActionEvent event) throws IOException {
        String login = SignInLogin.getText();
        String password = SignInPassword.getText();
        Connect.otpravit("2");
        Connect.otpravit(login);
        Connect.otpravit(password);
        int log = Connect.poluchit();
        String parol = Connect.poluchitStr();
        int checklogin = 1;
        if(checklogin == log ){
            if (password.equals(parol)) {

                Stage stage = (Stage) SignInBtn.getScene().getWindow();
                stage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("General.fxml"));
                Parent root = (Parent) loader.load();
                stage = new Stage();
                stage.setTitle("Bank System");
                stage.setScene(new Scene(root, 906, 591));
                stage.setResizable(false);
                stage.show();
            } else {System.out.println("Неверный пароль");}
        }else {System.out.println("Логин не существует");}
    }
}
