package model;

public class House extends Card
{
    private int price;
    private int worth;

    /**
     * instantiates the house
     * @param name is the name of house
     * @param price is the buying price
     * @param worth is the selling prices
     */
    public House(String name, int price, int worth)
    {
        super(name);
        this.price = price;
        this.worth = worth;
    }

    /**
     * returns price of the house
     * @return price of the house
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * returns selling Price
     * @return price of the house
     */
    public int getWorth()
    {
        return worth;
    }

    /**
     * returns strign of house object
     * @return  string
     */
    @Override
    public String toString() {
        return "price=" + price +
                ", worth=" + worth;
    }
}
