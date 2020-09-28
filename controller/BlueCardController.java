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
    @FXML
    Label jobLabel;
    private BlueCard blue;

    /**
     * instantiates the controller
     * @param blueCard is the BlueCard
     */
    public BlueCardController(BlueCard blueCard)
    {
              blue= blueCard;
    }

    /**
     * initializes the parts for the GUI
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nameLabel.setText(blue.getName());
        jobLabel.setText(blue.getJob());
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
