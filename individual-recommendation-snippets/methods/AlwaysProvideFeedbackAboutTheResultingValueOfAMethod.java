/**
 * A class demonstrating Recommendation 06: MET54-J: Always provide feedback about the resulting value of a method
 * from the SEI CERT Oracle Coding Standard for java.
 *
 * This recommendation is demonstrated with the use a method that performs binary search.
 * Rather than returning nothing if the target value is not found, -1 is returned to indicate that
 * the value is not present in the array.
 * @author Emmett Connolly
 */
public class AlwaysProvideFeedbackAboutTheResultingValueOfAMethod {

    /**
     * A method that performs binary search. This method provides feedback in every possible input scenario.
     * @param arr
     * @param target
     * @return  //the index of the target value. If target is not present, return -1
     */
    public static int binarySearch(int[] arr, int target) {
        int lo = 0, mid = 0, hi = arr.length;
        
        while (lo < hi) {
            mid = lo + (hi-lo) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    /**
     * A main method to test the recommendation-compliant binarySearch method
     * @param args
     */
    public static void main(String[] args) {
        int[] sortedArr = {1, 4, 7, 10, 12, 44, 56, 79};
        int target = 10;

        System.out.println(target + " is found at index " + binarySearch(sortedArr, target) + " of the input array.");
    }
}