/**
 * A class demonstrating Rule 05: OBJ09-J: Compare classes and not class names.
 * from the SEI CERT Oracle Coding Standard for java.
 *
 * This rule is demonstrated with the provided Dog class.
 * Two instances of the Dog class are created and their classes are compared properly with the statement:
 * 
 *      fido.getClass() == champ.getClass() 
 * 
 * An improper example of class comparison would look like this:
 * 
 *      fido.getClass().getName().equals(champ.getClass().getName())
 * 
 * @author Emmett Connolly
 */
public class Dog {
    public String name;
    public String breed;
    public int age;

    /**
     * Class constructor
     * @param name
     * @param breed
     * @param age
     */
    public Dog (String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    /**
     * Main method to compare two instances of the Dog class
     * @param args
     */
    public static void main(String[] args) {
        Dog fido = new Dog("fido", "pitbull", 2);
        Dog champ = new Dog ("champ", "pug", 4);

        if (fido.getClass() == champ.getClass()){
            System.out.println("Objects 'fido' and 'champ' are from the same class");
        }
    }
}