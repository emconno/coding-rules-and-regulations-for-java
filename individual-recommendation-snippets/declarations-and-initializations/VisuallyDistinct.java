
/**
 * A class demonstrating Recommendation 
 * DCL50-J: Use visually distinct identifiers
 *
 * This recommendation is demonstrated by a class VisuallyDinstinct
 * which contains examples of how to properly differentiate
 * values which may be visually nondinstinct using the right
 * characters.
 * @author Michael Rosenwinkel
 */


public class VisuallyDistinct{

    /**
    * A nested class implementing the node data structure used for singly-linked lists. Only String data is accepted.
    * @author Michael Rosenwinkel
    */

    private long val1 = 11111L; //using the more visually distinct "L" as opposed to "11111l" which may be confusing
    private String val2 = "111111";


    /**
    * Prints out private fields to the console
    */
    public void printVals(){
        System.out.println("val1: " + this.val1);
        System.out.println("val2: " + this.val2);
    }


    /**
    * Main method demonstrating methods and class concept
    */
    public static void main(String[] args) {
        VisuallyDistinct obj = new VisuallyDistinct();

        obj.printVals();
    }
}