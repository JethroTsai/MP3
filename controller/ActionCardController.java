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


    public ActionCardController(Action action)
    {
        act=action;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nameLabel.setText(act.toString());
    }

    public void onClickContinue(ActionEvent ae)
    {
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }
}
