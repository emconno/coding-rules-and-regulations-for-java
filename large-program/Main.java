import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    /**
     * Method to determine if an account is a TaxedAccount
     * @param   myAccount
     * @return  a boolean stating whether the account is a TaxedAccount
     */
    public static boolean isTaxedAccount(Account myAccount) {
        TaxedAccount taxed = new TaxedAccount(0, new StringBuilder(), new StringBuilder());

        //OBJ09-J. Compare classes and not class names 
        return myAccount.getClass() == taxed.getClass();
    }


    public static ArrayList<Account> createAccountsFromFile(String filename) {
        ArrayList<Account> newAccounts = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()) {
                String accountVals = reader.nextLine();
                String[] vals = accountVals.split(" ");
                newAccounts.add(new Account(Double.parseDouble(vals[0]), new StringBuilder(vals[1]), new StringBuilder(vals[2])));
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }

        
        return newAccounts;
    }

    public static void main(String[] args) {
        StringBuilder fname = new StringBuilder("John");
        StringBuilder lname = new StringBuilder("Doe");

        Account myAccount = new Account(100, fname, lname);
        TaxedAccount myTaxedAccount = new TaxedAccount(250, fname, lname);

        System.out.println("Testing if 'myAccount' is a taxed account: " + isTaxedAccount(myAccount));
        System.out.println("Testing if 'myTaxedAccount' is a taxed account: " + isTaxedAccount(myTaxedAccount));

        ArrayList<Account> fileAccounts = createAccountsFromFile("large-program\\Account.txt");
        
        for (int i = 0; i < fileAccounts.size(); i++) {
            Account acc = fileAccounts.get(i);
            System.out.println("New Account " + i + ": " + acc.getFName() + " " + acc.getLName());
        }


    }
    
}
