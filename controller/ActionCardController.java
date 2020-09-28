package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Action;
import model.ActionCard;

import java.net.URL;
import java.util.ResourceBundle;


public class ActionCardController implements Initializable {
    Action act;
    @FXML
    Label nameLabel;

    /**
     * instantiates the controller
     * @param action Action card
     */
    public ActionCardController(Action action)
    {
        act=action;
    }

    /**
     * initiaizes the parts of the GUI
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nameLabel.setText(act.toString());
    }

    /**
     * sets what happens when continue button is clicked
     * @param ae is the action event
     */
    public void onClickContinue(ActionEvent ae)
    {
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }
}
