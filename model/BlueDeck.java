package model;

import java.util.*;
public class BlueDeck extends Deck
{
    private ArrayList<BlueCard> blueCards;
    private int count;
    private static final int MAX=7;
    public static final String[] BLUE_CARD_NAMES = {"Lawsuit", "TaxDue", "TipServer", "SkiAccident", "CompRepair", "WorldCup", "F1Race"};
    public static final String[] BLUE_CARD_JOBS = {"Lawyer", "Accountant", "Server", "Doctor", "Computer Consultant", "Athlete", "Racecar Driver"};

    public BlueDeck()
    {
        blueCards = new ArrayList<> ();
    }
    
    @Override
    public void generate()
    {
        for (int i = 0; i < MAX; i++)
        {
            blueCards.add(new BlueCard(BLUE_CARD_NAMES[i], BLUE_CARD_JOBS[i]));
        }
        this.shuffleCards();
    }

    @Override
    public void shuffleCards()
    {
        count = 0;
        Collections.shuffle(blueCards);
    }

    public void execute(Player p1, BlueCard blue)
    {
        if(blue.checkCareer(blue.getJob(), p1.getCareer()))
        {
            System.out.println(p1.getName() + " gets 15k ");
            p1.receive(15000);
        }
        else
        {
            System.out.println(p1.getName() + " pays the bank");

            if (blue.getName().equalsIgnoreCase("lawsuit")) p1.pay(blue.lawsuit());
            else if (blue.getName().equalsIgnoreCase("taxdue")) p1.pay(blue.taxDue(p1));
            else if (blue.getName().equalsIgnoreCase("tipServer")) p1.pay(blue.tipServer());
            else if (blue.getName().equalsIgnoreCase("skiAccident")) p1.pay(blue.skiAcc());
            else if (blue.getName().equalsIgnoreCase("compRepair")) p1.pay(blue.compRepair());
            else if (blue.getName().equalsIgnoreCase("worldCup")) p1.pay(blue.worldCup());
            else if (blue.getName().equalsIgnoreCase("f1Race")) p1.pay(blue.f1Race(p1));
        }
    }

    public void execute(Player p1, Player p2, BlueCard blue)
    {
        System.out.println(p1.getName() + " pays " + p2.getName());

        if (blue.getName().equalsIgnoreCase("lawsuit")) p1.payPlayer(blue.lawsuit(), p2);
        else if (blue.getName().equalsIgnoreCase("taxdue")) p1.payPlayer(blue.taxDue(p1), p2);
        else if (blue.getName().equalsIgnoreCase("tipServer")) p1.payPlayer(blue.tipServer(), p2);
        else if (blue.getName().equalsIgnoreCase("skiAccident")) p1.payPlayer(blue.skiAcc(), p2);
        else if (blue.getName().equalsIgnoreCase("compRepair")) p1.payPlayer(blue.compRepair(), p2);
        else if (blue.getName().equalsIgnoreCase("worldCup")) p1.payPlayer(blue.worldCup(), p2);
        else if (blue.getName().equalsIgnoreCase("f1Race")) p1.payPlayer(blue.f1Race(p1), p2);
    }

    public BlueCard getTopCard()
    {
        return blueCards.remove(0);
    }

    public void addCard(BlueCard blue)
    {
        blueCards.add(blue);
    }

    public boolean hasFinishDeck()
    {
        return count == MAX;
    }
}
