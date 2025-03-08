
/**
 * A class demonstrating Recommendation 
 * OBJ51-J: Minimize the visibility of classes and their members
 *
 * This recommendation is demonstrated with the use of a final class
 * MinimizeAccessibility, which has sample values and characteristics
 * that are more secure and useful depending on the situation.
 * @author Michael Rosenwinkel
 */



final class MinimizeAccessibility {

    /**
    * A final, package private class that cannot be inherited from
    * (this prevents malicious subclasses from modifying the class), 
    * and is package private, meaning that not any class can have access
    * or modify class members. 
    * @author Michael Rosenwinkel
    */

    
    private final int val1; 
    private final int val2;

    /**
    * Class constructor that sets random values to the final variables
    */
    public MinimizeAccessibility(){
        this.val1 = 10; 
        this.val2 = 20;
    }
    
    /**
    * Outputs the members to the console. Should not be visible
    * to any API level class in the system.
    */
    public void outputVals(){
        System.out.println("val1: " + val1);
        System.out.println("val2:" + val2);
    }

}
