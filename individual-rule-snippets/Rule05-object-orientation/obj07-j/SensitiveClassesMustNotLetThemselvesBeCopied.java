/**
 * A class demonstrating Rule 05: OBJ07-J: Sensitive classes must not let themselves be copied
 * from the SEI CERT Oracle Coding Standard for java.
 *
 * 
 * @author Emmett Connolly
 */
final class SensitiveClassesMustNotLetThemselvesBeCopied {
    public String username;
    private String passwordHash;
    private String confidentialData;


    public SensitiveClassesMustNotLetThemselvesBeCopied(String username) {
        this.username = username;
    }
}
