/**
 * A class demonstrating Rule 06: MET00-J: Validate method arguments
 * from the SEI CERT Oracle Coding Standard for java.
 *
 * This rule is demonstrated by the use conditional statements in the setUsername method.
 * The method argument newUsername is validated before the value of username in the class instance is set.
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
     * Set the username for the account
     * @param newUsername
     */
    public void setUsername(String newUsername) {
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
     * Get the username for the account
     * @return  the username as a string
     */
    public String getUsername() {
        return this.username;
    }


    /**
     * Main method used to test the functionality of the setUsername method.
     * @param args
     */
    public static void main(String[] args) {
        Account myAccount = new Account();


        String newUsername = null;
        myAccount.setUsername(newUsername);


        newUsername = "exampleName";
        myAccount.setUsername(newUsername);
    }
}


