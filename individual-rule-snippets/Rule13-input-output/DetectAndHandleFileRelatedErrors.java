/**
 * A class demonstrating Rule 13: FIO02-J: Detect and handle file related errors
 * from the SEI CERT Oracle Coding Standard for java.
 *
 * This rule is demonstrated with the use a try-catch statement.
 * IOExceptions thrown by .createNewFile() are caught with this statement.
 * 
 * When running the file, provide the name of a file to be created as a command line argument. Try using disallowed
 * file names (including characters such as '/', '\', '<', '>', etc.)
 * @author Emmett Connolly
 */
import java.io.File;
import java.io.IOException;

public class DetectAndHandleFileRelatedErrors {
    /**
     * Main method that creates a new file and catches IOExceptions
     * @param args
     */
    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
}
