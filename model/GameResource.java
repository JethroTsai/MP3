package model;

import java.util.*;

public class GameResource
{
    private static final String[] COLORS = {"Orange", "Blue", "Green", "Magenta"};
    private static final String[] GREEN_NAME = {"Pay Day", "Pay Raise"};
    private static final String[] MAGENTA_NAME = {"Have Baby or Twins", "Buy a House"};
    private Path startingCollegePath;
    private Path startingCareerPath;

    public GameResource()
    {

    }

    public Deck generateActionCard()
    {
        Deck actions = new ActionCard();

        actions.generate();
        return actions;
    }

    public Deck generateBlueDeck()
    {
        Deck blueDeck = new BlueDeck();

        blueDeck.generate();
        return blueDeck;
    }

    public Deck generateCareerDeck()
    {
        Deck careerDeck = new CareerDeck();

        careerDeck.generate();
        return careerDeck;
    }

    public Deck generateSalaryDeck()
    {
        Deck salaries = new SalaryDeck();

        salaries.generate();
        return salaries;
    }

    public void generateBoard() {
    }

    public Path generateCollegePath(Path nextPath)
    {
        Path path = new Path(nextPath);
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
        Path path = new Path(nextPath);
        String color = new String();
        String name = new String();

        path.addSpace(new MagentaSpace("Job Search"));
        for (int i = 1; i < 10; i++)
        {
            Random rand = new Random();
            color = COLORS[rand.nextInt(2)];
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
        path.addSpace(new MagentaSpace("Get Married"));

        return path;
    }


    public Path generateNormalPath(Path path1, Path path2)
    {
        Path path = new Path(path1,path2);
        String color = new String();
        String name = new String();

        for (int i = 1; i < 30; i++)
        {
            Random rand = new Random();
            color = COLORS[rand.nextInt(2)];
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
        path.addSpace(new MagentaSpace("Which Path"));

        return path;
    }

    public Path generateFamilyPath(Path nextPath)
    {
        Path path = new Path(nextPath);
        String color = new String();
        String name = new String();

        path.addSpace(new MagentaSpace("Get Married"));
        for (int i = 1; i < 15; i++)
        {
            Random rand = new Random();
            color = COLORS[rand.nextInt(3)];
            if (color.equals("Green"))
            {
                name = GREEN_NAME[rand.nextInt(1)];
                path.addSpace(new GreenSpace(name));
            }
            else if (color.equals("Magenta"))
            {
                name = MAGENTA_NAME[rand.nextInt(1)];
                path.addSpace(new MagentaSpace(name));
            }
            else
            {
                path.addSpace(new Space(color));
            }
        }

        return path;
    }

    public Path generateChangeCareerPath(Path nextPath)
    {
        Path path = new Path(nextPath);
        String color = new String();
        String name = new String();
        int num;

        path.addSpace(new MagentaSpace("Job Search"));
        for (int i = 1; i < 30; i++)
        {
            Random rand = new Random();
            num = rand.nextInt(4);
            if (num >= 2)
            {
                color = COLORS[2];
                name = GREEN_NAME[rand.nextInt(1)];
                path.addSpace(new GreenSpace(name));
            }
            else
            {
                path.addSpace(new Space(color));
            }
        }

        return path;
    }

    public Path generateRetirement()
    {
        Path path = new Path();
        String color = new String();
        String name = new String();

        for (int i = 1; i < 30; i++)
        {
            Random rand = new Random();
            color = COLORS[rand.nextInt(2)];
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

    public Path getStartingCareerPath() {
        return startingCareerPath;
    }

    public Path getStartingCollegePath() {
        return startingCollegePath;
    }
}
