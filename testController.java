package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class testController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_ok;

    @FXML
    private Slider slide1;
    int myRub;

    @FXML
    private TextField mytextField;

    @FXML
    void butn_action(ActionEvent event) {

    }

    @FXML
    private void initialize() {




        slide1.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                myRub= (int) slide1.getValue();
                mytextField.setText(Integer.toString(myRub));





            }
        });

    }

    public void handlekeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            myRub=Integer.parseInt(mytextField.getText());
            slide1.setValue(myRub);
            mytextField.end();
    }
}}
