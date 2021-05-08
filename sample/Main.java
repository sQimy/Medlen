package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/20610.ttf"), 14);
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        primaryStage.setTitle("Bank System");
        primaryStage.setScene(new Scene(root, 906, 591));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
