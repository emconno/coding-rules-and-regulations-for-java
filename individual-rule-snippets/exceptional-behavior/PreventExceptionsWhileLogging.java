/**
 * @author Dan Rascop
 * Program demonstrating the SEI CERT Oracle Coding Standard for Java - Rule ERR02-J. Prevent exceptions while logging data
 * Reference: https://wiki.sei.cmu.edu/confluence/display/java/ERR02-J.+Prevent+exceptions+while+logging+data
 */

 import java.io.IOException;
 import java.util.logging.FileHandler;
 import java.util.logging.Logger;
 import java.util.logging.SimpleFormatter;


class PreventExceptionsWhileLogging {

    /**
     * Demonstrates the importance of preventing exceptions while logging.
     * This method sets up a logger to write log messages to a file. It ensures
     * that the log file is opened prior to logging to avoid the risk of an
     * IOException occurring during logging.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        
        Logger logger = Logger.getLogger("MyLog");  
        FileHandler fh;  

        try {  
            // Configure the LogFile
            fh = new FileHandler("./individual-rule-snippets/exceptional-behavior/LogFile.log"); // open the file 
            logger.addHandler(fh); // set logger to write to LogFile
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  
        } catch (SecurityException | IOException e) {  
            logger.severe(e.getMessage());
        }  

        logger.info("Info log test message"); 
        logger.severe("Severe log test message");

    }
}
