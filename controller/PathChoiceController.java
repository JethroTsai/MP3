package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Path;

import java.net.URL;
import java.util.ResourceBundle;

public class PathChoiceController implements Initializable
{
    @FXML
    private ComboBox comboBox;
    @FXML
    private Button cont;

    private Path path1,path2;
    private Path chosenPath;

    /**
     * instantiates controller
     * @param path1 first path
     * @param path2 second path
     */
    public PathChoiceController(Path path1, Path path2)
    {
        this.path1=path1;
        this.path2=path2;
    }
    /**
     * initializes the parts for the GUI
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        cont.setDisable(true);
        comboBox.getItems().add(path1.getName());
        comboBox.getItems().add(path2.getName());

        comboBox.setOnAction(e->{
            if(comboBox.getValue()==null)
                cont.setDisable(true);

            else
                cont.setDisable(false);
        });

    }
    /**
     * sets what happens when continue button is clicked
     * @param ae is the action event
     */
    @FXML
    public void onClickContinue(ActionEvent ae)
    {
        if(comboBox.getSelectionModel().getSelectedItem().equals(path1.getName()))
            chosenPath=path1;

        else
            chosenPath=path2;

        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();

    }

    /**
     * returns path chosen by the user
     * @return chosen Path
     */
    public Path getChosenPath()
    {
        return chosenPath;
    }




}
