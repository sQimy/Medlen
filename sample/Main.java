package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage Stage) throws Exception{
        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/20610.ttf"), 14);
        Parent root = FXMLLoader.load(getClass().getResource("General.fxml"));
        Stage.setTitle("Bank System");
        Stage.setScene(new Scene(root, 906, 591));
        Stage.setResizable(false);
        Stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
