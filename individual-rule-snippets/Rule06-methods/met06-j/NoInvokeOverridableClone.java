/**
 * This file showcases Rule MET06-J: Do not invoke overridable methods in clone
 * 
 * This file contains a Cloneable class that ensures that no overridable methods are invoked
 * in the clone class, which may lead to security vulnerabilities from malicious sub classes. 
 * 
 * @author Michael Rosenwinkel
 */

public class NoInvokeOverridableClone implements Cloneable {
    /**
     * This class implements a clone() method, and ensures that no 
     * overridable methods are invoked in that clone method.
     * @author Michael Rosenwinkel
     */
    public int x;

    /**
     * Class constructor that instantiates x variable using param.
     * @param xInit Sets the value of the variable x
     */
    NoInvokeOverridableClone(int xInit) {
        this.x = xInit;
    }

    /**
     * Clone method that ensures that no overridable methods are called during its
     * execution.
     */
    public Object clone() throws CloneNotSupportedException {
        final NoInvokeOverridableClone clone = (NoInvokeOverridableClone) super.clone();
        clone.doSomething();
        clone.x = 5;
        return clone;
    }

    /**
     * Method that ensures that it itself cannot be overridden (potentially due to a 
     * malicious subclass)
     */
    public final void doSomething() {
        System.out.println(this.x);
    }

    public class Sub extends NoInvokeOverridableClone {
        /**
         * This class is a subclass of clone that does not attempt to override 
         * methods of the super class to ensure good security practice. 
         * @author Michael Rosenwinkel
         */

        /**
         * Class constructor that uses super class constructor to instantiate member x. 
         * @param x instantiates x value.
         */
        Sub(int x) {
            super(x);
        }
    
        /**
         * Clone of subclass that does not try to execute overridable functions which can lead
         * to security vulnerabilities and inconsistent object state.
         */
        public Object clone() throws CloneNotSupportedException {
            final Sub clone = (Sub) super.clone();
            clone.doSomething();
            return clone;
        }
    
    

    }

    /**
     * Method meant to showcase features of the NoInvokeOverridableClone class.
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        int y = 25;

        NoInvokeOverridableClone obj = new NoInvokeOverridableClone(y);
        NoInvokeOverridableClone obj2 = obj.new Sub(y);
        obj2.clone();
    }
}