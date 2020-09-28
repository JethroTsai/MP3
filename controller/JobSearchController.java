package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Career;
import model.Salary;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class JobSearchController implements Initializable {

    @FXML
    private ComboBox careerCombobox, salaryCombobox;

    @FXML
    private Button continueButton;

    private Career career1, career2;
    private Salary salary1, salary2;

    private Career chosenCareer;
    private Salary chosenSalary;

    public JobSearchController(Career career1, Career career2, Salary salary1, Salary salary2) {
        this.career1 = career1;
        this.career2 = career2;
        this.salary1 = salary1;
        this.salary2 = salary2;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        continueButton.setDisable(true);

        ArrayList<String> careerChoices = new ArrayList<>();
        careerChoices.add(career1.toString());
        careerChoices.add(career2.toString());
        careerCombobox.getItems().addAll(careerChoices);

        ArrayList<String> salaryChoices = new ArrayList<>();
        salaryChoices.add(salary1.toString());
        salaryChoices.add(salary2.toString());
        salaryCombobox.getItems().addAll(salaryChoices);

        careerCombobox.setOnAction(e -> {
            if(careerCombobox.getValue() == null || salaryCombobox.getValue() == null) continueButton.setDisable(true);
            else continueButton.setDisable(false);
        });

        salaryCombobox.setOnAction(e -> {
            if(careerCombobox.getValue() == null || salaryCombobox.getValue() == null) continueButton.setDisable(true);
            else continueButton.setDisable(false);
        });
    }

    @FXML
    public void onClickContinue(ActionEvent ae) {
        chosenCareer = careerCombobox.getSelectionModel().getSelectedIndex() == 0 ? career1 : career2;
        chosenSalary = salaryCombobox.getSelectionModel().getSelectedIndex() == 0 ? salary1 : salary2;
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

    public Career getChosenCareer() {
        return chosenCareer;
    }

    public Salary getChosenSalary() {
        return chosenSalary;
    }
}
