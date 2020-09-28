package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.util.*;

public class GameLayoutController {
    @FXML
    private Label careerLabel, salaryLabel, pathLabel, moneyLabel, loanLabel, playerLabel, statusLabel;

    @FXML
    private Canvas board;

    @FXML
    private Button spin , pay;

    private GameResource gameResource;
    private boolean ended = false;
//    private ArrayList<Player> activePlayers;
//    private ArrayList<Player> retiredPlayers;

    public void setGameResource(GameResource gameResource) {
        this.gameResource = gameResource;

        for(Player player : gameResource.getPlayers()) {
            if(player.getPath()==null)
            {
                player.setPath(new WindowCaller().choosePath(gameResource.getStartingCareerPath(),gameResource.getStartingCollegePath()));
                player.getPath().getSpaces().get(player.getSpace()).addPlayer(player);
                System.out.println(player.getPath().getName());
                if(player.getPath().getName().equals("College Path"))
                {
                    player.loan();
                    player.loan();
                }
                else//Career Path
                {
                    new WindowCaller().careerCard(gameResource.getCareers().getTopCard(false),player);
                    new WindowCaller().salaryCard(gameResource.getSalaries().getTopCard(),player);
                }
            }
        }
        drawBoard();
    }

    public void updateScreenStats(ActionEvent ae) {
        pay.setDisable(true);
        if(ended) {
            Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            // FXMLLOADER to the end game
//            stage.setScene();
        } else {
            if(gameResource.getCurrentPlayer().getLoans() != 0)
            {
                pay.setDisable(false);
            }

            if (gameResource.getCurrentPlayer().getCareer() != null)careerLabel.setText("Career: " + gameResource.getCurrentPlayer().getCareer().getName());
            if (gameResource.getCurrentPlayer().getSalary() != null)salaryLabel.setText("Salary: " + gameResource.getCurrentPlayer().getSalary().getAmount());
            if (gameResource.getCurrentPlayer().getPath() != null)pathLabel.setText("Current Path: " + gameResource.getCurrentPlayer().getPath().getName());
            moneyLabel.setText("Balance: " + gameResource.getCurrentPlayer().getBalance());
            loanLabel.setText("Loans: " + gameResource.getCurrentPlayer().getLoans());
            playerLabel.setText("Player: " + gameResource.getCurrentPlayer().getName());
            if (gameResource.getCurrentPlayer().isMarried()) {
                statusLabel.setText("Status: Married");
            }
            else
            {
                statusLabel.setText("Status: Single");
            }

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
        }
    }

    public void drawBoard()
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
        int i = 0;
        if(space.getColor().equals("Orange")) gc.setFill(Color.ORANGE);
        else if(space.getColor().equals("Blue")) gc.setFill(Color.BLUE);
        else if(space.getColor().equals("Magenta")) gc.setFill(Color.MAGENTA);
        else if(space.getColor().equals("Green")) gc.setFill(Color.GREEN);
        gc.fillRect(x, y,50, 50);
        gc.strokeRect(x, y, 50, 50);
        for(Player player : space.getPlayers()) {
            gc.drawImage(new Image("/Pics/player.png",25,25,true,false), x + i , y +i);
            i+=10;
        }
    }

    @FXML
    public void onClickSpin(ActionEvent ae) throws IOException {
        if(spin.getText().equals("End Game")) {
            // output
            // @TODO GAME WINNER STAGE/WINDOW/SCREEN
            Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            FXMLLoader endgame= new FXMLLoader(getClass().getResource("/view/EndScreen.fxml"));
            endgame.setController(new EndScreenController(gameResource.getRetired()));
            stage.setScene(new Scene(endgame.load()));



            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Menu.fxml"))));
            stage.setMaximized(false);
            return;
        }

        Random rand = new Random();
        Player currPlayer = gameResource.getCurrentPlayer();
        int i = rand.nextInt(10) + 1; // dice
        boolean moving = true;

        updateScreenStats(ae);

        currPlayer.getPath().getSpace(currPlayer.getSpace()).getPlayers().remove(currPlayer);
        for (int j = 0; j < i && moving; j++)
        {
            currPlayer.addSpace();
            System.out.println(currPlayer.getPath().getNSpaces() + " " + (currPlayer.getSpace() + 1));
            if (currPlayer.getPath().getNSpaces() == currPlayer.getSpace() + 1)
            {
                if ((currPlayer.getPath().getSpace(currPlayer.getSpace())).getColor().equals("Magenta"))
                {
                    // since its in magenta space
                    moving = false;
                }
                else
                {
                    System.out.println("HATDOG LAKI");
                    currPlayer.setPath(currPlayer.getPath().getPath1());
                }
            } else {
                if((currPlayer.getPath().getSpace(currPlayer.getSpace())).getColor().equals("Magenta")) {
                    moving = false;
                }
            }
        }

        handleSpace(currPlayer.getPath().getSpace(currPlayer.getSpace()));
        if(gameResource.getPlayers().size() != 0) {
            if (currPlayer.getName().equals(gameResource.getCurrentPlayer().getName()))
            {
                // if player is stuck at the end of the path, add that path to the next
                if(currPlayer.getPath().getNSpaces() == currPlayer.getSpace() + 1) {
                    if(currPlayer.getPath().getPath2() == null) {
                        currPlayer.setPath(currPlayer.getPath().getPath1());
                    }
                }
                currPlayer.getPath().getSpace(currPlayer.getSpace()).addPlayer(currPlayer);
                gameResource.incrementPlayerIndex();
            }
            else
            {
                currPlayer.getPath().getSpace(currPlayer.getSpace()).addPlayer(currPlayer);
                gameResource.incrementPlayerIndex();
            }

            drawBoard();
        } else {
            spin.setText("End Game");
        }
    }

    public void handleSpace(Space space) {
        System.out.println("Handling " + space.getColor());
        String spaceName;
        Player currPlayer = gameResource.getCurrentPlayer();
        Random rand = new Random();

        if (space.getColor().equals("Orange")) //orange space
        {
            if (gameResource.getOtherPlayer().size() == 1)
            {
                gameResource.getActions().execute(currPlayer, gameResource.getOtherPlayer().get(0));
                new WindowCaller().actionCard(gameResource.getActions().getTopCard());

            }


           else if(gameResource.getOtherPlayer().size() == 2)
            {
                if(gameResource.getActions().showTop().getName().equalsIgnoreCase("Lawsuit"))
                {
                    int amount=gameResource.getActions().getTopCard().getAmount();
                    Player player= new WindowCaller().actionChoice(gameResource.getOtherPlayer().get(0),gameResource.getOtherPlayer().get(1),"Lawsuit- " + amount);
                    currPlayer.payPlayer(amount,player);
                }

                else if(gameResource.getActions().showTop().getName().equalsIgnoreCase("File a Lawsuit"))
                {
                    System.out.println("hi");
                    int amount=gameResource.getActions().getTopCard().getAmount();
                    Player play=new WindowCaller().actionChoice(gameResource.getOtherPlayer().get(0),gameResource.getOtherPlayer().get(1),"File a Lawsuit " + amount);

                    play.payPlayer(amount,currPlayer);

                }
                else
                {
                    gameResource.getActions().execute(currPlayer, gameResource.getOtherPlayer().get(0), gameResource.getOtherPlayer().get(1));
                    new WindowCaller().actionCard(gameResource.getActions().getTopCard());
                }

            }

           else
            {
                new WindowCaller().messageBox("you are the only player left retire");
            }

        } else if (space.getColor().equals("Blue")) //blue space
        {
            BlueCard blue = gameResource.getBlues().getTopCard();
            new WindowCaller().bluecard(blue);
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
                if(gameResource.getOtherPlayer().size() > 0) {
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
                else
                {
                    gameResource.getBlues().execute(currPlayer, blue);
                }
            }
            gameResource.getBlues().addCard(blue);
        } else if (space.getColor().equals("Green")) //green space
        {
            spaceName = ((GreenSpace) space).getName();
            new WindowCaller().greenSpace(spaceName);
            if (spaceName.equals("Pay Day")) {
                ((GreenSpace) space).giveSalary(currPlayer);
            }
            else
                {
                ((GreenSpace) space).raiseSalary(currPlayer);
            }
        } else if (space.getColor().equals("Magenta")) //magenta space
        {
            spaceName = ((MagentaSpace) space).getName();
            System.out.println(spaceName);
            if (spaceName.equals("Graduation")) {
                new WindowCaller().messageBox("Congratulations!!! You have graduated.");
                currPlayer.graduate();
            } else if (spaceName.equals("College Career Choice")) {
                new WindowCaller().collegeCareerChoice(gameResource, currPlayer);

            } else if (spaceName.equals("Job Search")) {
            new WindowCaller().jobSearch( gameResource,currPlayer);
            } else if (spaceName.equals("Buy a House")) {

                if(currPlayer.getHouse()!=null)
                {
                    new WindowCaller().messageBox("You already have a house " + currPlayer.getName());
                }
                else
                    {
                        House house=((House)new WindowCaller().chooseHouseCard(gameResource.getHouses().getHouses()));
                        currPlayer.buyHouse(house);
                    }

            }
            else if (spaceName.equals("Get Married")) {
                if (!currPlayer.isMarried())
                {
                    new WindowCaller().messageBox("Congratulations!!! You are now married.");
                    currPlayer.marry();
                }
                else
                {
                    new WindowCaller().messageBox("You are already married! You cannot marry more than once.");
                }
            } else if (spaceName.equals("Which Path")) {
                currPlayer.setPath(new WindowCaller().choosePath(currPlayer.getPath().getPath1(), currPlayer.getPath().getPath2()));
            } else if (spaceName.equals("Have Baby or Twins")) {

                if ((rand.nextInt(10) + 1) % 2 == 0) {
                    new WindowCaller().messageBox("Congratulations!!! You have Twins.");
                    currPlayer.addChild();
                    currPlayer.addChild();
                   for(Player player: gameResource.getOtherPlayer())
                   {
                       player.payPlayer(10000,currPlayer);
                   }

                } else {
                    new WindowCaller().messageBox("Congratulations!!! You had a Baby.");
                    currPlayer.addChild();
                    for(Player player: gameResource.getOtherPlayer())
                    {
                        player.payPlayer(5000,currPlayer);
                    }
                }
            }
            else if (spaceName.equals("Retirement"))
            {
                gameResource.retirePlayer(currPlayer);
                currPlayer.sellChild();
                currPlayer.sellHouse();
                currPlayer.payLoan(currPlayer.getLoans());
                gameResource.getRetired().add(currPlayer);
                gameResource.getPlayers().remove(currPlayer);
            }
        }
    }
}
