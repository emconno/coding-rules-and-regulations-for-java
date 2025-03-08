/**
 * File that showcases a robust Bank Account program by following best security 
 * practices. 
 * @author Michael Rosenwinkel
 */

public class Account implements Cloneable{

    /**
     * Class that implements basic features of a Bank Account except that it follows
     * best security practices for its members.s
     * @author Michael Rosenwinkel
     */


    //OBJ01-J: Limit accessibility of fields
    private double balance = 0; 
    private StringBuilder fname; 
    private StringBuilder lname; 


    /**
     * Class constructor that ensures that parameters are not modified in the future
     * by creating new StringBuilder objects.
     * @param balance balance of the new bank account
     * @param fname first name StringBuilder
     * @param lname last name StringBuilder
     */
    public Account(double balance, StringBuilder fname, StringBuilder lname){
        this.balance = balance; 
        this.fname = new StringBuilder(fname);
        this.lname = new StringBuilder(lname);
    }

    /**
     * Clone method that ensures that no overridable methods are executed (potentially
     * leading to vulnerabilities or inconsistent state)
     */
    public Object clone() throws CloneNotSupportedException {
        final Account clone = (Account) super.clone();
        clone.outputBalance();
        return clone;
    }

    /**
     * Class constructor that creates a new object as a "copy" of another Account object.
     * @param acct Account object used to create copy
     */
    public Account(Account acct){
        //OBJ04-J: Provide mutable classes with copy functionality to safely allow passing instances to untrusted code

        Account.Transaction transaction = acct.new Transaction();
        this.balance = transaction.checkBalance();

        this.fname = new StringBuilder(acct.getFName().toString());
        this.lname = new StringBuilder(acct.getLName().toString());
    }

    /**
     * Method that outputs balance, but does not allow overrides to ensure consistent 
     * output when clone is called 
     */
    public final void outputBalance(){
        //MET06-J: Do not invoke overridable methods in clone (add final to superclass method declarations)

        System.out.println("Balance: " + this.balance);
    }


    /**
     * gets Account balance
     * @return balance of Account
     */
    private final double getBalance(){
        return this.balance; 
    }

    /**
     * Deposits double amount into Bank Account
     * @param amount amount to be deposited
     */
    private final void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }

    /**
     * Withdraws given amount from bank account
     * @param amount amount to be withdrawn
     */
    private final void withdraw(double amount){
        if(amount > 0 && balance >= amount){
            balance -= amount;
        }
    }
    
    //OBJ08-J: Do not expose private members of an outer class from within a nested class.
    //OBJ07-J: Sensitive classes must not let themselves be copied
    final class Transaction{
        /**
         * This class wraps the functionalities of private deposit, withdrawl, and balance
         * methods to show off better security practices.
         * @author Michael Rosenwinkel
         */

        /**
         * Processes deposit using private deposit method
         * @param amount amount to be depositted
         */
        public void processDeposit(double amount){
            deposit(amount);
        }

        /**
         * Processes withdrawal using private withdrawal method
         * @param amount amount to be withdrawn
         */
        public void processWithdrawal(double amount){
            withdraw(amount);
        }

        /**
         * Checks the balance of the Bank Account using private checkBalance method.
         * @return private getBalance method
         */
        public double checkBalance(){
            return getBalance();
        }
    }
    /**
     * gets first name of bank account in a way that does not risk 
     * future modification of the StringBuilder members.
     * @return first name of account holder
     */
    public StringBuilder getFName(){
        //OBJ05-J: Do not return references to private mutable class members

        return new StringBuilder(this.fname);
    }

    /**
     * gets last name of bank account in a way that does not risk 
     * future modification of the StringBuilder members.
     * @return last name of account holder
     */
    public StringBuilder getLName(){
        // OBJ13-J: Ensure that references to mutable objects are not exposed
        return new StringBuilder(this.lname);
    }

    

}
