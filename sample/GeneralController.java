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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class GeneralController {

    @FXML
    private StackPane ParentContainer;

    @FXML
    private AnchorPane container;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;



    @FXML
    private Button supbtn;

    @FXML
    private Button take_credit;

    @FXML
    private Button take_credit1;

    @FXML
    private Button credit_history;

    @FXML
    private Button take_mortgage;

    @FXML
    private Button take_contribution;





    @FXML
    void Credit(ActionEvent event) throws IOException {   //кнопка взять кредит
        Stage stage = (Stage) take_credit.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("credite.fxml"));
        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.setTitle("Bank System");
        stage.setScene(new Scene(root,728,546));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void Credit1(ActionEvent event) throws IOException { //кнопка взять кредит
        Stage stage = (Stage) take_credit1.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("credite.fxml"));
        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.setTitle("Bank System");
        stage.setScene(new Scene(root,728,546));
        stage.setResizable(false);
        stage.show();
    }


    @FXML
    void Mortgage(ActionEvent event) throws IOException{
        Stage stage = (Stage) take_mortgage.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mortgage.fxml"));
        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.setTitle("Bank System");
        stage.setScene(new Scene(root,728,546));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void Contribution(ActionEvent event) throws IOException{
        Stage stage = (Stage) take_contribution.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("contribution.fxml"));
        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.setTitle("Bank System");
        stage.setScene(new Scene(root,728,546));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void CredHist(ActionEvent event) throws IOException{
        Connect.otpravit("2");
        Stage stage = (Stage) credit_history.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("credit_history.fxml"));
        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.setTitle("Bank System");
        stage.setScene(new Scene(root,728,539));
        stage.setResizable(false);
        stage.show();
    }



    @FXML
    void initialize() {


    }
}
