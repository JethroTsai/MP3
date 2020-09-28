package model;
import java.util.*;

public class Space
{
    private String color;
    private ArrayList<Player> players;

    /**
     * instantiates the object
     * @param color is the color of the object
     */
    public Space(String color)
    {
        this.color = color;
        players = new ArrayList<>();
    }

    /**
     * returns color of the space
     * @return color of the space
     */
    public String getColor()
    {
        return color;
    }

    /**
     * adds player to this space
     * @param p is the player to be added
     */
    public void addPlayer(Player p)
    {
        players.add(p);
    }

    /**
     * gets list of players that are inside this space
     * @return list of players
     */
    public ArrayList<Player> getPlayers()
    {
        return players;
    }
}
