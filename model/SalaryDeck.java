package model;

import java.util.*;

public class SalaryDeck extends Deck
{
    private ArrayList<Salary> salaries;
    private Random rand = new Random(); 
    private int nCards;

    /**
     * instantiates object
     */
    public SalaryDeck()
    {
        salaries = new ArrayList <> ();
    }

    /**
     * generates cards
     */
    @Override
    public void generate()
    {
        int i=0;
        int amount=0;
        int tax=0;

        nCards = rand.nextInt(10) + 10;
        for(i=0;i<nCards;i++)
        {
            amount = (rand.nextInt(4) + 1) * 10000;
            tax = (rand.nextInt(9) + 1) * 1000;

            salaries.add(new Salary(amount, tax));
        }
        this.shuffleCards();

    }

    /**
     * shuffles cards
     */
    @Override
    public void shuffleCards()
    {
        Collections.shuffle(salaries);
    }

    public Salary[] getSalaries() {
        return salaries.toArray(new Salary[0]);
    }

    /**
     * returns and removes card
     * @return top card of the deck
     */
    public Salary getTopCard()
    {
        return salaries.remove(0);
    }

    /**
     * returns arrayList of SalaryCards
     * @return ArrayList of Salary cards
     */
    public ArrayList<Salary> getListSalary()
    {
        return salaries;
    }
}
