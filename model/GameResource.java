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

    public GameResource(int numberOfPlayers)
    {
        this.numberOfPlayers = numberOfPlayers;
        players = new ArrayList<>();

        generatePlayers();
        actions = generateActionCard();
        blues = generateBlueDeck();
        careers = generateCareerDeck();
        salaries = generateSalaryDeck();
        houses = generateHouseDeck();
        generateBoard();
    }

    public ActionCard generateActionCard()
    {
        ActionCard actions = new ActionCard();

        actions.generate();
        return actions;
    }

    public BlueDeck generateBlueDeck()
    {
        BlueDeck blueDeck = new BlueDeck();

        blueDeck.generate();
        return blueDeck;
    }

    public CareerDeck generateCareerDeck()
    {
        CareerDeck careerDeck = new CareerDeck();

        careerDeck.generate();
        return careerDeck;
    }

    public SalaryDeck generateSalaryDeck()
    {
        SalaryDeck salaries = new SalaryDeck();

        salaries.generate();
        return salaries;
    }

    public HouseDeck generateHouseDeck()
    {
        HouseDeck houses = new HouseDeck();

        houses.generate();
        return houses;
    }

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

    public void generatePlayers()
    {
        for(int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("P" + i));
        }
    }

    public Player getCurrentPlayer()
    {
        return players.get(playerIndex);
    }

    public void incrementPlayerIndex() {
        playerIndex++;
        if(playerIndex == getNumberOfPlayers()) {
            playerIndex = 0;
        }
    }

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

    public Player getNextPlayer()
    {
        return getOtherPlayer().remove(0);
    }

    public Path getStartingCareerPath() {
        return startingCareerPath;
    }

    public Path getStartingCollegePath() {
        return startingCollegePath;
    }

    public ActionCard getActions() {
        return actions;
    }

    public BlueDeck getBlues() {
        return blues;
    }

    public CareerDeck getCareers() {
        return careers;
    }

    public SalaryDeck getSalaries() {
        return salaries;
    }

    public HouseDeck getHouses() {
        return houses;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Player> getRetired() {
        return retired;
    }
}
