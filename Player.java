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
    
    /** Creates a new player
     *
     *  @param name is the user's name
     *  @param career is the career assigned to the user
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
                balance += 20000;
                loans++;
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

    public void buyHouse(House house)
    {
        this.balance -= house.getPrice();
        this.house = house;
    }

    public void sellHouse()
    {
        this.balance += this.getHouse().getWorth();
        this.house = null;
    }

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

    public void resetRaises()
    {
        this.raiseCount = 0;
    }

    public void graduate()
    {
        degree=true;
    }

    public void addRaise()
    {
        this.raiseCount += 1;
        this.salary.increaseSal();
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
     /** returns the name of the user
     *
     * @return name of the user
     *
     *
     */
    public String getName()
    {
        return name;
    }

    public Career getCareer()
    {
        return career;
    }

    public Salary getSalary()
    {
        return salary;
    }

    public House getHouse()
    {
        return house;
    }

    public int getSpace()
    {
        return space;
    }
   
    public void setCareer(Career c)
    {
        this.career = c;
    }

    public void setSalary(Salary s)
    {
        this.salary = s;
    }

    

    public boolean hasDegree()
    {
        return degree;
    }

    public boolean isMarried()
    {
       return married;
    }
    
    public int retire(int place)
    {
        return place;
    }
}