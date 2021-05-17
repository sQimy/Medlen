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
        stage.setTitle("Bank System");
        stage.setScene(new Scene(root,906,591));
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void Vhod(ActionEvent event) throws IOException {
        String login = SignInLogin.getText();
        String password = SignInPassword.getText();
        int checklog = ScriptsSQL.uznatUsername(login);
        if (checklog==1) {
            String checkpas = ScriptsSQL.uznatPassword(login);
            System.out.println("Проверка логина " + checklog);
            System.out.println("Пароль " + checkpas + " от логина " + login);
            if (password.equals(checkpas)) {

                Stage stage = (Stage) SignInBtn.getScene().getWindow();
                stage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("General.fxml"));
                Parent root = (Parent) loader.load();
                stage = new Stage();
                stage.setTitle("Bank System");
                stage.setScene(new Scene(root,906,591));
                stage.setResizable(false);
                stage.show();

            } else
                    System.out.println("Неверный пароль");
        } else System.out.println("Такого логина не существует");
    }


    @FXML
    void initialize() {

    }
}
