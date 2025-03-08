//recommendation OBJ50-J: Never confuse immutability of a reference
//with that of the referenced object.

/**
 * A class demonstrating 
 * OBJ50-J: Never confuse immutability of a reference
 * with that of the referenced object.
 * 
 *
 *
 * This recommendation is represented by the class 
 * ImmutabilityOfObject, which has several final instance
 * variables and methods to print them. This shows off
 * the concept of having immutable variables to guarantee
 * object immutability versus immutability of the reference.
 * @author Michael Rosenwinkel
 */


public class ImmutabilityOfObject {

    /**
    * A class to show off functionality of immutable instance variables
    * instead of immutable references
    * @author Michael Rosenwinkel
    */

    //ensure these values cannot be changed
    private final int val1; 
    private final int val2; 

    /**
    * Class Constructor setting the final values on instantiation
    * @param val1 any integer value for demonstration purposes
    * @param val2 any integer value for demonstration purposes
    */
    public ImmutabilityOfObject(int val1, int val2){
        this.val1 = val1; 
        this.val2 = val2;
    }

    /**
    * Method for printing out the values stored in an object
    */
    public void printVals(){
        System.out.println("val1: " + this.val1);
        System.out.println("val2: " + this.val2);
    }


    
    /**
    * Method that shows off instantiation of object
    * and ensuring that the fields are final.
    * @param args not used
    */
    public static void main(String[] args){

        //does not confuse the immutability of the object with the immutability of the reference.
        //the reference is mutable, but the object that the reference points to has immutable
        //fields.
        ImmutabilityOfObject obj = new ImmutabilityOfObject(1, 2);

        

    }

}