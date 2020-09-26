package model;

public class Career extends Card
{
    private boolean degree;
    private int raises;
    private int raiseCount;

    public Career(String name)
    {
        super(name);
    }

    public Career(String name, boolean degree, int raises)
    {
        super(name);
        this.degree = degree;
        this.raises = raises;
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
        return ((Career)cob).getName().equalsIgnoreCase(getName());

    }

    @Override
    public String toString() {
        return "name=" + getName() +
                ", degree=" + degree +
                ", raises=" + raises +
                ", raiseCount=" + raiseCount;
    }
}