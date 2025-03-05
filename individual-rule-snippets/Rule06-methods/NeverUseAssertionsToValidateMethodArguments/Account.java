/**
 * A class demonstrating Rule 06: MET01-J: Never use assertions to validate method arguments
 * from the SEI CERT Oracle Coding Standard for java.
 *
 * This rule is demonstrated with the use two methods: setUsernameGood and setUsernameBad.
 * setUsernameGood properly validates the method argument.
 * setUsernameBad improperly uses assertions to validate the method argument.
 * @author Emmett Connolly
 */
public class Account {
    private String username;

    /**
     * Class constructor
     */
    public Account() {
        this.username = "";
    }

    /**
     * Demonstrates proper user input validation without the use of assertions
     * @param newUsername
     */
    public void setUsernameGood(String newUsername) {
        if(newUsername == null) {
            //Handle error
            System.out.println("ERROR: Null username");
            return;
        }
        if (newUsername.length() < 8) {
            //Handle error
            System.out.println("ERROR: Username too short");
            return;
        }

        System.out.println("Success");
        this.username = newUsername;
    }

    /**
     * Demonstrates improper user input validation with the use of assertions
     * @param newUsername
     */
    public void setUsernameBad(String newUsername) {
        assert newUsername == null : "Null username";
        assert newUsername.length() >= 8 : "Username too short";
        
        System.out.println("Success");
        this.username = newUsername;
    }

    /**
     * Main method to test the functionality of setUsernameGood and setUsernameBad
     * @param args
     */
    public static void main(String[] args) {
        Account myAccount = new Account();
        String newUsername = null;

        System.out.println("Correct validation:");
        myAccount.setUsernameGood(newUsername);
        System.out.println("\nIncorrect validation:");
        myAccount.setUsernameBad(newUsername);
    }
}

