package model;

public class House extends Card
{
    private int price;
    private int worth;

    public House(String name, int price, int worth)
    {
        super(name);
        this.price = price;
        this.worth = worth;
    }

    public int getPrice()
    {
        return price;
    }

    public int getWorth()
    {
        return worth;
    }

    @Override
    public String toString() {
        return "price=" + price +
                ", worth=" + worth;
    }
}
