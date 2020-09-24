import model.*;

public class DriverClass
{
    public static void main(String [] args)
    {
        
        Player p1;
        Player p2;
        Player p3;
        
        int players;
        String name= new String();

        ActionCard actions = new ActionCard();
        actions.generate();
        System.out.print(actions.showCards());

        SalaryDeck salaries = new SalaryDeck();
        salaries.generate();
        
        CareerDeck careers = new CareerDeck();
        careers.generate();

        BlueDeck blueCards = new BlueDeck();
        blueCards.generate();

       
        p1 = new Player("1");
        p2 = new Player("2");
        
        p2.graduate();

        salaries.assign(p1);
        careers.assign(p1);
        salaries.assign(p2);
        careers.assign(p2);

        
        System.out.println(p1.getCareer().getName() + " " + p1.getSalary().getAmount());
        System.out.println(p2.getCareer().getName() + " " + p2.getSalary().getAmount());



        /*else
        {
            System.out.print("Input name for player 1(Doctor):");
            name=kb.nextLine();
            p1 = new model.Player(name,"Doctor");
            
            System.out.print("Input name for player 2(Lawyer):");
            name=kb.nextLine();
            p2 = new model.Player(name,"Lawyer");
            
            System.out.print("Input name for player 3(Accountant):");
            name=kb.nextLine();
            p3 = new model.Player(name,"Accountant");

            while (!actions.hasFinishDeck())
            {
                actions.execute(p1, p2, p3);
                System.out.println("p1: " + p1.getBalance() + " p2: " + p2.getBalance() + " p3: " + p3.getBalance() + "\n" );
                actions.execute(p2, p1, p3);
                System.out.println("p1: " + p1.getBalance() + " p2: " + p2.getBalance() + " p3: " + p3.getBalance() + "\n" );
                actions.execute(p3, p1, p2);
                System.out.println("p1: " + p1.getBalance() + " p2: " + p2.getBalance() + " p3: " + p3.getBalance() + "\n" );
            }
            System.out.println(p1.getBalance());
            System.out.println(p2.getBalance());
            System.out.println(p3.getBalance());
            if (p1.getBalance() > p2.getBalance() && p1.getBalance() > p3.getBalance())
            {
                System.out.println(p1.getName() +  " Wins!!");
            }
            else if(p2.getBalance() < p1.getBalance() && p2.getBalance() > p3.getBalance())
            {
                System.out.println(p2.getName() +  " Wins!!");
            }
            else if (p3.getBalance() > p1.getBalance() && p3.getBalance() > p2.getBalance())
            {
                System.out.println(p3.getName() + " Wins!!");
            }
            else
            {
                System.out.println("It's a tie!!");
            }
        }

        kb.close();*/





        
        /*model.Player p1 = new model.Player("one" , "driver");
        model.Player p2 = new model.Player("two", "doctor");
        model.Player p3 = new model.Player("three", "lawyer");

        model.ActionCard a = new model.ActionCard();
        System.out.println(p1.getBalance());
        System.out.println(p2.getBalance());

        p1.pay(210000);
        System.out.println(p1.getBalance());
        System.out.println(p1.getLoans());
        p1.receive(200000);
        System.out.println(p1.getBalance());

        p1.payPlayer(230000,p2);
        System.out.println(p1.getBalance());
        System.out.println(p2.getBalance());
        System.out.println(p1.getLoans());
        p1.receive(400000);
        p1.payLoan(2);
        System.out.println(p1.getBalance());
        
        a.generate();
        a.shuffleCards();
        System.out.print(a.showCards());
        a.execute(p1, p2, p3);
        a.execute(p2, p1, p3);
        a.execute(p3, p2, p1);
        System.out.println(p1.getBalance());
        System.out.println(p2.getBalance());
        System.out.println(p3.getBalance());
        */
        

    }    
}