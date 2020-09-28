package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.GameResource;
import model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EndScreenController implements Initializable {

    @FXML
    Label nameLabel, balanceLabel, statusLabel;

    @FXML
    Label careerLabel;

    String name;
    String career;

    int balance;
    boolean status;

    /**
     * instantiates the object
     * @param retired arrayList of retired players
     */
    public EndScreenController(ArrayList<Player> retired)
    {
        Player player = retired.remove(0);
        this.name = player.getName();
        this.career = player.getCareer().getName();
        this.balance = player.getBalance();
        this.status = player.isMarried();
    }
    /**
     * initializes the parts for the GUI
     * @param location
     * @param resources
     */
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

    /**
     * sets what happens when continue button is clicked
     * @param ae is the action event
     */
    public void onClickContinue(ActionEvent ae) throws IOException
    {
        Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Menu.fxml"))));
    }
}
