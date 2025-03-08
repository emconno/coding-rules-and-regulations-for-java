/**This file shows off Rule OBJ08-J: Don't expose private members through public nested classes
 * @author Michael Rosenwinkel
 */


public class BankAccount{

    /**
     * This class doesn't expose private members through public nested classes.
     * @author Michael Rosenwinkel
     */
    private double balance = 0; 

    private class DisplayBalance{
        /**
         * This class is private, so it cannot be accessed by other classes that may be 
         * inadvertently, or maliciously trying to access sensitive information.
         * @author Michael Rosenwinkel
         */

        /**
         * Method that prints the balance of the Bank Account
         */
        private void getBalance(){
            System.out.println("$" + balance);
        }
    }

};
