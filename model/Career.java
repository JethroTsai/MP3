package model;

public class Career
{
    private String name;
    private boolean degree;
    private int raises;
    private int raiseCount;

    public Career(String name)
    {
        this.name = name;
    }

    public Career(String name, boolean degree, int raises)
    {
        this.name = name;
        this.degree = degree;
        this.raises = raises;
    }

    public String getName()
    {
        return name;
    }

    public int getRaises()
    {
        return raises;
    }

    public boolean canRaise()
    {
        return raiseCount < raises;
    }

    public boolean reqDegree()
    {
        return degree;
    }

    @Override
    public boolean equals(Object cob)
    {
        return ((Career)cob).name.equalsIgnoreCase(this.name);

    }
}