/**
 * A class demonstrating Recommendation 06:
 * MET55-J: Return an empty array or collection instead of a null value for methods that return an array or collection
 * from the SEI CERT Oracle Coding Standard for java.
 *
 * This recommendation is demonstrated with the use a method that removes all values that are less than ten
 * from an ArrayList. Rather than returning null if the values in the ArrayList are all greater than or equal
 * to 10, an empty ArrayList is returned.
 * @author Emmett Connolly
 */
import java.util.ArrayList;

public class ReturnAnEmptyArrayOrCollection {
    /**
     * Returns an ArrayList that contains all of the values 
     * of the input ArrayList that are less than ten.
     * @param nums
     * @return  //a new ArrayList
     */
    public static ArrayList<Integer> removeLessThan10(ArrayList<Integer> nums) {
        ArrayList<Integer> newList = new ArrayList<>(); 

        for (int i = 0; i < nums.size(); i++) {
            int current = nums.get(i);
            if (current < 10) {
                newList.add(current);
            }
        }

        return newList;
    }  

    /**
     * Main method to demonstrate that when all the values of the input ArrayList 
     * are greater than or equal to ten, an empty ArrayList is returned.
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(32);
        numbers.add(12);
        numbers.add(14);

        System.out.println("Input ArrayList: " + numbers.toString());

        ArrayList<Integer> singleDigit = removeLessThan10(numbers);

        System.out.println("New ArrayList: " + singleDigit.toString());
    }
}
