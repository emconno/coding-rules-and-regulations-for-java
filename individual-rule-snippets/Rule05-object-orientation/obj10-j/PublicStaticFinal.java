/**
 * This file shows off rule OBJ10-J: Don't use public static 
 * nonfinal fields (they can easily be modified)
 * 
 * @author Michael Rosenwinkel
 */

public class PublicStaticFinal {

    /**
     * This simple class contains a public static final variable that cannot be modified by other 
     * classes, which is good security practice
     * @author Michael Rosenwinkel
     */
    public static final double interestRate = 0.07;
}
