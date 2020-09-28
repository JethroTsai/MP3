package model;

abstract public class Card {
    private String name;

    /**
     * instantiates the Card
     * @param name is the name of the card
     */
    public Card(String name) {
        this.name = name;
    }

    /**
     * gets name of the card
     * @return name of Card
     */
    public String getName() {
        return name;
    }
}
