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
import javafx.stage.Stage;

public class CreditHistoryController {

    @FXML
    private Button back;

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
    void initialize() {
    }
}

