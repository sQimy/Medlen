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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import static sample.Connect.Pack;

public class SignUpController {

    @FXML
    void ColorChange(TextField Change)
    {
        SignUpPassword.setStyle("-fx-background-color: #3a3c49; -fx-text-fill: #c7fcec;");
        SignUpLogin.setStyle("-fx-background-color: #3a3c49; -fx-text-fill: #c7fcec;");
        SignUpName.setStyle("-fx-background-color: #3a3c49; -fx-text-fill: #c7fcec;");
        SignUpLastName.setStyle("-fx-background-color: #3a3c49; -fx-text-fill: #c7fcec;");
        SignUpTele.setStyle("-fx-background-color: #3a3c49; -fx-text-fill: #c7fcec;");
        SignUpAdress.setStyle("-fx-background-color: #3a3c49; -fx-text-fill: #c7fcec;");
        Change.setStyle("-fx-background-color: #3a3c4978; -fx-text-fill: #c7fcec;");
    }

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
    private Button BackBtn;

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) SignUpReg.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.setTitle("Bank System");
        stage.setScene(new Scene(root,532,363));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void SignUpAdresClicked(MouseEvent event) {
        ColorChange(SignUpAdress);

    }

    @FXML
    void SignUpLastNameClicked(MouseEvent event) {
        ColorChange(SignUpLastName);
    }

    @FXML
    void SignUpLoginClicked(MouseEvent event) {
        ColorChange(SignUpLogin);
    }

    @FXML
    void SignUpNameClicked(MouseEvent event) {
        ColorChange(SignUpName);
    }

    @FXML
    void SignUpPassClicked(MouseEvent event) {
        ColorChange(SignUpPassword);
    }

    @FXML
    void SignUpPhoneClicked(MouseEvent event) {
        ColorChange(SignUpTele);
    }



    @FXML
    void RegistrationBtn(ActionEvent event) throws IOException {
        SignUpName.setStyle("-fx-text-inner-color: red;");
            ErrorLogin.setOpacity(0);
            ErrorFakeLogin.setOpacity(0);
            ErrorPassword.setOpacity(0);
            ErrorLastname.setOpacity(0);
            ErrorAddres.setOpacity(0);
            ErrorTelephone.setOpacity(0);
            ErrorName.setOpacity(0);


            User NewUser = new User("1",SignUpName.getText(),SignUpLogin.getText(),SignUpPassword.getText(),SignUpLastName.getText(),SignUpName.getText(),SignUpTele.getText(),SignUpAdress.getText(),"0");

            Pack(NewUser);

            int count = 0;
            boolean check = isInteger(NewUser.Telephone(), count);
            int checkUser = Connect.poluchit();
            if ((NewUser.usernameS != "" && NewUser.passwordS != "" && NewUser.last_name != "" && NewUser.first_name != "" && NewUser.telephone != "" && NewUser.addres != "")
                    && (NewUser.usernameS.length() <= 20 && NewUser.passwordS().length() <= 20 && NewUser.last_name.length() <= 30 && NewUser.first_name.length() <= 20 && NewUser.addres.length() <= 45 &&
                    NewUser.telephone.length() == 10) && check == true && checkUser == 0)
            {
                Connect.otpravit("Go");
                Stage stage = (Stage) SignUpReg.getScene().getWindow();
                stage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
                Parent root = (Parent) loader.load();
                stage = new Stage();
                stage.setTitle("Bank System");
                stage.setScene(new Scene(root,532,363));
                stage.setResizable(false);
                stage.show();
            } else{
                Connect.otpravit("No");
                if (NewUser.usernameS == "" || NewUser.usernameS.length() > 20) {
                    ErrorLogin.setOpacity(1);
                }
                if (checkUser == 1) {
                    ErrorFakeLogin.setOpacity(1);
                }
                if (NewUser.passwordS == "" || NewUser.passwordS.length() > 20) {
                    ErrorPassword.setOpacity(1);
                }
                if (NewUser.last_name == "" || NewUser.last_name.length() > 30) {
                    ErrorLastname.setOpacity(1);
                }
                if (NewUser.addres == "" || NewUser.addres.length() > 45) {
                    ErrorAddres.setOpacity(1);
                }
                if (NewUser.telephone == "" || NewUser.telephone.length() != 10 || check == false) {
                    ErrorTelephone.setOpacity(1);
                }
                if (NewUser.first_name == "" || NewUser.first_name.length() > 20) {
                    ErrorName.setOpacity(1);
                }
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

    }


}
