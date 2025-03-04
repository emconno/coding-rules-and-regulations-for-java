/**
 * Written by Dan Rascop
 * Program demonstrating the SEI CERT Oracle Coding Standard for Java - Rule ERR08-J. Do not catch NullPointerException or any of its ancestors
 * Reference: https://wiki.sei.cmu.edu/confluence/display/java/ERR08-J.+Do+not+catch+NullPointerException+or+any+of+its+ancestors
 */


public class DoNotCatchNullPtrException {

    /**
     * The main method demonstrates the importance of not catching NullPointerException.
     * We use the operation of printing the length of a null username to showcase the different approaches.
     * 
     * In the non-compliant approach, the program attempts to get the length of a null username,
     * which results in a NullPointerException being caught.
     * 
     * In the compliant approach, the program checks if the username is null before attempting
     * to get its length, thus avoiding the NullPointerException.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        String username = null;

        
        // Non-compliant approach: Catching NullPointerException
        try {
            System.out.println("Length of username: " + username.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }


        // Compliant approach: Performing null check
        if (username != null) {
            System.out.println("Length of username: " + username.length());
        } else {
            System.out.println("Invalid username: Username is null");
        }
    }
}
