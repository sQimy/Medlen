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


}
