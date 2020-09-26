package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Card;
import model.House;

import java.net.URL;
import java.util.ResourceBundle;

public class ChooseHouseCardController implements Initializable {
    @FXML
    private ComboBox comboBox;

    private House[] houses;
    private House chosenHouse;

    public ChooseHouseCardController(House[] houses) {
        this.houses = houses;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(House house : houses) comboBox.getItems().add(house.toString());
    }

    @FXML
    public void onClickContinue(ActionEvent ae) {
        chosenHouse = houses[comboBox.getSelectionModel().getSelectedIndex()];
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

    public Card getChosenHouse() {
        return chosenHouse;
    }
}
