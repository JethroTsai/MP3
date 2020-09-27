package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.*;

import java.util.*;

public class GameLayoutController {
    @FXML
    private Label careerLabel, salaryLabel, pathLabel, moneyLabel, loanLabel, playerLabel;

    @FXML
    private Canvas board;

    @FXML
    private Button spin , pay;

    private GameResource gameResource;

    public void setGameResource(GameResource gameResource) {
        this.gameResource = gameResource;

       if(gameResource.getCurrentPlayer().getPath()==null)
       {
           gameResource.getCurrentPlayer().setPath(new WindowCaller().choosePath(gameResource.getStartingCareerPath(),gameResource.getStartingCollegePath()));
           gameResource.getCurrentPlayer().resetSpace();
           gameResource.getCurrentPlayer().getPath().getSpaces().get(gameResource.getCurrentPlayer().getSpace()).addPlayer(gameResource.getCurrentPlayer());
           System.out.println(gameResource.getCurrentPlayer().getPath().getName());
           if(gameResource.getCurrentPlayer().getPath().getName().equals("College Path"))
           {
               gameResource.getCurrentPlayer().loan();
               gameResource.getCurrentPlayer().loan();

           }

           else
           {
               new WindowCaller().careerCard(gameResource.getCareers().getCareers()[0],gameResource.getCurrentPlayer());
               new WindowCaller().salaryCard(gameResource.getSalaries().getSalaries()[0],gameResource.getCurrentPlayer());
           }



       }




        drawBoard(gameResource);
        if (gameResource.getCurrentPlayer().getCareer() != null)careerLabel.setText("Career: " + gameResource.getCurrentPlayer().getCareer().getName());
        if (gameResource.getCurrentPlayer().getSalary() != null)salaryLabel.setText("Salary: " + gameResource.getCurrentPlayer().getSalary().getAmount());
        if (gameResource.getCurrentPlayer().getPath() != null)pathLabel.setText("Current Path: " + gameResource.getCurrentPlayer().getPath().getName());
        moneyLabel.setText("Balance: " + gameResource.getCurrentPlayer().getBalance());
        loanLabel.setText("Loans: " + gameResource.getCurrentPlayer().getLoans());
        playerLabel.setText("Player: " + gameResource.getCurrentPlayer().getName());
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
        for(Player player : space.getPlayers()) {
            gc.drawImage(new Image("/Pics/player.png",25,25,true,false), x , y );
        }
    }

    @FXML
    public void onClickSpin(ActionEvent action)
    {
        Random rand = new Random();
        Player currPlayer = gameResource.getCurrentPlayer();
        int i, j = 0;
        String spaceName;

        i = rand.nextInt(10) + 1;

        while (!currPlayer.getPath().getSpace(currPlayer.getSpace()).getColor().equals("Magenta") && j < i) {
            currPlayer.addSpace();
            j++;
        }

        if (currPlayer.getPath().getSpace(currPlayer.getSpace()).getColor().equals("Orange"))
        {
            if (gameResource.getOtherPlayer().size() == 1)
                gameResource.getActions().execute(currPlayer, gameResource.getOtherPlayer().get(0));
            else
                gameResource.getActions().execute(currPlayer, gameResource.getOtherPlayer().get(0), gameResource.getOtherPlayer().get(1));
        }
        else if (currPlayer.getPath().getSpace(currPlayer.getSpace()).getColor().equals("Blue"))
        {
            if (gameResource.getOtherPlayer().size() == 1)
                if (gameResource.getOtherPlayer().get(0).getCareer().equals(gameResource.getBlues()))
                    gameResource.getBlues().execute(currPlayer, gameResource.getOtherPlayer().get(0));
                else
                    gameResource.getBlues().execute(currPlayer);
            else
                if (gameResource.getOtherPlayer().get(0).getCareer().equals(gameResource.getBlues()))
                    gameResource.getBlues().execute(currPlayer, gameResource.getOtherPlayer().get(0));
                else if (gameResource.getOtherPlayer().get(1).getCareer().equals(gameResource.getBlues()))
                    gameResource.getBlues().execute(currPlayer, gameResource.getOtherPlayer().get(1));
                else
                    gameResource.getBlues().execute(currPlayer);
        }
        else if (currPlayer.getPath().getSpace(currPlayer.getSpace()).getColor().equals("Green"))
        {
            spaceName = ((GreenSpace) currPlayer.getPath().getSpace(currPlayer.getSpace())).getName();
            if (spaceName.equals("Pay Day"))
            {
                ((GreenSpace) currPlayer.getPath().getSpace(currPlayer.getSpace())).giveSalary(currPlayer);
            }
            else
            {
                ((GreenSpace) currPlayer.getPath().getSpace(currPlayer.getSpace())).raiseSalary(currPlayer);
            }
        }
        else if (currPlayer.getPath().getSpace(currPlayer.getSpace()).getColor().equals("Magenta"))
        {
            spaceName = ((MagentaSpace) currPlayer.getPath().getSpace(currPlayer.getSpace())).getName();
            if (spaceName.equals("Graduation"))
            {
                currPlayer.graduate();
            }
            else if (spaceName.equals("College Career Choice"))
            {
//                gameResource.getCareers().getCareers()[0] -> gameResource.getCareer().getTopCard();
                new WindowCaller().collegeCareerChoice(currPlayer, gameResource.getCareers().getCareers()[0], gameResource.getCareers().getCareers()[1], gameResource.getSalaries().getSalaries()[0], gameResource.getSalaries().getSalaries()[1]);

            }
            else if (spaceName.equals("Job Search"))
            {
//                new WindowCaller().askPlayerToKeepCareer(currPlayer, gameResource.getCareers().getCareers()[0]);
            }
            else if (spaceName.equals("Buy a House"))
            {
                new WindowCaller().chooseHouseCard(gameResource.getHouses().getHouses());
            }
            else if (spaceName.equals("Get Married"))
            {
                currPlayer.marry();
            }
            else if (spaceName.equals("Have Baby or Twins"))
            {

            }
            else //junction
            {

            }
        }
    }



}
