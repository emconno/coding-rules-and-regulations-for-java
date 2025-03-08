import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This file demonstrates rule IDS11-J: Perform string modifications before validation
 * 
 * This file contains the class ModifyBeforeValidation, which normalizes, and then 
 * trims any values off of a string that may cause it to pass valiation, which may 
 * expose other programs to cross-scripting vulnerabilities if there is a <script>
 * tag embedded in the string.
 * @author Michael Rosenwinkel
 */
public class ModifyBeforeValidation {
    /**
     * Class that shows modifying strings before we validate them (catching any 
     * malicious strings that may pass validation by mistake).
     * @author Michael Rosenwinkel
     */

     /**
      * This method normalizes the string, clears any misdirecting characters, and then 
      * runs a matcher on any strings that could induce vulnerabilities (such as <script>)
      * @param str the string to be normalized/fed into validation
      * @return the fully sanitized string
      */
    public static String filterString(String str){
        
        String s = Normalizer.normalize(str, Form.NFKC);

        //Deletes noncharacter code points
        s = s.replaceAll("[\\p{Cn}]", "");

        //validate input
        Pattern pattern = Pattern.compile("<script>");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            throw new IllegalArgumentException("Invalid Input");
        }

        return s; 
    }

    /**
     * Main method that runs the filter string method and sanitizes the code. 
     * @param args not used
     */
    public static void main(String[] args) {
        // "\uFDEF" is a noncharacter code point
        String maliciousInput = "<scr" + "\uFDEF" + "ipt>";
        String sb; 
        try{
            sb = filterString(maliciousInput);

        }catch(IllegalArgumentException e){
            System.out.println("Script found in malicious code.");
            sb = new String("null");
        }

        System.out.println(sb);
        //sb = "<script>"
    }
}