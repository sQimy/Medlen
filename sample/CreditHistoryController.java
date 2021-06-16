package sample;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

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

    private ObservableList<Drop_Form> list = FXCollections.observableArrayList();

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

        int count = Connect.poluchit();
        System.out.println("Получил кол-во строк "+count);
        Object[] list = Connect.PackList();
        User1 usered = new User1();
        for(int i=0;i<count*4;i+=4){
            int f1 = (Integer) list[i];
            int f2 = (Integer) list[i+1];
            String f3 = (String) list[i+2];
            String f4 = (String) list [i+3];
            usersData.add(new User1(f1,f2,f3,f4));
        }


        Cost.setCellValueFactory(new PropertyValueFactory<User1, Integer>("id"));
        Total.setCellValueFactory(new PropertyValueFactory<User1, Integer>("login"));
        idStatus.setCellValueFactory(new PropertyValueFactory<User1, String>("password"));
        TypeCredit.setCellValueFactory(new PropertyValueFactory<User1, String>("email"));

        NashaTable.setItems(usersData);

    }
}

