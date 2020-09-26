package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Path;

import java.net.URL;
import java.util.ResourceBundle;

public class PathChoiceController implements Initializable
{
    @FXML
    private ComboBox comboBox;

    private Path path1,path2;
    private Path chosenPath;

    public PathChoiceController(Path path1, Path path2)
    {
        this.path1=path1;
        this.path2=path2;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        comboBox.getItems().add(path1.getName());
        comboBox.getItems().add(path2.getName());

    }

    @FXML
    public void onClickContinue(ActionEvent ae)
    {
        if(comboBox.getSelectionModel().getSelectedItem().equals(path1.getName()))
            chosenPath=path1;

        else
            chosenPath=path2;

        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();

    }


    public Path getChosenPath()
    {
        return chosenPath;
    }




}
