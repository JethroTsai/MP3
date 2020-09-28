package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class ActionChoiceController implements Initializable {

    @FXML
    private ComboBox comboBox;
    @FXML
    private Button cont;
    @FXML
    private Label nameLabel;
    Player other1,other2,chosen;
    String name;

    /**
     * instantiates the controller
     * @param p1 is the first other player
     * @param p2 is the second other player
     * @param name is the name of the card
     */
    public ActionChoiceController(Player p1, Player p2,String name)
    {
        other1=p1;
        other2=p2;
        this.name=name;
    }

    /**
     * initializes the parts for the GUI
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nameLabel.setText(name);
        cont.setDisable(true);
        comboBox.getItems().add(other1.getName());
        comboBox.getItems().add(other2.getName());

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
    public void onClickContinue(ActionEvent ae)
    {
        if(comboBox.getSelectionModel().getSelectedItem().equals(other1.getName()))
            chosen=other1;
        else
            chosen=other2;

        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

    public Player getChosen()
    {
        return chosen;
    }

}

