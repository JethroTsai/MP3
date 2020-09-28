package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Salary;

import java.net.URL;
import java.util.ResourceBundle;

public class SalaryController implements Initializable
{
    @FXML
    Label careerLabel,degreeLabel;
    private Salary pay;

    /**
     * instantiates the controller
     * @param salary Salary Card
     */
    public SalaryController(Salary salary)
    {
        pay=salary;
    }
    /**
     * initializes the parts for the GUI
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        careerLabel.setText("Salary: " + pay.getAmount());
        degreeLabel.setText("tax: "+ pay.getTax());

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
