/**
 * A class demonstrating Recommendation 
 * OBJ56-J: Provide sensitive mutable classes with unmodifiable wrappers
 *
 * This recommendation is demonstrated by the mutable string class, which has one 
 * mutable member that can be accessed only through an unmodifiable protector 
 * class, which inherits from the main class. 
 * @author Michael Rosenwinkel
 */

public class MutableString {
    /**
    * A class containing mutable members that can only be accessed
    * through an unmodifiable wrapper class.
    * @author Michael Rosenwinkel
    */

    private StringBuilder sb;
    /**
    * Class Constructor instantiating the data to the node (ensures no risk of inconsistent state)
    * @param sb StringBuilder value meant to show immutability
    */
    public MutableString(StringBuilder sb){
        this.sb = new StringBuilder(sb.toString());
    }

    /**
    * Returns the mutable field sb (unmodifiable wrapper
    * prevents editing)
    * 
    */
    public StringBuilder getSb(){
        return this.sb; 
    }


    /**
    * Sets the mutable member sb
    * @param sb
    */
    public void setSb(StringBuilder sb){
        this.sb = new StringBuilder(sb.toString());
    }

    class MutableStringProtector extends MutableString {
        /**
        * A nested, unmodifiable, wrapper class that ensures that the mutable value
        * of the super class cannot be modified after instantiation.
        * @author Michael Rosenwinkel
        */

        /**
        * Class Constructor uses superclass constructor to instantiate mutable field
        * @param sb mutable field StringBuilder
        */
        public MutableStringProtector(StringBuilder sb){
            super(sb);
        }

        /**
        * Returns brand new StringBuilder to ensure safety 
        * of original object mutable member.
        */
        @Override
        public StringBuilder getSb(){
            return new StringBuilder(super.getSb());
        }

        /**
        * Method to prevent modification of mutable class members
        * by throwing exception
        * @param sb mutable field StringBuilder
        */    
        @Override
        public void setSb(StringBuilder sb){
            throw new UnsupportedOperationException();
        }
    

    
    }

    /*
     * Main method that instantiates and shows off the 
     * safety of using unmodifiable wrappers with 
     * mutable members. 
     */
    public static void main(String[] args){
        StringBuilder blah = new StringBuilder("Rishi");
        MutableString ms = new MutableString(blah);
        MutableString ms2 = ms.new MutableStringProtector(blah);
        StringBuilder mssb = ms2.getSb();
        StringBuilder sb = ms.getSb();

        sb.append("malicious");

        System.out.println("mssb: " + mssb.toString());
        System.out.println("sb: " + sb.toString());
    }

}