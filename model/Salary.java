package model;

public class Salary extends Card
{
    private int amount;
    private int tax;
    private final int RAISE = 10000;

    /**
     * instantiates the object
     * @param amount is amount of the Salary
     * @param tax is the tax of the Salary
     */
    public Salary(int amount, int tax)
    {
        super(null);
        this.amount = amount;
        this.tax = tax;
    }

    /**
     * increases salary
     */
    public void increaseSal()
    {
        amount+=RAISE;
        tax+=(RAISE/10);
    }

    /**
     * gets amount indicated
     * @return amount in salary
     */
    public int getAmount()
    {
        return amount;
    }

    /**
     * gets tax indicated
     * @return tax in Salary
     */
    public int getTax()
    {
        return tax;
    }

    /**
     * returns the object to String
     * @return to String of object
     */
    @Override
    public String toString() {
        return "amount=" + amount +
                ", tax=" + tax +
                ", raise=" + RAISE;
    }
}
