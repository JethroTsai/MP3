package model;

public class MagentaSpace extends Space
{
    private String name;

    /**
     * instantiates the object
     * @param name name of space
     */
    public MagentaSpace(String name)
    {
        super("Magenta");
        this.name = name;
    }

    /**
     * marries player
     * @param p is the player
     */
    public void getMarried(Player p)
    {
        p.marry();
    }

    /**
     * returns name of space
     * @return string
     */
    public String getName()
    {
        return name;
    }

}