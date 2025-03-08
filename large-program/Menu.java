/**
 * The Menu class provides methods to retrieve the main menu and bank menu options for displayal.
 */
public class Menu {
    
    private static final String MAIN_MENU = "Main Menu:\n\n1. Create Account\n2. Login\n3. Quit\n";
    private static final String BANK_MENU = "Bank Menu:\n\n1. Deposit\n2. Withdraw\n3. See Balance\n4. Quit\n";

    /**
     * Returns the main menu options as a string.
     *
     * @return the main menu options
     */
    public String getMainMenu() {
        return MAIN_MENU;
    }

    /**
     * Returns the bank menu options as a string.
     *
     * @return the bank menu options
     */
    public String getBankMenu() {
        return BANK_MENU;
    }

}
