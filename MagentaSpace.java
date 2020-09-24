public class MagentaSpace extends Space
{
    private String name;

    public MagentaSpace(String name, int spaceNum)
    {
        super("Magenta", spaceNum);
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