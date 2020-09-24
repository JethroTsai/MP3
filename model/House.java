package model;

public class House
{
    private String name;
    private int price;
    private int worth;

    public House(String name, int price, int worth)
    {
        this.name = name;
        this.price = price;
        this.worth = worth;
    }

    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }

    public int getWorth()
    {
        return worth;
    }
}
