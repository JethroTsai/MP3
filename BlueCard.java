  import java.util.*;

public class BlueCard
{
    private String name;
    private String job;
    

    public BlueCard(String name, String job)
    {
        this.name = name;
        this.job = job;
    }

    public String getName()
    {
        return name;
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
        return 1000;
    }
    
    public int skiAcc()
    {
        return 10000;
    }

    public int compRepair()
    {
        return 5000;
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