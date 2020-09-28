package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MessageController implements Initializable {

    @FXML
    Label nameLabel;

    String text;

    public MessageController(String text)
    {
        this.text=text;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
       nameLabel.setText(text);
    }


    public void onClickContinue(ActionEvent ae)
    {
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }
}
