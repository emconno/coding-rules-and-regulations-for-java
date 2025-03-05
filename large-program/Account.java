
public class Account {

    //limit accessibility of fields
    private double balance = 0; 
    private String fname; 
    private String lname; 

    public Account(String fnameInit, String lnameInit){
        this.fname = fnameInit; 
        this.lname = lnameInit;
    }

    public boolean withdrawal(double amount){
        balance -= amount; 

        if(balance < 0){
            return false; 
        }
        return true;
    }

    public boolean deposit(double amount){
        balance += amount; 

        if(balance < 0){
            return false; 
        }

        return true;
    }


}
