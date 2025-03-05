
public class Account {

    //OBJ01-J: Limit accessibility of fields
    private double balance = 0; 

    public Account(double balance){
        this.balance = balance; 
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

    


    

}
