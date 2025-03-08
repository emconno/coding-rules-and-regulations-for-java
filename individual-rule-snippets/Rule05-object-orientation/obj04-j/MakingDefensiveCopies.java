import java.util.Date;

/**
 * This class showcases OBJ04-J:  Provide mutable classes with copy 
 * functionality to safely allow passing instances to untrusted code
 * 
 * This class defines a mutable StringBuilder member, which is then 
 * defensively passed a copy to ensure that it is not mutable 
 * whenever we pass a copy of an instance to untrusted code.
 * 
 * @author Michael Rosenwinkel
 */
public class MakingDefensiveCopies{

/**
 * MakingDefensiveCopies class that protects mutable members with copy passing
 * @author Michael Rosenwinkel
 */
    private StringBuilder sb; 

    /**
     * Defensively copies string builder object so that the parameter cannot be modified any further.
     * @param obj
     */
    public MakingDefensiveCopies(MakingDefensiveCopies obj){
        this.sb = new StringBuilder(obj.getStringBuilder());
    }
    /**
     * Instantiates mutable class member without risking modification of StringBuilder passed 
     * as parameter.
     * @param sbInit
     */
    public MakingDefensiveCopies(StringBuilder sbInit){
        this.sb = new StringBuilder(sbInit.toString());
    }

    /**
     * Returns mutable member string builder as clone of member
     * @return StringBuilder object
     */
    public StringBuilder getStringBuilder(){
        return new StringBuilder(sb.toString());
    }

    /**
     * sets the mutable StringBuilder field without risking modification of 
     * StringBuilder passed as parameter.
     * @param s StringBuilder we use to modify internal StringBuilder member.
     */
    public void setStringBuilder(StringBuilder s){
        this.sb = new StringBuilder(s.toString());
    }

    /**
     * Main method that showcases above functionality in actual program
     * @param args not used
     */
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Rishi");
        MakingDefensiveCopies obj = new MakingDefensiveCopies(sb);

        MakingDefensiveCopies objCopy = new MakingDefensiveCopies(obj);

        //let this be a section of "untrusted" code
        StringBuilder maliciousSb = new StringBuilder("malicious");

        objCopy.setStringBuilder(maliciousSb);

        //this will not affect the date value stored in obj
        String objDateStr = obj.getStringBuilder().toString();

        String objCopyDateStr = objCopy.getStringBuilder().toString();

        System.out.println("object sb: " + objDateStr);
        System.out.println("object copy string: " + objCopyDateStr);
    }
}
