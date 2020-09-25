package model;
import java.util.*;

public class Space
{
    private String color;
    private ArrayList<Player> players;

    public Space(String color)
    {
        this.color = color;
        players = new ArrayList<>();
    }

    public String getColor()
    {
        return color;
    }

    public void addPlayer(Player p)
    {
        players.add(p);
    }

    public void clearPlayer()
    {
        players.clear();
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }


}
