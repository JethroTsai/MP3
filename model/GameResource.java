package model;

import controller.GameLayoutController;

import java.util.*;

public class GameResource
{
    private static final String[] COLORS = {"Orange", "Blue", "Green", "Magenta"};
    private static final String[] GREEN_NAME = {"Pay Day", "Pay Raise"};
    private static final String[] MAGENTA_NAME = {"Have Baby or Twins", "Buy a House"};
    private Path startingCollegePath;
    private Path startingCareerPath;
    private int numberOfPlayers;
    private ArrayList<Player> players;
    private ArrayList<Player> retired;
    private ActionCard actions;
    private BlueDeck blues;
    private CareerDeck careers;
    private SalaryDeck salaries;
    private HouseDeck houses;
    private int playerIndex = 0;

    /**
     * this instantiates the class, which stores all of the other classes
     * @param numberOfPlayers is the number of players
     */
    public GameResource(int numberOfPlayers)
    {
        this.numberOfPlayers = numberOfPlayers;
        players = new ArrayList<>();
        retired = new ArrayList<>();

        generatePlayers();
        actions = generateActionCard();
        blues = generateBlueDeck();
        careers = generateCareerDeck();
        salaries = generateSalaryDeck();
        houses = generateHouseDeck();
        generateBoard();
    }

    /**
     * generates and returns arrayList of ActionCards
     * @return generated action card deck
     */
    public ActionCard generateActionCard()
    {
        ActionCard actions = new ActionCard();

        actions.generate();
        return actions;
    }

    /**
     * generates and returns BlueDeck
     * @return generated BlueDeck
     */
    public BlueDeck generateBlueDeck()
    {
        BlueDeck blueDeck = new BlueDeck();

        blueDeck.generate();
        return blueDeck;
    }
    /**
     * generates and returns BlueDeck
     * @return generated BlueDeck
     */
    public CareerDeck generateCareerDeck()
    {
        CareerDeck careerDeck = new CareerDeck();

        careerDeck.generate();
        return careerDeck;
    }

    /**
     * generates and returns SalaryDeck
     * @return generated SalaryDeck
     */
    public SalaryDeck generateSalaryDeck()
    {
        SalaryDeck salaries = new SalaryDeck();

        salaries.generate();
        return salaries;
    }

    /**
     * generates and returns HouseDeck
     * @return generated HouseDeck
     */
    public HouseDeck generateHouseDeck()
    {
        HouseDeck houses = new HouseDeck();

        houses.generate();
        return houses;
    }

    /**
     * generates board
     */
    public void generateBoard()
    {
        Path retirement = generateRetirement();
        Path changeCareer2 = generateChangeCareerPath(retirement);
        Path family2 = generateFamilyPath(retirement);
        Path normal2 = generateNormalPath(changeCareer2, family2);
        Path changeCareer1 = generateChangeCareerPath(normal2);
        Path family1 = generateFamilyPath(normal2);
        Path normal1 = generateNormalPath(changeCareer1, family1);
        startingCollegePath = generateCareerPath(normal1);
        startingCareerPath = generateCollegePath(normal1);
    }

    /**
     * generates and returns collegePath
     * @param nextPath path leading to normal Path
     * @return Path generated
     */
    public Path generateCollegePath(Path nextPath)
    {
        Path path = new Path("College Path", nextPath);
        String color = new String();
        for (int i = 1; i < 10; i++)
        {
            color = COLORS[0];

            path.addSpace(new Space(color));
        }
        path.addSpace(new MagentaSpace("Graduation"));
        path.addSpace(new MagentaSpace("College Career Choice"));

        return path;
    }

    /**
     * generates and returns CareerPath
     * @param nextPath path leading to normal Path
     * @return Path generated
     */
    public Path generateCareerPath(Path nextPath)
    {
        Path path = new Path("Career Path", nextPath);
        String color = new String();
        String name = new String();

        path.addSpace(new MagentaSpace("Job Search"));
        for (int i = 1; i < 10; i++)
        {
            Random rand = new Random();
            color = COLORS[rand.nextInt(2)];
            if (color.equals("Green"))
            {
                name = GREEN_NAME[rand.nextInt(2)];
                path.addSpace(new GreenSpace(name));
            }
            else
            {
                path.addSpace(new Space(color));
            }
        }
        path.addSpace(new MagentaSpace("Get Married"));

        return path;
    }

    /**
     * generates and returns normalPath
     * @param path1 is the first path
     * @param path2 is the second Path
     * @return Path generated
     */
    public Path generateNormalPath(Path path1, Path path2)
    {
        Path path = new Path("Normal Path", path1,path2);
        String color = new String();
        String name = new String();

        for (int i = 1; i < 30; i++)
        {
            Random rand = new Random();
            color = COLORS[rand.nextInt(3)];
            if (color.equals("Green"))
            {
                name = GREEN_NAME[rand.nextInt(2)];
                path.addSpace(new GreenSpace(name));
            }
            else
            {
                path.addSpace(new Space(color));
            }
        }
        path.addSpace(new MagentaSpace("Which Path"));

        return path;
    }

    /**
     * generates and returns family path
     * @param nextPath is the path leading to normalPath
     * @return Path generated
     */
    public Path generateFamilyPath(Path nextPath)
    {
        Path path = new Path("Family Path", nextPath);
        String color = new String();
        String name = new String();


        for (int i = 1; i < 15; i++)
        {
            Random rand = new Random();
            color = COLORS[rand.nextInt(4)];
            if (color.equals("Green"))
            {
                name = GREEN_NAME[rand.nextInt(2)];
                path.addSpace(new GreenSpace(name));
            }
            else if (color.equals("Magenta"))
            {
                name = MAGENTA_NAME[rand.nextInt(2)];
                path.addSpace(new MagentaSpace(name));
            }
            else
            {
                path.addSpace(new Space(color));
            }
        }
        path.addSpace(new MagentaSpace("Get Married"));

        return path;
    }

    /**
     * generates and returns changCareerPath
     * @param nextPath is the normal Path
     * @return generated Path
     */
    public Path generateChangeCareerPath(Path nextPath)
    {
        Path path = new Path("Change Career Path", nextPath);
        String color = new String();
        String name = new String();
        int num;


        for (int i = 1; i < 15; i++)
        {
            Random rand = new Random();
            num = rand.nextInt(5);
            if (num >= 2)
            {
                name = GREEN_NAME[rand.nextInt(2)];
                path.addSpace(new GreenSpace(name));
            }
            else
            {
                color = COLORS[0];
                path.addSpace(new Space(color));
            }
        }
        path.addSpace(new MagentaSpace("Job Search"));
        return path;
    }

    /**
     * generates retirement Path
     * @return Path generated
     */
    public Path generateRetirement()
    {
        Path path = new Path("Retirement Path");
        String color = new String();
        String name = new String();

        for (int i = 1; i < 30; i++)
        {
            Random rand = new Random();
            color = COLORS[rand.nextInt(3)];
            if (color.equals("Green"))
            {
                name = GREEN_NAME[rand.nextInt(1)];
                path.addSpace(new GreenSpace(name));
            }
            else
            {
                path.addSpace(new Space(color));
            }
        }
        path.addSpace(new MagentaSpace("Retirement"));

        return path;
    }

    /**
     * generates players
     */
    public void generatePlayers()
    {
        for(int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("P" + i));
        }
    }

    /**
     * gets current Player
     * @return current Player
     */
    public Player getCurrentPlayer()
    {
        // its either the last index of players, or the player index (if correct)
        return players.get(Math.min(players.size() - 1, playerIndex));
    }

    /**
     * increments player turn
     */
    public void incrementPlayerIndex() {
        if(playerIndex != getNumberOfPlayers()) {
            playerIndex++;
        }
        if(playerIndex >= getNumberOfPlayers()) {
            playerIndex = 0;
        }
    }

    /**
     * gets other players
     * @return players that does not have the turn
     */
    public ArrayList<Player> getOtherPlayer()
    {
        int i = 0;
        ArrayList<Player> otherPlayers = new ArrayList<>();
        for (Player p : players)
        {
            if (!p.equals(getCurrentPlayer()))
                otherPlayers.add(p);
        }
        return otherPlayers;
    }

    /**
     * gets next Player
     * @return next player
     */
    public Player getNextPlayer()
    {
        return getOtherPlayer().remove(0);
    }

    /**
     * get starting Path
     * @return starting path
     */
    public Path getStartingCareerPath() {
        return startingCareerPath;
    }

    /**
     * gets college Path
     * @return college Path
     */
    public Path getStartingCollegePath() {
        return startingCollegePath;
    }

    /**
     * returns action deck
     * @return action deck
     */
    public ActionCard getActions() {
        return actions;
    }

    /**
     * returns deck of BlueCards
     * @return blue deck
     */
    public BlueDeck getBlues() {
        return blues;
    }

    /**
     * returns careerDeck
     * @return deck of careers
     */
    public CareerDeck getCareers() {
        return careers;
    }

    /**
     * returns salarydeck
     * @return Salarydeck
     */
    public SalaryDeck getSalaries() {
        return salaries;
    }

    /**
     * returns deck of houses
     * @return deckof houses
     */
    public HouseDeck getHouses() {
        return houses;
    }

    /**
     * returns number of players
     * @return number of players
     */
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     * returns active players
     * @return active players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * returns retired players
     * @return  retired players
     */
    public ArrayList<Player> getRetired() {
        return retired;
    }

    /**
     * retires player
     * @param p is the player to be retired
     */
    public void retirePlayer(Player p)
    {
        p.retire(getRetired().size() + 1);
        numberOfPlayers--;
    }

    /**
     * sorts retired by amount
     */
    public void sortRetired()
    {
        Player winner;

        retired.sort((p1, p2) -> p2.getBalance() - p1.getBalance());

        winner = retired.get(0);

        retired.add(0,winner);
    }
}
