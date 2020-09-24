import java.util.*;

public class SalaryDeck extends Deck
{
    private ArrayList<Salary> salaries;
    private Random rand = new Random(); 
    private int nCards;

    public SalaryDeck()
    {
        salaries = new ArrayList <> ();
    }

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

    @Override
    public void shuffleCards()
    {
        Collections.shuffle(salaries);
    }

    public void assign(Player p)
    {
        if (p.hasDegree())
        {
            this.showCard();
            this.showCard();
        }
        else
        {
            this.showCard();
        }
        if (p.getSalary() != null)
            salaries.add(p.getSalary());
        p.setSalary(salaries.remove(0));
    }

    public void showCard()
    {
        System.out.println("Salary: " + salaries.get(0).getAmount() + " Tax: " + salaries.get(0).getTax());
    }
}
