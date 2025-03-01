/**
 * Written by Dan Rascop
 * Program demonstrating the SEI CERT Oracle Coding Standard for Java - Rule IDS03-J. Do not log unsanitized user input
 * Reference: https://wiki.sei.cmu.edu/confluence/display/java/IDS03-J.+Do+not+log+unsanitized+user+input
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;


public class DoNotLogUnsanitizedUserInput {

    /**
     * The main method demonstrates the importance of sanitized user input before logging it.
     * It first initializes a harmful, multiline username that could be used to perform a log injection attack.
     * We log the username once before sanitizing it, and once after it has been sanitized to show the difference.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        String username = """
                          guest\r
                          Mar 01, 2025 9:24:51 AM DoNotLogUnsanitizedUserInput main\r
                          SEVERE: User login succeeded for: administrator""";

        Logger logger = Logger.getLogger(DoNotLogUnsanitizedUserInput.class.getName()); // initialize the logger

        System.out.println("\nLogging unsanitized username...");
        logger.log(Level.SEVERE, "Login failed for {0}", username);
        
        System.out.println("\nLogging sanitized username...");
        logger.log(Level.SEVERE, "Login failed for {0}", sanitizeUsername(username));
    }

    
    /**
     * Sanitizes the given username by checking if it matches the allowed pattern.
     * If the username contains only alphanumeric characters and underscores, it is considered valid.
     * Otherwise, it returns "unauthorized user".
     *
     * @param username the username to sanitize
     * @return the sanitized username if valid, otherwise "unauthorized user"
     */
    private static String sanitizeUsername(String username) {
        return Pattern.matches("[A-Za-z0-9_]+", username)
            ? username : "unauthorized user";
    }
}
