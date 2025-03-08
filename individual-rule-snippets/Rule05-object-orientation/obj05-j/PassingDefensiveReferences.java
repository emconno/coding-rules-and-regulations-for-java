/**
 * File that demonstrates rule OBJ05-J: do not return references to private mutable class members
 * 
 * This file contains class PassingDefensiveReferences, which showcases passing mutable members
 * as references without risking their accidental or malicious modification.
 * @author Michael Rosenwinkel
 */




public class PassingDefensiveReferences{
    /**
     * This class showcases defensive reference passing without risking modification of 
     * mutable StringBuilder members
     * @author Michael Rosenwinkel
     */
    private StringBuilder sb; 

    /**
     * Class constructor that takes in another object of this class to build a copy. This defensively passes
     * in parameter to ensure that it cannot be modified in the future.
     * @param s another object of class that we use to make a "copy" of
     */
    public PassingDefensiveReferences(PassingDefensiveReferences s){
        this.sb = new StringBuilder(s.sb.toString());
    }

    /**
     * Method that takes in a StringBuilder to make a copy. 
     * This StringBuilder is defensively passed to ensure no future modifications.
     * @param s StringBuilder object that we use to make a "copy"
     */
    public PassingDefensiveReferences(StringBuilder s){
        this.sb = new StringBuilder(s.toString());
    }

    /**
     * returns new String Builder to ensure no future modifications to object StringBuilder.
     * @return StringBuilder object copy
     */
    public StringBuilder getStringBuilder(){
        return new StringBuilder(sb.toString());
    }

    /**
     * Main method to showcase methods in PassingDefensiveReferences.
     * @param args not used
     */
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Rishi"); //create date object

        PassingDefensiveReferences pdr = new PassingDefensiveReferences(sb); //use created date object to create new instance of PassingDefensiveReferences

        StringBuilder maliciousStringBuilder = pdr.getStringBuilder(); //create a date object that will try to manipulate the date in the object instance

        /*
         * Change the date of the malicious date. If the rule is not followed, then this could result in an inconsistent state 
         * of the original object. 
         */
        maliciousStringBuilder.append("malicious text"); 

        //we can see though, since the rule is followed that the original state of the object is maintained. 
        String maliciousStr = maliciousStringBuilder.toString();

        String pdrStr = (pdr.getStringBuilder().toString());

        System.out.println("malicious date string: " + maliciousStr);

        System.out.println("date object string: " + pdrStr);





    }
}