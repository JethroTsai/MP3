package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Card;
import model.House;

import java.net.URL;
import java.util.ResourceBundle;

public class ChooseHouseCardController implements Initializable {
    @FXML
    private ComboBox comboBox;
    @FXML
    private Button cont;

    private House[] houses;
    private House chosenHouse;

    /**
     * instantiates the controller
     * @param houses array of houses
     */
    public ChooseHouseCardController(House[] houses) {
        this.houses = houses;
    }
    /**
     * initializes the parts for the GUI
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cont.setDisable(true);
        for(House house : houses) comboBox.getItems().add(house.toString());

        comboBox.setOnAction(e->{
            if(comboBox.getValue()==null)
                cont.setDisable(true);

            else
                cont.setDisable(false);
        });
    }
    /**
     * sets what happens when continue button is clicked
     * @param ae is the action event
     */
    @FXML
    public void onClickContinue(ActionEvent ae) {
        chosenHouse = houses[comboBox.getSelectionModel().getSelectedIndex()];
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

    public Card getChosenHouse() {
        return chosenHouse;
    }
}
