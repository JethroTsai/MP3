package model;

import java.util.*;

public class CareerDeck extends Deck
{
    private ArrayList<Career> careers;
    private Random rand = new Random(); 
    private static final String[] CAREER_NAMES={"Doctor","Lawyer","Accountant","Computer Consultant","Server","Racecar Driver","Athlete"};
    Scanner kb= new Scanner(System.in);

    public CareerDeck()
    {
        careers = new ArrayList<> ();
    }

    @Override
    public void generate()
    {
        String name = "";
        boolean degree = true;
        int raises = 0;
        int min = 0;
        int max = 0;
        
        for (int i = 0; i < CAREER_NAMES.length; i++)
        {
            name= CAREER_NAMES[i];
            
            switch(i)
            {
                case 0: 
                case 1: min = 5;
                        max = 8;
                        break;
                case 2: min = 4;
                        max = 7;
                        break;
                case 3: min = 3;
                        max = 7;
                        break;
                case 4: min = 1;
                        max = 4;
                        degree = false;
                        break;
                case 5: min = 2;
                        max = 8;
                        degree = false;
                        break;
                case 6: min = 1;
                        max = 6;
                        degree = false;
                        break;
            }

            raises = rand.nextInt(max - min) + min;

            careers.add(new Career(name,degree,raises));
        }   
        this.shuffleCards();
    }

    @Override
    public void shuffleCards()
    {
        Collections.shuffle(careers);
    }

    public int getCareerCard(Player p)
    {
        int i = 0;
        
        if (!p.hasDegree())//career path
        {
            while(careers.get(i).reqDegree())
                   i++; 
        }

        return i;
    }

    public int chooseCareer(Player p)
    {
        int i = 0;
        
        if (!p.hasDegree())//job search
        {
            while(careers.get(i).reqDegree())
                i++;
        }
        else
        {
            if (p.getCareer() == null)//college career choice
            {
                System.out.println("1: " + careers.get(0).getName() + " raises: " + careers.get(0).getRaises());
                System.out.println("2: " + careers.get(1).getName() + " raises: " + careers.get(1).getRaises());
                System.out.print(p.getName() + " Choose the number of the model.Career you want: ");
                i = kb.nextInt() - 1;
                
            }
            else//job search
            {
                i = 0;
            }
        }
        return i;
    }

    public void assign(Player p)
    {
        int i = 0;
        int ans = 0;
        if (p.getCareer() != null)//player already have career
        {
            i = chooseCareer(p);
            System.out.println("new Career: " + careers.get(i).getName() + " raises: " + careers.get(i).getRaises());
            System.out.println("Do you want to change model.Career?, 1-YES 2-NO");
            ans = kb.nextInt();
            if (ans == 1)
            {
                returnCareer(p);
                p.setCareer(careers.remove(i));
            }
        }
        else
        {
            if (p.hasDegree())//college path
            {
                i = chooseCareer(p);
            }
            else//career path
            {
                i = getCareerCard(p);
            }
            p.setCareer(careers.remove(i));
        }
    }

    public void returnCareer(Player p)
    {
        careers.add(p.getCareer());
    }

    public Career[] getCareers() {
        return careers.toArray(new Career[0]);
    }
}
