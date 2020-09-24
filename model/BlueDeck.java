package model;

import java.util.*;
public class BlueDeck extends Deck
{
    private ArrayList<BlueCard> blueCards;
    private int count;
    private static final int MAX=7;
    public static final String[] BLUE_CARD_NAMES = {"Lawsuit", "TaxDue", "TipServer", "SkiAcc", "CompRepair", "WorldCup", "F1Race"};
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

    public void execute(Player p1, Player p2)
    {
        BlueCard blue = blueCards.get(count);
        if(blue.checkCareer(blue.getJob(), p1.getCareer()))
        {
             System.out.println(p1.getName() + " gets 15k ");
             p1.receive(15000);
        }
        else if(blue.checkCareer(blue.getJob(), p2.getCareer()))
        {
            System.out.println(p1.getName() + " pays " + p2.getName());

            if (blue.getName().equals("lawsuit")) p1.payPlayer(blue.lawsuit(), p2);
            else if (blue.getName().equals("taxdue")) p1.payPlayer(blue.taxDue(p1), p2);
            else if (blue.getName().equals("tipServer")) p1.payPlayer(blue.tipServer(), p2);
            else if (blue.getName().equals("skiAcc")) p1.payPlayer(blue.skiAcc(), p2);
            else if (blue.getName().equals("compRepair")) p1.payPlayer(blue.compRepair(), p2);
            else if (blue.getName().equals("worldCup")) p1.payPlayer(blue.worldCup(), p2);
            else if (blue.getName().equals("f1Race")) p1.payPlayer(blue.f1Race(p1), p2);
        }
        else
        {
            System.out.println(p1.getName() + " pays the bank");

            if (blue.getName().equals("lawsuit")) p1.pay(blue.lawsuit());
            else if (blue.getName().equals("taxdue")) p1.pay(blue.taxDue(p1));
            else if (blue.getName().equals("tipServer")) p1.pay(blue.tipServer());
            else if (blue.getName().equals("skiAcc")) p1.pay(blue.skiAcc());
            else if (blue.getName().equals("compRepair")) p1.pay(blue.compRepair());
            else if (blue.getName().equals("worldCup")) p1.pay(blue.worldCup());
            else if (blue.getName().equals("f1Race")) p1.pay(blue.f1Race(p1));
        }

    }

    
    

    public boolean hasFinishDeck()
    {
        return count == MAX;
    }
}
