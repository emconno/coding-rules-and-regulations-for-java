import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class contains methods for prompting and returning user input from the terminal.
 * Supports String and numeric input. Input validation and sanitization is also done in this class. 
 * 
 */
public class InputHandler {

    private Scanner scanner;


    /**
     * Constructor. Initializes the scanner.
     */
    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }


    /**
     * Closes the scanner.
     */
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }


    /**
     * Prompts the user for a positive numeric input (either integer or double).
     *
     * @param prompt The prompt message to display to the user.
     * @return The positive numeric input from the user.
     */
    public Number getNumericInput(String prompt) {

        while (true) {
            try {
                String input = getStringInput(prompt); 
                String sanitizedInput = sanitizeNumericInput(input);

                if (sanitizedInput.contains(".")) {
                    double value = Double.parseDouble(sanitizedInput);
                    if (value <= 0) {
                        System.out.println("Input must be a positive number. Please try again.");
                    } else {
                        return value;
                    }
                } 
                else {
                    int value = Integer.parseInt(sanitizedInput);
                    if (value <= 0) {
                        System.out.println("Input must be a positive integer. Please try again.");
                    } else {
                        return value;
                    }
                }      
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }


    /**
     * Prompts the user for a username and validates it.
     *
     * @param prompt The prompt message to display to the user.
     * @return The validated username input from the user.
     */
    public String getUsernameInput(String prompt) {

        while (true) {
            String input = getStringInput(prompt);

            //  Rule IDS03-J: Do not log unsanitized user input
            String sanitizedInput = sanitizeString(input);

            // Rule IDS01-J: Normalize strings before validating them
            String normalizedInput = normalizeString(sanitizedInput); 

            // Rule EXP00-J: Do not ignore values returned by methods
            if (validateUsername(normalizedInput)) { 
                return normalizedInput;
            } 
            else {
                System.out.println("Invalid username. Please use only letters and digits. No spaces or special characters.");
            }
        }
    }


    /**
     * Prompts the user for a password input and validates it.
     *
     * @param prompt The prompt message to display to the user.
     * @return The validated password input from the user.
     */
    public String getPasswordInput(String prompt) {

        while (true) {
            String input = getStringInput(prompt);
            String sanitizedInput = sanitizeString(input);
            String normalizedInput = normalizeString(sanitizedInput);
            if (validatePassword(normalizedInput)) {
                return normalizedInput;
            } 
            else {
                System.out.println("Invalid password. Please use only letters and digits. No spaces or special characters.");
            }
        }
    }


    /**
     * Prompts the user for String input. Makes sure input is not empty.
     *
     * @param prompt The prompt message to display to the user.
     * @return The String input from the user.
     */
    private String getStringInput(String prompt) {

        String input;

        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Enter a username.");
            }
        } while (input.isEmpty());

        return input;
    }


    /**
     * Sanitizes a numeric input by removing any characters that are not digits or dots.
     * Ensures that only one dot is present in the sanitized input.
     *
     * @param input The numeric input to sanitize.
     * @return The sanitized numeric input.
     */
    private String sanitizeNumericInput(String input) {
        String sanitizedInput = input.replaceAll("[^0-9.]", "");

        // Make sure input only contains one dot
        int firstDot = sanitizedInput.indexOf('.');
        if (firstDot != -1) {
            int secondDot = sanitizedInput.indexOf('.', firstDot + 1);
            if (secondDot != -1) {
                sanitizedInput = sanitizedInput.substring(0, secondDot);
            }
        }

        // Remove leading dot if present
        if (sanitizedInput.startsWith(".")) {
            sanitizedInput = sanitizedInput.substring(1);
        }

        return sanitizedInput;
    }


    /**
     * Sanitizes a string input by removing new line characters
     *
     * @param input The string input to sanitize.
     * @return The sanitized string input.
     */
    private String sanitizeString(String input) {

        // Remove any new line characters
        Pattern harmfulPattern = Pattern.compile("[\n\r]");
        Matcher matcher = harmfulPattern.matcher(input);
        return matcher.replaceAll("");
    }


    /**
     * Validates a username to check for harmful characters or patterns.
     *
     * @param input The username to validate.
     * @return true if the username is safe, false otherwise.
     */
    private boolean validateUsername(String input) {

        // Check for special characters in the input
        Pattern harmfulPattern = Pattern.compile("[<>\"'%;()&+]");
        Matcher matcher = harmfulPattern.matcher(input);
        if (matcher.find()) {
            return false;
        }

        // Define pattern for valid usernames: only letters or numbers and no spaces
        Pattern validPattern = Pattern.compile("^[a-zA-Z0-9_]+$");
        matcher = validPattern.matcher(input);
        return matcher.matches();
    }


    /**
     * Validates a password to check for harmful characters or patterns.
     *
     * @param input The password to validate.
     * @return true if the password is safe, false otherwise.
     */
    private boolean validatePassword(String input) {

        // Check for angle brackets in the String to prevent harmful tag injection
        Pattern harmfulPattern = Pattern.compile("[<>]");
        Matcher matcher = harmfulPattern.matcher(input);
        if (matcher.find()) {
            return false;
        }

        // Define pattern for valid passwords: only letters or numbers and no spaces
        Pattern validPattern = Pattern.compile("^[a-zA-Z0-9_!@#$%^&*()_+=-]+$");
        matcher = validPattern.matcher(input);
        return matcher.matches();
    }


    /**
     * Normalizes a string and returns it.
     *
     * @param input The string to normalize.
     * @return The normalized string.
     */
    private String normalizeString(String input) {
        return Normalizer.normalize(input, Form.NFKC);
    }

}
