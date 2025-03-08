/**
 * A class demonstrating IDS07-J: Sanitize Untrusted data passed into RUntime.exec() method
 * 
 * This class grabs information from the system, and then sanitizes the results before they 
 * are passed into the Runtime.exec() method. Exceptions are then thrown depending on 
 * if the value is sanitized or not.
 * @author Michael Rosenwinkel
 */

import java.util.regex.Pattern;
import java.io.IOException;


public class SanitizeUntrusted {
    /**
     * Class that sanitizes input before it is passed into Runtime.exec()
     * @author Michael Rosenwinkel
     */


     /**
      * Method that sanitizes input before it is passed into Runtime.exec()
      * @param args not used
      */
    public static void main(String[] args) {

        //get path of application directory
        String path = System.getProperty("user.dir");

        //get runtime
        Runtime rt = Runtime.getRuntime();

        try{

            //sanitize path before we pass into Runtime.exec();
            if(!Pattern.matches("[^a-zA-Z0-9/_\\-.]", path)){
                System.out.println("Path is not a valid path");
                System.exit(1);
            }
            rt.exec("open " + path);

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    }
