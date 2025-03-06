public class TaxedAccount extends Account{

    TaxedAccount(double balance, StringBuilder fname, StringBuilder lname){
        super(balance, fname, lname);
    }

    //MET06-J: Do not invoke overridable methods in clone (add final to superclass method declarations)
    public Object clone() throws CloneNotSupportedException {
        final TaxedAccount clone = (TaxedAccount) super.clone();
        return clone;
    }

    public static void main(String[] args) throws CloneNotSupportedException{

        StringBuilder fname = new StringBuilder("Michael");
        StringBuilder lname = new StringBuilder("Rosenwinkel");
        double balance = 5;

        Account account = new TaxedAccount(balance, fname, lname);
        account.clone();
    }
    
}
