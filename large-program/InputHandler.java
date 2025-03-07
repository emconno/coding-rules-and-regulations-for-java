import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles user input from the console.
 */
public class InputHandler {

    private Scanner scanner;


    /**
     * Constructs an InputHandler and initializes the scanner.
     */
    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }


    /**
     * Prompts the user for a non-empty string input.
     *
     * @param prompt The prompt message to display to the user.
     * @return The non-empty string input from the user.
     */
    public String getStringInput(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
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
                String input = getStringInput(prompt); // Use the now non-empty string input
                String sanitizedInput = sanitizeNumericInput(input);
                if (sanitizedInput.contains(".")) {
                    double value = Double.parseDouble(sanitizedInput);
                    if (value <= 0) {
                        System.out.println("Input must be a positive number. Please try again.");
                    } else {
                        return value;
                    }
                } else {
                    int value = Integer.parseInt(sanitizedInput);
                    if (value <= 0) {
                        System.out.println("Input must be a positive integer. Please try again.");
                    } else {
                        return value;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid numeric input. Please try again.");
            }
        }
    }


    /**
     * Prompts the user for a username input and validates it.
     *
     * @param prompt The prompt message to display to the user.
     * @return The validated username input from the user.
     */
    public String getUsernameInput(String prompt) {
        while (true) {
            String input = getStringInput(prompt);
            // IDS03-J: Do not log unsanitized user input
            String sanitizedInput = sanitizeString(input);
            // IDS01-J: Normalize strings before validating them
            String normalizedInput = normalizeString(sanitizedInput); 
            // EXP00-J: Do not ignore values returned by methods
            if (validateUsername(normalizedInput)) { 
                return normalizedInput;
            } else {
                System.out.println("Invalid username. Please use only letters, digits, and underscores.");
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
            } else {
                System.out.println("Invalid password. Please use only letters, digits, and special characters.");
            }
        }
    }


    /**
     * Sanitizes a numeric input by removing any characters that are not digits or dots.
     * Ensures that only one dot is present in the sanitized input.
     *
     * @param input The numeric input to sanitize.
     * @return The sanitized numeric input.
     */
    public String sanitizeNumericInput(String input) {
        String sanitized = input.replaceAll("[^0-9.]", "");

        // Ensure only one dot is present
        int firstDot = sanitized.indexOf('.');
        if (firstDot != -1) {
            int secondDot = sanitized.indexOf('.', firstDot + 1);
            if (secondDot != -1) {
                sanitized = sanitized.substring(0, secondDot);
            }
        }

        // Remove leading dot if present
        if (sanitized.startsWith(".")) {
            sanitized = sanitized.substring(1);
        }

        return sanitized;
    }

    /**
     * Normalizes a string and removes special characters.
     *
     * @param input The string to normalize.
     * @return The normalized string.
     */
    public String normalizeString(String input) {
        String normalized = Normalizer.normalize(input, Form.NFKC);
        return normalized.replaceAll("\\p{M}", "");
    }


    /**
     * Sanitizes a string input by removing harmful characters or patterns.
     *
     * @param input The string input to sanitize.
     * @return The sanitized string input.
     */
    public String sanitizeString(String input) {
        // Define patterns for harmful characters or patterns
        Pattern harmfulPattern = Pattern.compile("[<>\"'%;()&+]");
        Matcher matcher = harmfulPattern.matcher(input);
        return matcher.replaceAll("");
    }

    /**
     * Validates a username to check for harmful characters or patterns.
     *
     * @param input The username to validate.
     * @return true if the username is safe, false otherwise.
     */
    public boolean validateUsername(String input) {
        // Define patterns for harmful characters or patterns
        Pattern harmfulPattern = Pattern.compile("[<>\"'%;()&+]");
        Matcher matcher = harmfulPattern.matcher(input);
        if (matcher.find()) {
            return false;
        }

        // Define patterns for valid usernames
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
    public boolean validatePassword(String input) {
        // Define patterns for harmful characters or patterns
        Pattern harmfulPattern = Pattern.compile("[<>\"'%;()&+]");
        Matcher matcher = harmfulPattern.matcher(input);
        if (matcher.find()) {
            return false;
        }

        // Define patterns for valid passwords
        Pattern validPattern = Pattern.compile("^[a-zA-Z0-9_!@#$%^&*()_+=-]+$");
        matcher = validPattern.matcher(input);
        return matcher.matches();
    }

    
    /**
     * Closes the scanner to release resources.
     */
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

}
