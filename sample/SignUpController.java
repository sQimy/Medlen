package sample;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.sql.*;

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
    private Text ErrorName;

    @FXML
    private Text ErrorLastname;

    @FXML
    private Text ErrorAddres;

    @FXML
    private Text ErrorTelephone;

    @FXML
    private Text ErrorLogin;

    @FXML
    private Text ErrorPassword;

    @FXML
    private Text ErrorFakeLogin;

    @FXML
    void RegistrationBtn(ActionEvent event) {
        String usernameS = SignUpLogin.getText();
        String passwordS = SignUpPassword.getText();
        String last_name = SignUpLastName.getText();
        String first_name = SignUpName.getText();
        String telephone = SignUpTele.getText();
        String addres = SignUpAdress.getText();
        int count = 0;
        boolean check = isInteger(telephone,count);
        int checkUser=ScriptsSQL.uznatUsername(usernameS);
        if((usernameS != "" && passwordS != "" && last_name != "" && first_name != "" && telephone != "" && addres != "")
                && (usernameS.length()<=20 && passwordS.length()<=20 && last_name.length()<=30 && first_name.length()<=20 && addres.length()<=45 &&
                telephone.length() == 10) && check == true && checkUser == 0)
        {
            int ID = ScriptsSQL.uznatID();
            ScriptsSQL.SignUp(ID + 1, last_name, first_name, telephone, addres, 0, usernameS, passwordS);
            FXMLLoader loaderSignUp = new FXMLLoader();
            loaderSignUp.setLocation(getClass().getResource("/sample/SignIn.fxml"));
            try {
                loaderSignUp.load();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Я не запустил новое окно после регистрации");
            }
            Parent root = loaderSignUp.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } else {
            if (usernameS == "" || usernameS.length()>20){
                ErrorLogin.setOpacity(1);
            }
            if (checkUser == 1){
                ErrorFakeLogin.setOpacity(1);
            }
            if (passwordS == "" || passwordS.length()>20){
                ErrorPassword.setOpacity(1);
            }
            if (last_name == "" || last_name.length()>30){
                ErrorLastname.setOpacity(1);
            }
            if (addres == "" || addres.length()>45){
                ErrorAddres.setOpacity(1);
            }
            if (telephone == "" || telephone.length() !=10 || check == false){
                ErrorTelephone.setOpacity(1);
            }
            if (first_name == "" || first_name.length()>20){
                ErrorName.setOpacity(1);
            }
            System.out.println("Не все поля заполнены ");
        }


    }
    public static boolean isInteger(String str, int f) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                f+=1;
            }
        }
        if (f==str.length()){
            return true;
        }  else {
            return false;
        }
    }

    @FXML
    void initialize() {
        assert SignUpReg != null : "fx:id=\"SignUpReg\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert SignUpPassword != null : "fx:id=\"SignUpPassword\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert SignUpLogin != null : "fx:id=\"SignUpLogin\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert SignUpName != null : "fx:id=\"SignUpName\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert SignUpLastName != null : "fx:id=\"SignUpLastName\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert SignUpTele != null : "fx:id=\"SignUpTele\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert SignUpAdress != null : "fx:id=\"SignUpAdress\" was not injected: check your FXML file 'SignUp.fxml'.";
        /*SignUpReg.setOnAction(actionEvent ->
                {
                    SignUpReg.getScene().getWindow().hide();

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("SignIn.fxml"));

                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                });*/
    }


}
