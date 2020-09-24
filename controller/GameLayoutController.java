package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class GameLayoutController implements Initializable {
    @FXML
    private Label careerLabel, salaryLabel, pathLabel, moneyLabel, loanLabel;

    @FXML
    private Canvas board;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        board.setWidth(55*100);
        GraphicsContext gc = board.getGraphicsContext2D();
        for(int i = 0; i < 100; i++) {
            gc.strokeRect(i * 55, 50, 50, 50);
            gc.strokeText(Integer.toString(i), i * 55, 50 + 50 / 2);
        }
        careerLabel.setText("Career Here");
        salaryLabel.setText("Salary Here");
        pathLabel.setText("Path Here");
        moneyLabel.setText("Money Here");
        loanLabel.setText("Loan Here");
    }
}
