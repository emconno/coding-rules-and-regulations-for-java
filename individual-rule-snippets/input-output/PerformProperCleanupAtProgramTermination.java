/**
 * A class demonstrating Rule 13: FIO14-J: Perform proper cleanup at program termination
 * from the SEI CERT Oracle Coding Standard for java.
 *
 * This rule is demonstrated with the use of a Scanner object.
 * When the scanner is no longer needed, the .close() method is called.
 * @author Emmett Connolly
 */
import java.util.Scanner;
public class PerformProperCleanupAtProgramTermination {
    /**
     * Main method to test Scanner functionality
     * @param args
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your name: ");

        String name = keyboard.next();

        System.out.println("Hello " + name + "!");

        keyboard.close();
    }
}
