package model;

import java.util.*;

public class HouseDeck
{
    private ArrayList<House> houses;
    private final static String[] HOUSE_NAMES = {"Apartment", "Condo", "Mansion", "Beach House"};

    public HouseDeck()
    {
        houses = new ArrayList<>();
    }

    public void generate()
    {
        Random rand = new Random();
        int price;
        int worth;
        for (int i = 1; i <= 4; i++)
        {
            price = (rand.nextInt(15) + 20 * i) * 10000;
            worth = (rand.nextInt(20) + 40 * i) * 10000;
            houses.add(new House(HOUSE_NAMES[i - 1], price, worth));
        }
    }

    public ArrayList<House> getHouses()
    {
        return houses;
    }
}
