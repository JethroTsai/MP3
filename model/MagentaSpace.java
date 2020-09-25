package model;

public class MagentaSpace extends Space
{
    private String name;

    public MagentaSpace(String name)
    {
        super("Magenta");
        this.name = name;
    }

    public void getMarried(Player p)
    {
        p.marry();
    }

    public String getName()
    {
        return name;
    }

}