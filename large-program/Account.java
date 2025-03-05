
public class Account {

    //OBJ01-J: Limit accessibility of fields
    private double balance = 0; 
    private StringBuilder fname; 
    private StringBuilder lname; 

    public Account(double balance, String fname, String lname){
        this.balance = balance; 
        this.fname = new StringBuilder(fname);
        this.lname = new StringBuilder(lname);
    }

    //OBJ04-J: Provide mutable classes with copy functionality to safely allow passing instances to untrusted code
    public Account(Account acct){

        Account.Transaction transaction = acct.new Transaction();
        this.balance = transaction.checkBalance();

        this.fname = new StringBuilder(acct.getFName().toString());
        this.lname = new StringBuilder(acct.getLName().toString());
    }


    private double getBalance(){
        return this.balance; 
    }

    private void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }

    private void withdraw(double amount){
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
