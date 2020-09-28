package model;

import java.util.*;

public class BlueCard extends Card
{
    private String job;

    /**
     * insatntiates the object
     * @param name is the name of the Card
     * @param job is the name of the job
     */
    public BlueCard(String name, String job)
    {
        super(name);
        this.job = job;
    }

    /**
     * returns the name of the job associated with the card
     * @return
     */
    public String getJob()
    {
        return job;
    }

    /**
     * checks career
     * @param job is the name of the job
     * @param cob is the Career Object to be compared
     * @return boolean
     */
    public boolean checkCareer(String job, Career cob)
    {
        return job.equalsIgnoreCase(cob.getName()) ;
    }

    /**
     * rolls a random number and multiplies it by 10000
     * @return amount to be paid
     */
    public int lawsuit()
    {
        Random rand = new Random();
        int upperbound = 10;

        int int_random = rand.nextInt(upperbound) + 5;         

        return int_random * 10000;
    }

    /**
     * returns the tax of the player to be paid
     * @param player is the player object
     * @return tax of player
     */
    public int taxDue(Player player)
    {
        return player.getSalary().getTax();
    }

    /**
     * rolls a number from 1-10 and multiplies it by 1000 and returns it
     * @return the value generated
     */
    public int tipServer()
    {
        Random rand = new Random();

        return (rand.nextInt(10) + 1) * 1000;
    }

    /**
     * returns 10000 to be payed by the player
     * @return
     */
    public int skiAcc()
    {
        return 10000;
    }

    /**
     * generates random number and checks if it is odd or even, if it is odd return 10000, 5000 otherwise
     * @return
     */
    public int compRepair()
    {
        Random rand = new Random();

        if ((rand.nextInt(10) + 1) % 2 == 0)
            return 5000;
        else
            return 10000;
    }

    /**
     * returns 5000
     * @return 5000 to be payed by the player
     */
    public int worldCup()
    {
        return 5000;
    }

    /**
     * gets player's salary and returns the value
     * @param player is the player object
     * @return the salary of the player
     */
    public int f1Race(Player player)
    {
        return player.getSalary().getAmount() / 10;
    }
}