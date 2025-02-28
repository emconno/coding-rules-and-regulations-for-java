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
        validateString(scriptTag);

        System.out.println("\nNormalizing the string...");
        String normalizedScriptTag = Normalizer.normalize(scriptTag, Form.NFKC);

        System.err.println("\nValidating the normalized string...");
        validateString(normalizedScriptTag);

    }


    /**
     * Validates the given string to check for harmful tags.
     * Checks for the presence of the characters '<' or '>'.
     *
     * @param s the string to validate
     * @throws IllegalStateException if a harmful tag is found
     */
    private static void validateString(String s) {

        System.out.printf("String: \"%s\"\n", s );

        Pattern pattern = Pattern.compile("[<>]");

        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            // Found blacklisted tag
            throw new IllegalStateException("Harmful tag found during validation!");
        } 
        else {
            System.out.println("String is safe.");
        }
    }

}
