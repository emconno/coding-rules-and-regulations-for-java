/**
 * A class demonstrating Rule 05: OBJ07-J: Sensitive classes must not let themselves be copied
 * from the SEI CERT Oracle Coding Standard for java.
 * 
 * This rule is demonstrated by the use of private class fields in the Account class.
 * Private class fields along with setter and getter methods are used to access fields in a more secure way.
 * @author Emmett Connolly
 */
final class Sensitive {
    public String username;
    private String passwordHash;
    private String confidentialData;

    public Sensitive(String username) {
        this.username = username;
    }
}
