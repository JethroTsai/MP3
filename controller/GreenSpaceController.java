package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GreenSpaceController implements Initializable {

    @FXML
    Label nameLabel;
    String name;

    /**
     * instantiates the controller
     * @param name name of the space
     */
    public GreenSpaceController(String name)
    {
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
