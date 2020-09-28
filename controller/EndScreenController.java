package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.GameResource;
import model.Player;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EndScreenController implements Initializable {

    @FXML
    Label nameLabel, balanceLabel, careerLabel, statusLabel, retirementPlaceLabel;

    String name, career;
    int balance;
    boolean status;

    public EndScreenController(ArrayList<Player> retired)
    {
        Player player = retired.remove(0);
        this.name = player.getName();
        this.career = player.getCareer().getName();
        this.balance = player.getBalance();
        this.status = player.isMarried();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nameLabel.setText("Player Name: " + name);
        balanceLabel.setText("Balance: " + balance);
        careerLabel.setText("Career: " + career);
        if (status)
        {
            statusLabel.setText("Status: Married");
        }
        else
        {
            statusLabel.setText("Status: Single");
        }
    }


    public void onClickContinue(ActionEvent ae)
    {
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }
}
