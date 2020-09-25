package model;

public class GreenSpace extends Space
{
    private String name;

    public GreenSpace(String name)
    {
        super("Green");
        this.name = name;
    }

    public void giveSalary(Player p)
    {
        p.receive(p.getSalary().getAmount());
    }

    public void raiseSalary(Player p)
    {
        p.getSalary().increaseSal();
    }

    public String getName()
    {
        return name;
    }
}
