package model;

public class Career extends Card
{
    private boolean degree;
    private int raises;
    private int raiseCount;

    /**
     * instantiates card
     * @param name is the name of card
     */
    public Career(String name)
    {
        super(name);
    }

    /**
     * instantiates card
     * @param name is the name of the card
     * @param degree is the degree of card
     * @param raises is the number of raises of the card
     */
    public Career(String name, boolean degree, int raises)
    {
        super(name);
        this.degree = degree;
        this.raises = raises;
    }

    /**
     * returns raises of the card
     * @return raises
     */
    public int getRaises()
    {
        return raises;
    }

    /**
     * checks if card can still raise
     * @return boolean condition
     */
    public boolean canRaise()
    {
        return raiseCount < raises;
    }

    /**
     * checks if card requires degree
     * @return boolean condition
     */
    public boolean reqDegree()
    {
        return degree;
    }

    /*@Override
    public boolean equals(Object cob)
    {
        return ((Career)cob).getName().equalsIgnoreCase(getName());

    }*/

    /**
     * return Card to String
     * @return string based on the attributes of the card
     */
    @Override
    public String toString() {
        return "name = " + getName() +
                ", degree = " + degree +
                ", raises = " + raises +
                ", raiseCount = " + raiseCount;
    }
}