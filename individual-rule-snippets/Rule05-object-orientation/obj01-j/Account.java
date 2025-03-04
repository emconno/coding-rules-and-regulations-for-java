/**
 * A class demonstrating Rule 05: OBJ01-J: Limit accessibility of fields
 * from the SEI CERT Oracle Coding Standard for java.
 * 
 * This rule is demonstrated by the use of private class fields in the Account class.
 * Private class fields along with setter and getter methods are used to access fields in a more secure way.
 * @author Emmett Connolly
 */
public class Account {
    private String username;
    private int age;

    /**
     * Class constructor
     * @param username
     * @param age
     */
    public Account(String username, int age) {
        this.username = username;
        this.age = age;
    }

    /**
     * Set the age of the account owner
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Set the username of the account owner
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the age of the account owner
     * @return
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Get the username of the account owner
     * @return the
     */
    public String getUsername() {
        return this.username;
    }


}
