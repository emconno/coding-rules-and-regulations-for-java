
public class Account implements Cloneable{

    //OBJ01-J: Limit accessibility of fields
    private double balance = 0; 
    private StringBuilder fname; 
    private StringBuilder lname; 

    public Account(double balance, StringBuilder fname, StringBuilder lname){
        this.balance = balance; 
        this.fname = new StringBuilder(fname);
        this.lname = new StringBuilder(lname);
    }

    public Object clone() throws CloneNotSupportedException {
        final Account clone = (Account) super.clone();
        clone.outputBalance();
        return clone;
    }

    //OBJ04-J: Provide mutable classes with copy functionality to safely allow passing instances to untrusted code
    public Account(Account acct){

        Account.Transaction transaction = acct.new Transaction();
        this.balance = transaction.checkBalance();

        this.fname = new StringBuilder(acct.getFName().toString());
        this.lname = new StringBuilder(acct.getLName().toString());
    }

    //MET06-J: Do not invoke overridable methods in clone (add final to superclass method declarations)
    public final void outputBalance(){
        System.out.println("Balance: " + this.balance);
    }


    private final double getBalance(){
        return this.balance; 
    }

    private final void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }

    private final void withdraw(double amount){
        if(amount > 0 && balance >= amount){
            balance -= amount;
        }
    }
    
    //OBJ08-J: Do not expose private members of an outer class from within a nested class.
    public class Transaction{
        public void processDeposit(double amount){
            deposit(amount);
        }

        public void processWithdrawal(double amount){
            withdraw(amount);
        }

        public double checkBalance(){
            return getBalance();
        }
    }

    //OBJ05-J: Do not return references to private mutable class members
    public StringBuilder getFName(){
        return new StringBuilder(this.fname);
    }

    public StringBuilder getLName(){
        return new StringBuilder(this.lname);
    }

    

}
