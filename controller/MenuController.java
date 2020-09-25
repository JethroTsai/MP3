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
import model.GameResource;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuController implements Initializable {
    ObservableList<Integer> numberOfPlayers = FXCollections.observableArrayList(2, 3);

    @FXML
    private ChoiceBox choice;
    @FXML
    private ImageView image;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choice.setItems(numberOfPlayers);
        choice.setValue(numberOfPlayers.get(0));
    }

    @FXML
    public void onClickStart(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        GameResource gameResource = new GameResource((int) choice.getValue());

        // set scene to the game scene
        try {
            FXMLLoader gameLayoutLoader = new FXMLLoader(getClass().getResource("/view/GameLayout.fxml"));
//            GameLayoutController gameLayoutController = gameLayoutLoader.getController();
            stage.setScene(new Scene(gameLayoutLoader.load()));
            stage.setMaximized(true);
            ((GameLayoutController) gameLayoutLoader.getController()).setGameResource(gameResource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
