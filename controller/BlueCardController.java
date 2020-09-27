package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.BlueCard;
import java.net.URL;
import java.util.ResourceBundle;


public class BlueCardController implements Initializable
{
    @FXML
    Label nameLabel;
    private BlueCard blue;

    public BlueCardController(BlueCard blueCard)
    {
              blue= blueCard;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nameLabel.setText(blue.getName());

    }

    public void onClickContinue(ActionEvent ae)
    {
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }


}
