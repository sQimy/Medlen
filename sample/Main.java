package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.Socket;

public class Main extends Application {


    @Override
    public void start(Stage Stage) throws Exception {
        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/20610.ttf"), 14);
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Stage.setTitle("Bank System");
        Stage.setScene(new Scene(root, 532, 363));
        Stage.setResizable(false);
        Stage.show();
        Connect.SocketConnect();
    }


    public static void main(String[] args) {
        launch(args);
    }


    @Override

    public void stop() throws IOException {
        Connect.SocketConnect().close();
        System.out.println("Пока");
    }
}