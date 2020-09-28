package model;

public class Player
{   
    private String name;
    private int balance;
    private Career career;
    private Salary salary;
    private int raiseCount;
    private boolean degree;
    private boolean married;
    private int loans;
    private int child;
    private House house;
    private static int count;
    private int space;
    private Path path;
    private boolean turn;
    private boolean retired = false;
    
    /** Creates a new player
     *
     *  @param name is the user's name
     *
     */
    public Player(String name)
    {
        this.name = name;
        this.balance = 200000;
    }

    /** makes the player pay , reduces the amount inside the player's balance
     *  if the player's balance does not statisfy the payment then he/she will recieve a loan
	 *
	 *  @param amount is the amount to be paid
	 *	
	 */
    public void pay(int amount)
    {   
        if (amount <= balance)
        {
            this.balance -= amount;
        }
        else
        {
            while (amount > balance)
            {
               loan();
            }

            this.balance-=amount;
        }
        
    }
    /** lets the player receive an amount , adds the amount inside the player's balance
	 *
	 *  @param amount is the amount to be received
	 *	
	 */
    public void receive (int amount)
    {
        this.balance+=amount;
    }
    /** makes the player pay another player , reduces the amount inside the payer's balance and add the amount to the receiver's
	 *
	 *  @param amount is the amount to be payed
     *  @param pob is the receiver
	 *	
	 */
    public void payPlayer(int amount, Player pob)
    {
        pay(amount);

        pob.receive(amount);
    }

    /**
     * buys house
     * @param house is the House card
     */
    public void buyHouse(House house)
    {
        pay(house.getPrice());
        this.house = house;
    }

    /**
     * sells house and receives the selling price
     */
    public void sellHouse()
    {
        if(house!=null)
        {
            this.balance += this.getHouse().getWorth();
            this.house = null;

        }

    }

    /**
     * marries the player
     */
    public void marry()
    {
        this.married = true;
    }

    /** allows the player pay loans, reduces the amount inside the payer's balance
     *
     *  @param num is the number of loans
     *
     *
     */
    public void payLoan(int num)
    {
        if (num <= loans)
        {
            loans -= num;
            this.balance -= 25000*num;
        }
    }

    /**
     * reset raises of player
     */
    public void resetRaises()
    {
        this.raiseCount = 0;
    }

    /**
     * graduates player
     */
    public void graduate()
    {
        degree=true;
    }

    /**
     * adds raises of player
     */
    public void addRaise()
    {
        this.raiseCount += 1;
        this.salary.increaseSal();
    }

    /**
     * borrow loan
     */
    public void loan()
    {
        this.loans++;
        receive(20000);
    }

    /** returns the balance of the user
     *
     * @return total  balance of the user
     *
     *
     */
    public int getBalance()
    {
        return balance;
    }
    
   /** returns the number of loans of the user
     *
     * @return total loans of the user
     *
     *
     */
    public int getLoans()
    {
        return loans;
    }

    /**
     * returns the name of player
     * @return name of player
     */
    public String getName()
    {
        return name;
    }

    /**
     * returns career of player
     * @return Career of player
     */
    public Career getCareer()
    {
        return career;
    }

    /**
     * returns salary of player
     * @return Salary of player
     */
    public Salary getSalary()
    {
        return salary;
    }

    /**
     * returns house of player
     * @return house of player
     */
    public House getHouse()
    {
        return house;
    }

    /**
     * returns space of player
     * @return current space of player
     */
    public int getSpace()
    {
        return space;
    }

    /**
     * returns path of player
     * @return current path of player
     */
    public Path getPath()
    {
        return path;
    }

    /**
     * sets career of player
     * @param c CareerCard
     */
    public void setCareer(Career c)
    {
        this.career = c;
    }

    /**
     * sets salary of player
     * @param s Salary Card
     */
    public void setSalary(Salary s)
    {
        this.salary = s;
    }

    /**
     * adds children to player
     */
    public void addChild()
    {
        this.child++;
    }

    /**
     * counts the number of children the player has and the player will receive
     * 10000*n , where in n is the number of children the player has
     */
    public void sellChild()
    {
        this.balance += (child * 10000);
        this.child = 0;
    }

    /**
     * adds 1 to space
     */
    public void addSpace()
    {
        this.space += 1;
    }

    /**
     * gets turn of player
     * @return turn of player
     */
    public boolean getTurn()
    {
        return turn;
    }

    /**
     * checks if player has degree
     * @return boolean
     */
    public boolean hasDegree()
    {
        return degree;
    }

    /**
     * checks if player is married
     * @return boolean
     */
    public boolean isMarried()
    {
       return married;
    }

    /**
     * sets path and resets spaces
     * @param path1 Path to be set
     */
    public void setPath(Path path1)
    {
        path=path1;
        space=0;
    }

    /**
     * retires player
     * @param place position where the player finishes
     * @return place of player
     */
    public int retire(int place)
    {
        this.retired = true;
        switch(place)
        {
            case 1 : this.receive(100000); break;
            case 2 : this.receive(50000); break;
            case 3 : this.receive(20000); break;
        }

        return place;
    }

    /**
     * returns retired status of player
     * @return boolean
     */
    public boolean isRetired()
    {
        return retired;
    }
}