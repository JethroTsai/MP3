package controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.Path;
import model.Player;
import model.Space;
import model.GameResource;

import java.net.URL;
import java.util.ResourceBundle;

public class GameLayoutController implements Initializable {
    @FXML
    private Label careerLabel, salaryLabel, pathLabel, moneyLabel, loanLabel;

    @FXML
    private Canvas board;

    private GameResource gameResource;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawBoard();
        careerLabel.setText("Career Here");
        salaryLabel.setText("Salary Here");
        pathLabel.setText("Path Here");
        moneyLabel.setText("Money Here");
        loanLabel.setText("Loan Here");
    }

    public void setGameResource(GameResource gameResource) {
        this.gameResource = gameResource;
    }

    public void drawBoard()
    {
       // minus Y = upward
       // plus  Y = downwards
       // minus X = left
       // plus  X = right

       int x = 0, y = 100;
       board.setWidth(50);
       board.getGraphicsContext2D().clearRect(0, 0, board.getWidth(), board.getHeight());
       board.setHeight(200);
       GraphicsContext gc = board.getGraphicsContext2D();

      Path startingCareerPath = gameResource.getStartingCareerPath();
      drawPath(startingCareerPath, x, y, gc);

       x += (startingCareerPath.getNSpaces() - 1) * 50;
       y += 50;

       Path nextCareerPath = startingCareerPath.getPath1();
       drawPath(nextCareerPath, x, y, gc);

       y -= 100;

       Path startingCollegePath = gameResource.getStartingCollegePath();
       drawPath(startingCollegePath, x, y, gc);
       x += (startingCollegePath.getNSpaces() - 1) * 50;
       y += 50;
    }

    private void drawPath(Path path, int x, int y, GraphicsContext gc) {
        for(Space space : path.getSpaces()) {
            drawSpace(space, x, y, gc);
            x += 50;
        }
    }

    private void drawSpace(Space space, int x, int y, GraphicsContext gc) {
        if(space.getColor().equals("Orange")) gc.setFill(Color.ORANGE);
        else if(space.getColor().equals("Blue")) gc.setFill(Color.BLUE);
        else if(space.getColor().equals("Magenta")) gc.setFill(Color.MAGENTA);
        else if(space.getColor().equals("Green")) gc.setFill(Color.GREEN);
        gc.fillRect(x, y,50, 50);
//        for(Player player : space.getPlayers()) {
//            gc.drawImage(new Image(""), x + x / 2, y + y / 2);
//        }
    }
}
