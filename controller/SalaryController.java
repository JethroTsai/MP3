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

    public SalaryController(Salary salary)
    {
        pay=salary;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        careerLabel.setText("Salary: " + pay.getAmount());
        degreeLabel.setText("tax: "+ pay.getTax());

    }

    @FXML
    public void onClickContinue(ActionEvent ae)
    {


        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();

    }

}
