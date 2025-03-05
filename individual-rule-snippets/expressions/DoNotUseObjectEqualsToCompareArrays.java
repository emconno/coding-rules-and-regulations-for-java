/**
 * @author Dan Rascop
 * Program demonstrating the SEI CERT Oracle Coding Standard for Java - Rule EXP02-J. Do not use the Object.equals() method to compare two arrays
 * Reference: https://wiki.sei.cmu.edu/confluence/display/java/EXP02-J.+Do+not+use+the+Object.equals%28%29+method+to+compare+two+arrays
 */

import java.util.Arrays;


class DoNotUseObjectEqualsToCompareArrays {

    /**
     * The main method demonstrates the difference between using Object.equals() and Arrays.equals() to compare two arrays.
     * It initializes two integer arrays with the same elements and compares them using both methods.
     * 
     * Object.equals() compares the references of the arrays, resulting in false.
     * Arrays.equals() compares the contents of the arrays, resulting in true.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};

        System.out.println("\nResult using Object.equals(): " + arr1.equals(arr2));

        System.out.println("\nResult using Arrays.equals(): " + Arrays.equals(arr1, arr2));
    }
}
