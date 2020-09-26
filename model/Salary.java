package model;

public class Salary extends Card
{
    private int amount;
    private int tax;
    private final int RAISE = 10000;

    public Salary(int amount, int tax)
    {
        super(null);
        this.amount = amount;
        this.tax = tax;
    }

    public void increaseSal()
    {
        amount+=RAISE;
        tax+=(RAISE/10);
    }

    public int getAmount()
    {
        return amount;
    }

    public int getTax()
    {
        return tax;
    }

    @Override
    public String toString() {
        return "amount=" + amount +
                ", tax=" + tax +
                ", raise=" + RAISE;
    }
}
