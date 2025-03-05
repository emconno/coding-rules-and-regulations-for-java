/**
 * @author Dan Rascop
 * Program demonstrating the SEI CERT Oracle Coding Standard for Java - Rule OBJ13-J. Ensure that references to mutable objects are not exposed
 * Reference: https://wiki.sei.cmu.edu/confluence/display/java/OBJ13-J.+Ensure+that+references+to+mutable+objects+are+not+exposed
 */

import java.util.Arrays;


public class DoNotExposeReferenceToMutableObject {
    
    private static final String[] authorizedUsernames = {"sysadmin", "databaseadmin", "productmanager"};

    /**
     * Returns a reference to the authorizedUsernames array.
     *
     * @return A reference to the authorizedUsernames array.
     */
    public static final String[] vulnerableGetter() {
        return authorizedUsernames;
    }

    /**
     * Returns a clone of the authorizedUsernames array.
     *
     * @return A clone of the authorizedUsernames array.
     */
    public static final String[] secureGetter() {
        return authorizedUsernames.clone();
    }

    
    /**
     * The main method demonstrates the importance of returning clones of mutable objects instead of the references.
     * 
     * It first retrieves a clone of the authorizedUsernames array using the secureGetter method and modifies the clone.
     * It then prints the original array to show that it remains unchanged.
     * 
     * Next, it retrieves a reference to the authorizedUsernames array using the vulnerableGetter method and modifies the array through this reference.
     * It then prints the original array to show that it has been changed due to the modification through the reference.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        
        String[] objectClone = secureGetter(); 

        objectClone[0] = "attacker"; 

        System.out.println("\nOriginal Array after Modifying Clone: " + Arrays.toString(secureGetter())); 

        String[] objectReference = vulnerableGetter(); 

        objectReference[0] = "attacker"; 

        System.out.println("\nOriginal Array after Modifying Reference: " + Arrays.toString(secureGetter()) + "\n"); 
    }
}
