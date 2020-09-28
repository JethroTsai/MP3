package model;

public abstract class Deck
{
    /**
     * generates card ,to be implemented by subclasses
     */
    public abstract void generate();

    /**
     * shuffles cards to be implemented
     */
    public abstract void shuffleCards();
}
