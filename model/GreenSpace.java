package model;

public class GreenSpace extends Space
{
    private String name;

    /**
     * instantiates the GreenSpace
     * @param name name of the space
     */
    public GreenSpace(String name)
    {
        super("Green");
        this.name = name;
    }

    /**
     * Gives salary amount to player
     * @param p is the Player
     */
    public void giveSalary(Player p)
    {
        p.receive(p.getSalary().getAmount());
    }

    /**
     * raises salary of player
     * @param p is the player
     */
    public void raiseSalary(Player p)
    {
        p.getSalary().increaseSal();
    }

    /**
     * gets name of the space
     * @return name of the green space
     */
    public String getName()
    {
        return name;
    }
}
