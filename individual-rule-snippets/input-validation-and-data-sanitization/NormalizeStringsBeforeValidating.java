/**
 * Written by Dan Rascop
 * Program demonstrating the SEI CERT Oracle Coding Standard for Java - Rule IDS01-J. Normalize Strings Before Validating Them
 * Reference: https://wiki.sei.cmu.edu/confluence/display/java/IDS01-J.+Normalize+Strings+Before+Validating+Them
 */

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class NormalizeStringsBeforeValidating {
    
    /**
     * The main method demonstrates the importance of normalizing strings before validating them.
     * It creates a harmful string with a Unicode representation of "<script>" and passes it to
     * the validateString() method before normalizing it, and once again after it has been normalized.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        
        String scriptTag = "\uFE64" + "script" + "\uFE65"; // Harmful string with Unicode representation of "<script>"

        System.out.println("\nValidating the string before normalizing...");
        System.out.printf("String: \"%s\"\n", scriptTag);
        validateString(scriptTag);

        System.out.println("\nNormalizing the string...");
        String normalizedScriptTag = Normalizer.normalize(scriptTag, Form.NFKC);

        System.err.println("\nValidating the normalized string...");
        System.out.printf("String: \"%s\"\n", normalizedScriptTag);
        validateString(normalizedScriptTag);
    }


    /**
     * Validates the given string to check for harmful tags and prints the result to the terminal.
     * Checks for the presence of the characters '<' or '>'.
     *
     * @param s the string to validate
     * @throws IllegalStateException if a harmful tag is found
     */
    private static void validateString(String s) {

        Pattern pattern = Pattern.compile("[<>]");

        Matcher matcher = pattern.matcher(s);

        System.out.print("Validation Result: ");
        if (matcher.find()) {
            throw new IllegalStateException("Harmful tag found!");
        } 
        else {
            System.out.println("String is safe.");
        }
    }

}
