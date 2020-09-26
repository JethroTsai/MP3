package model;

import java.util.*;

public class BlueCard extends Card
{
    private String job;
    

    public BlueCard(String name, String job)
    {
        super(name);
        this.job = job;
    }

    public String getJob()
    {
        return job;
    }

    public boolean checkCareer(String job, Career cob)
    {
        return job.equalsIgnoreCase(cob.getName()) ;
    }

    public int lawsuit()
    {
        Random rand = new Random();
        int upperbound = 10;

        int int_random = rand.nextInt(upperbound) + 5;         

        return int_random * 10000;
    }

    public int taxDue(Player player)
    {
        return player.getSalary().getTax();
    }

    public int tipServer()
    {
        Random rand = new Random();

        return (rand.nextInt(10) + 1) * 1000;
    }
    
    public int skiAcc()
    {
        return 10000;
    }

    public int compRepair()
    {
        Random rand = new Random();

        if ((rand.nextInt(10) + 1) % 2 == 0)
            return 5000;
        else
            return 10000;
    }

    public int worldCup()
    {
        return 5000;
    }

    public int f1Race(Player player)
    {
        return player.getSalary().getAmount() / 10;
    }
}