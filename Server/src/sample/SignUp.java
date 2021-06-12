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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.sql.*;

public class SignUp {

    public static void Registration(String usernameS, String passwordS, String last_name, String first_name, String telephone, String addres) throws IOException {

            int ID = ScriptsSQL.uznatID();
            ScriptsSQL.SignUp( ID+1,last_name, first_name, telephone, addres, 0, usernameS, passwordS);


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


}
