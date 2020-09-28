package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Career;
import model.Player;

import java.net.URL;
import java.util.ResourceBundle;
public class CareerCardController implements Initializable
{
    @FXML
    private Label careerLabel, degreeLabel;

    private Career career;

    /**
     * instantiates the controller
     * @param job is the Career Card
     */
    public CareerCardController(Career job)
    {
        this.career=job;

    }

    /**
     * initializes the parts for the GUI
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        careerLabel.setText("Career: " + career.getName());
        degreeLabel.setText("Raises: " + career.getRaises());

    }

    /**
     * sets what happens when continue button is clicked
     * @param ae is the action event
     */
    @FXML
    public void onClickContinue(ActionEvent ae)
    {


        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();

    }

}
