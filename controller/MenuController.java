package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class MenuController implements Initializable {
    ObservableList<Integer> numberOfPlayers = FXCollections.observableArrayList(2, 3);

    @FXML
    private ChoiceBox choice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choice.setItems(numberOfPlayers);
        choice.setValue(numberOfPlayers.get(0));
    }

    @FXML
    public void onClickStart(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // set scene to the game scene
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/GameLayout.fxml"))));
            System.out.println(choice.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
