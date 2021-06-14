package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class crediteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Slider slide1;
    int myRub;

    @FXML
    private TextField mytextField;

    @FXML
    private Button credit_btn;

    @FXML
    private Button back;

    @FXML
    private Slider slide2;
    int age;

    @FXML
    private TextField mytextField1;

    @FXML
    private TextField mytextField2;

    @FXML
    private TextField mytextField_age;

    @FXML
    void Back(ActionEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("General.fxml"));
        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.setTitle("Bank System");
        stage.setScene(new Scene(root,906,540));
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void Get(ActionEvent event) throws IOException {
    }


    @FXML
    public void handlekeyPressed(KeyEvent KE) {
        if (KE.getCode() == KeyCode.ENTER){
            myRub=Integer.parseInt(mytextField.getText());
            slide1.setValue(myRub);
            mytextField.end();
        }
    }
    @FXML
    public void handlekeyPressed2(KeyEvent KE) {
        if (KE.getCode() == KeyCode.ENTER){
            age=Integer.parseInt(mytextField_age.getText());
            slide2.setValue(age);
            mytextField_age.end();
        }
    }

    @FXML
    void initialize() {


        slide1.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int c=9;
                myRub= (int) slide1.getValue();
                mytextField.setText(Integer.toString(myRub));
                if (age == 0){
                    mytextField1.setText(Integer.toString(0));
                }
                else {
                    mytextField1.setText(Integer.toString((int) (myRub+((myRub/100)*(c*age)))/(12*age)));
                }
            }
        });

        slide2.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                int c=9;
                age= (int) slide2.getValue();
                mytextField_age.setText(Integer.toString(age));
                if (age == 0){
                    mytextField1.setText(Integer.toString(0));
                }
                else {
                    mytextField1.setText(Integer.toString((int) (myRub+((myRub/100)*(c*age)))/(12*age)));
                }


            }
        });


    }
}
