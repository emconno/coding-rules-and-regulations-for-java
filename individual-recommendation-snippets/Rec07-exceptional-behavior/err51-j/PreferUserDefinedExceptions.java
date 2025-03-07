/**
 * @author Dan Rascop
 * Program demonstrating the SEI CERT Oracle Coding Standard for Java - Recommendation ERR51-J. Prefer user-defined exceptions over more general exception types
 * Reference: https://wiki.sei.cmu.edu/confluence/display/java/ERR51-J.+Prefer+user-defined+exceptions+over+more+general+exception+types
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PreferUserDefinedExceptions {

    /**
     * The main method demonstrates the importance of using specific exceptions, rather than generic ones such as Exception.
     * We attempt to read a file that does not exist, and catch it with FileNotFoundException.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        try {
            readFile("nonexistentfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        } 

    }

    /**
     * Reads a file and closes the FileReader.
     * 
     * @param fileName The name of the file to read
     * @throws IOException If an I/O error occurs
     */
    public static void readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        fr.close();
    }
}
