package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CreditHistoryController {

    private ObservableList<User1> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<User1> NashaTable;

    @FXML
    private TableColumn<User1, String> TypeCredit;

    @FXML
    private TableColumn<User1, Integer> Cost;

    @FXML
    private TableColumn<User1, Integer> Total;

    @FXML
    private TableColumn<User1, String> idStatus;

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
    void initialize() throws IOException, ClassNotFoundException {
        Drop_Form user = Connect.PackDrop();
        System.out.println("Сумма "+user.Cost());
        //usersData.add(new Drop_Form(user.cost,user.total,user.type, user.status));
        User1 usered = new User1();
        usersData.add(new User1( user.Total(),user.Cost(), user.Type(),user.Status()));

        Cost.setCellValueFactory(new PropertyValueFactory<User1, Integer>("id"));
        Total.setCellValueFactory(new PropertyValueFactory<User1, Integer>("login"));
        TypeCredit.setCellValueFactory(new PropertyValueFactory<User1, String>("password"));
        idStatus.setCellValueFactory(new PropertyValueFactory<User1, String>("email"));

        NashaTable.setItems(usersData);
    }
}

