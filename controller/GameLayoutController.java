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
        boolean ended = false;

        //while(!ended)
        //{
            pay.setDisable(true);

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
                else//Career Path
                {
                    new WindowCaller().careerCard(gameResource.getCareers().getTopCard(false),gameResource.getCurrentPlayer());
                    new WindowCaller().salaryCard(gameResource.getSalaries().getTopCard(),gameResource.getCurrentPlayer());
                }
            }
            if(gameResource.getCurrentPlayer().getLoans() != 0)
            {
                pay.setDisable(false);
            }

            drawBoard(gameResource);
            if (gameResource.getCurrentPlayer().getCareer() != null)careerLabel.setText("Career: " + gameResource.getCurrentPlayer().getCareer().getName());
            if (gameResource.getCurrentPlayer().getSalary() != null)salaryLabel.setText("Salary: " + gameResource.getCurrentPlayer().getSalary().getAmount());
            if (gameResource.getCurrentPlayer().getPath() != null)pathLabel.setText("Current Path: " + gameResource.getCurrentPlayer().getPath().getName());
            moneyLabel.setText("Balance: " + gameResource.getCurrentPlayer().getBalance());
            loanLabel.setText("Loans: " + gameResource.getCurrentPlayer().getLoans());
            playerLabel.setText("Player: " + gameResource.getCurrentPlayer().getName());

            if (gameResource.getCurrentPlayer().isRetired())
            {
                if (gameResource.getOtherPlayer().size() == 1)
                    if (gameResource.getOtherPlayer().get(0).isRetired())
                        ended = true;
                else
                {
                    if (gameResource.getOtherPlayer().get(0).isRetired())
                        if (gameResource.getOtherPlayer().get(1).isRetired())
                            ended = true;
                }
            }
        //}

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
    public void onClickSpin(ActionEvent action) {
        Random rand = new Random();
        Player currPlayer = gameResource.getCurrentPlayer();
        int i;
        int j = 1;
        int k = 0;
        String spaceName;
        int place = 1;


        i = rand.nextInt(10) + 1;

        while (!currPlayer.getPath().getSpace(currPlayer.getSpace() + j).getColor().equals("Magenta") && j < i) {
            System.out.println(i);
            if (currPlayer.getPath().getSpace(currPlayer.getSpace()).getPlayers().size() == 1) //if space contains only 1 player
            {
                currPlayer.getPath().getSpace(currPlayer.getSpace()).getPlayers().remove(0);
            } else {
                while (k < currPlayer.getPath().getSpace(currPlayer.getSpace()).getPlayers().size()) //check which player
                {
                    if (currPlayer.getName().equals(currPlayer.getPath().getSpace(currPlayer.getSpace()).getPlayers().get(k).getName()))// if current player matches
                        currPlayer.getPath().getSpace(currPlayer.getSpace()).getPlayers().remove(k);
                    k++;//next player
                }
            }
            j++;
        }
        for (j = j; j >= 0; j--)
        {
            currPlayer.addSpace();
            if (currPlayer.getPath().getNSpaces() == currPlayer.getSpace() + 1)
            {
                if (((MagentaSpace) currPlayer.getPath().getSpace(currPlayer.getSpace())).getName().equals("Which Path"))
                {
                    System.out.println("TITE LIIT");
                    currPlayer.setPath(new WindowCaller().choosePath(currPlayer.getPath().getPath1(), currPlayer.getPath().getPath2()));
                    currPlayer.resetSpace();
                }
                else
                {
                    System.out.println("HATDOG LAKI");
                    currPlayer.setPath(currPlayer.getPath().getPath1());
                    currPlayer.resetSpace();
                }
            }

        }

            if (currPlayer.getPath().getSpace(currPlayer.getSpace()).getColor().equals("Orange")) //orange space
            {
                if (gameResource.getOtherPlayer().size() == 1)
                    gameResource.getActions().execute(currPlayer, gameResource.getOtherPlayer().get(0));
                else
                    gameResource.getActions().execute(currPlayer, gameResource.getOtherPlayer().get(0), gameResource.getOtherPlayer().get(1));
            } else if (currPlayer.getPath().getSpace(currPlayer.getSpace()).getColor().equals("Blue")) //blue space
            {
                BlueCard blue = gameResource.getBlues().getTopCard();
                if (gameResource.getOtherPlayer().size() == 1) {
                    if (gameResource.getOtherPlayer().get(0).getCareer() != null) {
                        if (gameResource.getOtherPlayer().get(0).getCareer().equals(blue.getJob()))
                            gameResource.getBlues().execute(currPlayer, gameResource.getOtherPlayer().get(0), blue);
                        else
                            gameResource.getBlues().execute(currPlayer, blue);
                    }
                    else
                        gameResource.getBlues().execute(currPlayer, blue);
                }
                else {
                    if (gameResource.getOtherPlayer().get(0).getCareer() != null)
                    {
                        if (gameResource.getOtherPlayer().get(1).getCareer() != null)
                        {
                            if (gameResource.getOtherPlayer().get(0).getCareer().equals(blue.getJob()))
                                gameResource.getBlues().execute(currPlayer, gameResource.getOtherPlayer().get(0), blue);
                            else if (gameResource.getOtherPlayer().get(1).getCareer().equals(blue.getJob()))
                                gameResource.getBlues().execute(currPlayer, gameResource.getOtherPlayer().get(1), blue);
                            else
                                gameResource.getBlues().execute(currPlayer, blue);
                        }
                    }
                    else if (gameResource.getOtherPlayer().get(1).getCareer() != null)
                    {
                        if (gameResource.getOtherPlayer().get(1).getCareer().equals(blue.getJob()))
                            gameResource.getBlues().execute(currPlayer, gameResource.getOtherPlayer().get(1), blue);
                        else
                            gameResource.getBlues().execute(currPlayer, blue);
                    }
                    else
                    {
                        gameResource.getBlues().execute(currPlayer, blue);
                    }

                }
                gameResource.getBlues().addCard(blue);
            } else if (currPlayer.getPath().getSpace(currPlayer.getSpace()).getColor().equals("Green")) //green space
            {
                System.out.println("GREENTICO");
                spaceName = ((GreenSpace) currPlayer.getPath().getSpace(currPlayer.getSpace())).getName();
                if (spaceName.equals("Pay Day")) {
                    ((GreenSpace) currPlayer.getPath().getSpace(currPlayer.getSpace())).giveSalary(currPlayer);
                } else {
                    ((GreenSpace) currPlayer.getPath().getSpace(currPlayer.getSpace())).raiseSalary(currPlayer);
                }
            } else if (currPlayer.getPath().getSpace(currPlayer.getSpace()).getColor().equals("Magenta")) //magenta space
                {
                spaceName = ((MagentaSpace) currPlayer.getPath().getSpace(currPlayer.getSpace())).getName();
                if (spaceName.equals("Graduation")) {
                    currPlayer.graduate();
                } else if (spaceName.equals("College Career Choice")) {

//                gameResource.getCareers().getCareers()[0] -> gameResource.getCareer().getTopCard();
                    new WindowCaller().collegeCareerChoice(gameResource, currPlayer);

                } else if (spaceName.equals("Job Search")) {
//                new WindowCaller().askPlayerToKeepCareer(currPlayer, gameResource.getCareers().getCareers()[0]);
                } else if (spaceName.equals("Buy a House")) {
                    new WindowCaller().chooseHouseCard(gameResource.getHouses().getHouses());
                } else if (spaceName.equals("Get Married")) {
                    currPlayer.marry();
                } else if (spaceName.equals("Have Baby or Twins")) {
                    if ((rand.nextInt(10) + 1) % 2 == 0) {
                        currPlayer.addChild();
                        currPlayer.addChild();
                        while (!gameResource.getOtherPlayer().isEmpty()) {
                            gameResource.getOtherPlayer().remove(0).payPlayer(10000, currPlayer);
                        }
                    } else {
                        currPlayer.addChild();
                        while (!gameResource.getOtherPlayer().isEmpty()) {
                            gameResource.getOtherPlayer().remove(0).payPlayer(5000, currPlayer);
                        }
                    }
                }
                else if (spaceName.equals("Retirement"))
                {
                    if (gameResource.getOtherPlayer().size() == 1) {
                        if (gameResource.getOtherPlayer().get(0).isRetired())
                            currPlayer.retire(2);
                        else
                            currPlayer.retire(1);
                    }
                    else
                    {
                        if (gameResource.getOtherPlayer().get(0).isRetired()) {
                            if (gameResource.getOtherPlayer().get(1).isRetired())
                                currPlayer.retire(3);
                            else
                                currPlayer.retire(2);
                        }
                        else if (gameResource.getOtherPlayer().get(1).isRetired()) {
                                currPlayer.retire(2);
                        }
                        else
                        {
                            currPlayer.retire(1);
                        }
                    }
                }
                //else //Which Path
                //{
                //    currPlayer.setPath(new WindowCaller().choosePath(currPlayer.getPath().getPath1(), currPlayer.getPath().getPath2()));
                //    currPlayer.resetSpace();
                //}
            }
            if (!currPlayer.getPath().getSpace(currPlayer.getSpace()).getColor().equals("Magenta")) {
                currPlayer.notYourTurn();
                gameResource.getNextPlayer().yourTurn();
                gameResource.getOtherPlayer().add(currPlayer);
            }



        }



}
