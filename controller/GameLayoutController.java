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

public class GameLayoutController {
    @FXML
    private Label careerLabel, salaryLabel, pathLabel, moneyLabel, loanLabel;

    @FXML
    private Canvas board;

    public void setGameResource(GameResource gameResource) {
        drawBoard(gameResource);
//        careerLabel.setText(gameResource.getCurrentPlayer().getCareer());
//        salaryLabel.setText("Salary Here");
//        pathLabel.setText("Path Here");
//        moneyLabel.setText("Money Here");
//        loanLabel.setText("Loan Here");
    }

    public void drawBoard(GameResource gameResource)
    {
       // minus Y = upward
       // plus  Y = downwards
       // minus X = left
       // plus  X = right

       int x = 50, y = 300;
       board.setWidth(gameResource.getStartingCareerPath().getNSpaces() * 6 * 2 * 50);
       board.getGraphicsContext2D().clearRect(0, 0, board.getWidth(), board.getHeight());
       board.setHeight(500);
       GraphicsContext gc = board.getGraphicsContext2D();

        Path startingCareerPath = gameResource.getStartingCareerPath();
        drawPath(startingCareerPath, x, y, gc);

        y += 100;

        Path startingCollegePath = gameResource.getStartingCollegePath();
        drawPath(startingCollegePath, x, y, gc);

        x += (startingCollegePath.getNSpaces() - 1) * 50;
        y -= 50;

        Path normal1 = startingCareerPath.getPath1();
        drawPath(normal1, x, y, gc);

         x += (normal1.getNSpaces() - 1) * 50;
         y -= 50;

        Path changeCareer1 = normal1.getPath1();
        drawPath(changeCareer1, x, y, gc);

        y += 100;

        Path family1 = normal1.getPath2();
        drawPath(family1, x, y, gc);

        x += (family1.getNSpaces() - 1) * 50;
        y -= 50;

        Path normal2 = changeCareer1.getPath1();
        drawPath(normal2, x, y, gc);

        x += (normal2.getNSpaces() - 1) * 50;
        y -= 50;

        Path changeCareer2 = normal2.getPath1();
        drawPath(changeCareer2, x, y, gc);

        y += 100;

        Path family2 = normal2.getPath2();
        drawPath(family2, x, y, gc);

        x += (family2.getNSpaces() - 1) * 50;
        y -= 50;

        Path retirement = family2.getPath1();
        drawPath(retirement, x, y, gc);
    }

    private void drawPath(Path path, int x, int y, GraphicsContext gc) {
        gc.strokeText(path.getName(), x + (path.getNSpaces() / 2) * 50, y - 10);
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
        gc.strokeRect(x, y, 50, 50);
//        for(Player player : space.getPlayers()) {
//            gc.drawImage(new Image(""), x + x / 2, y + y / 2);
//        }
    }
}
