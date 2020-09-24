import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Observable;


public class controller
{
    ObservableList<Integer> players = FXCollections.observableArrayList(2,3);
    @FXML private ChoiceBox choice;
    @FXML private Button start;

    public void initialize()
    {

        choice.setItems(players);
    }
    









}
