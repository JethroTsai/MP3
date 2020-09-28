package model;

import java.util.*;

public class ActionCard extends Deck
{
    private ArrayList<Action> actions;
    private static final String[] COLB_NAMES = {"Tax Refund", "Sell an Item", "Bonus Payday", "Setup School", "Write Book"};
    private static final String[] PAYB_NAMES = {"Buy an Item", "Visit a Place", "Hiking", "Watch a Show", "Win a Competition", "Traffic Violation"};
    private static final String[] PAYP_NAMES = {"Lawsuit", "Christmas Bonus"};
    private static final String[] COLP_NAMES = {"File a Lawsuit", "It's Your Birthday"};
    private Random rand = new Random(); 
    int count;
    final int MAX = 50;
   /**
    * Instantiates an Array List of actions
    */
    public ActionCard()
    {
         actions = new ArrayList<> ();
    }  
    /**
     * generates actions and stores inside the ArrayList of actions
     */
    @Override
    public void generate()
    {
        String type = "";
        String name = "";
        int amt = 0;
        int i = 0;
        int index;

        while (i < MAX)
        {
            if (i < MAX * 0.4)
            { 
                type = "ColB";
                index = rand.nextInt(COLB_NAMES.length);
                name = COLB_NAMES[index];
                amt = (rand.nextInt(65) + 5) * 500;
            }
            else if (i < MAX * 0.8)
            {
                type = "PayB";
                index = rand.nextInt(PAYB_NAMES.length);
                name = PAYB_NAMES[index];
                amt = (rand.nextInt(65) + 5) * 500;
            }
            else if (i < MAX * 0.9)
            {
                type = "PayP";
                index = rand.nextInt(PAYP_NAMES.length);
                name = PAYP_NAMES[index];
                amt = (rand.nextInt(65) + 5) * 500;
             }
            else
            {
                type = "ColP";
                index = rand.nextInt(COLP_NAMES.length);
                name = COLP_NAMES[index];
                amt = (rand.nextInt(65) + 5) * 500;
            }
            actions.add(new Action(name, type, amt));
            i++;
        }
        this.shuffleCards();
    }
   /**
    * Resets the counter and shuffles the cards in the ArrayList
    */
    @Override
    public void shuffleCards()
    {
        count = 0;
        Collections.shuffle(actions);
    }

    /**
     * Displays all action cards generated
     * 
     * @return the whole set of action cards
     * 
     */
    public String showCards()
    {
        int i = 0;
        String set = new String();

        for (i = 0; i < MAX; i++)
        {
            Action act = actions.get(i);

            set += (i + 1) + ". " + act.toString() + "\n\n";
        }
        return set;
    }
    /**
     * executes the effect of the action card, this is for 2 players
     * @param p1 is the player who got the card
     * @param p2 is the player who can get affected by the card
     */
    public void execute(Player p1, Player p2)
    {
        if(count < MAX)
        {
            Action action = actions.get(0);
            
            String type = new String(action.getType());
    

            if(type.equals(new String("ColB")))
            {
                action.collectFromBank(p1);
            }

            else if(type.equals(new String("PayB")))
            {
                action.payBank(p1);
            }
            else if (type.equals(new String("PayP")) )
            {
                action.payPlayerAction(p1, p2);
            }
            else if (type.equals(new String("ColP")))
            {
                action.collectFromPlayer(p1, p2);
            }
            count++;
        }   
        if (hasFinishDeck())
        {
            shuffleCards();
        }    
    }
   /**
     * executes the effect of the action card, this is for 3 players
     * @param p1 is the player who got the card
     * @param p2 is the other player who can get affected by the card
     * @param p3 is the other player who can get affected by the card
     */
    public void execute(Player p1, Player p2, Player p3)
    {
        if (count < MAX)
        {
            Action action = actions.get(0);
            
            String type = new String(action.getType());
            String name = new String(action.getName());
            String userName = new String();
            //Scanner key = new Scanner(System.in);

            if(type.equals(new String("ColB")))
            {
                action.collectFromBank(p1);
            }
            else if(type.equals(new String("PayB")))
            {
                action.payBank(p1);
            }
            else if (type.equals(new String("PayP")))
            {
                if (name.equals(new String("Christmas Bonus")))
                {
                    action.payAllPlayer(p1, p2, p3);
                }
                else
                {
                    System.out.print(p1.getName() + " choose a player to pay a lawsuit: ");
                    //userName = key.nextLine();
                    if (userName.equalsIgnoreCase(p2.getName()))
                    {
                        action.payPlayerAction(p1, p2);
                        //System.out.print("\n\n"+ p1.getName() + " pays " + p2.getName() + " " + action.getAmount());
                    }
                    else if (userName.equalsIgnoreCase(p3.getName()))
                    {
                        action.payPlayerAction(p1, p3);
                        //System.out.print("\n\n"+ p1.getName() + " pays " + p3.getName() + " " + action.getAmount());
                    }
                    
                    //System.out.print("\n\n");
                } 
            }
            else if (type.equals(new String("ColP")))
            {

                if (name.equals(new String("It's Your Birthday")))
                {
                    action.collectFromAll(p1, p2, p3);
                }
                else
                {
                    System.out.print(p1.getName() + " choose a player to file a lawsuit: ");
                    //userName = key.nextLine();
                    if (userName.equalsIgnoreCase(p2.getName()))
                    {
                        action.collectFromPlayer(p1, p2);
                        //System.out.print("\n\n"+ p1.getName() + " collects " + action.getAmount()+ " from"+ p2.getName());
                    }
                    else if (userName.equalsIgnoreCase(p3.getName()))
                    {
                        action.collectFromPlayer(p1, p3);
                        //System.out.print("\n\n"+ p1.getName() + " collects " + action.getAmount() + " from" + p3.getName());
                    }

                    //System.out.print("\n\n");
                }     
            }
            count++;
        }
        if (hasFinishDeck())
        {
            shuffleCards();
        }
    }
    /**
     * checks if the deck is already finished
     * @return true if finished, false otherwise
     */
    public boolean hasFinishDeck()
    {
        return count == MAX;
    }

    /**
     * shows the top card but does not remove it from deck
     * @return actioncard on top of the deck
     */
    public Action showTop()
    {
        return actions.get(0);
    }
    /**
     *
     *
     *  shows the top card and removes from deck
     *   @return actioncard on top of the deck
     */
    public Action getTopCard()
    {
        Action act;

        act=actions.remove(0);
        actions.add(act);
        return act;

    }
}