public class Action
{
    private String name;
    private String type;
    private int amount;
    /**
     * Creates the action
     * 
     * @param name is the name of the action
     * @param type is the type of action
     * @param amount is the amount given to the action
     */
    public Action(String name, String type, int amount)
    {
        this.name = name;
        this.type = type;
        this.amount = amount;
    }
   /**
    * gets the action name
    * 
    * @return name of the card
    */
    public String getName()
    {
        return name;
    }
   /**
    * gets the type of the action 
    * 
    * @return type of the card
    */
    public String getType()
    {
        return type;
    }
   /**
    * gets the amount of the action 
    * 
    * @return amount of the card
    */
    public int getAmount()
    {
        return amount;
    }
   /**
    * makes the player collect money from the bank
    * @param p1 is the player who received the action
    */
    public void collectFromBank(Player p1)
    {
        p1.receive(this.amount);
    }
   /**
    * makes the player pay money to the bank
    * @param p1 is the player who received the action
    */
    public void payBank(Player p1)
    {
        p1.pay(this.amount);
    }
   /**
    * makes the player collect money from another player
    * @param collector is the player who received the action
    * @param payer is the player who will pay
    */
    public void collectFromPlayer(Player collector, Player payer)
    {
        payer.payPlayer(amount, collector);
    }
    /**
    * makes the player collect money from all players, this is for three players
    * @param collector is the player who received the action
    * @param payer1 is the player who will pay
    * @param payer2 is the player who will pay
    */
    public void collectFromAll(Player collector, Player payer1, Player payer2)
    {
        payer1.payPlayer(amount, collector);
        payer2.payPlayer(amount, collector);
    }
    /**
    * makes the player pay another player
    * @param payer is the player who received the action
    * @param collector is the player who will receive the money
    */
    public void payPlayerAction(Player payer, Player collector)
    {
        payer.payPlayer(amount, collector);
    }
    /**
    * makes the player pay all players
    * @param payer is the player who received the action
    * @param collector1 is the player who will receive the money
    * @param collector2 is the player who will receive the money
    */
    public void payAllPlayer(Player payer, Player collector1, Player collector2)
    {
        payer.payPlayer(amount, collector1);
        payer.payPlayer(amount, collector2);
    }
    /**
     * returns the card info into string
     * @return the card name and amount
     */
    @Override
    public String toString() 
    {
       return name + "- " +  amount;
    }

    
}