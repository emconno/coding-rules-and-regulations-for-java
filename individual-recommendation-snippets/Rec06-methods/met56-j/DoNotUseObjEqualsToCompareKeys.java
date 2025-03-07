/**
 * @author Dan Rascop
 * Program demonstrating the SEI CERT Oracle Coding Standard for Java - Recommendation MET56-J. Do not use Object.equals() to compare cryptographic keys
 * Reference: https://wiki.sei.cmu.edu/confluence/display/java/MET56-J.+Do+not+use+Object.equals%28%29+to+compare+cryptographic+keys
 */

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


class DoNotUseObjEqualsToCompareKeys {

    /**
     * Main method to demonstrate the importance of not using Object.equals() to compare cryptographic keys.
     * It generates two different RSA public keys and compares them using Arrays.equals().
     *
     * @param args command-line arguments (not used)
     * @throws NoSuchAlgorithmException if the specified algorithm is not available
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {

        // Generate two public RSA keys
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair1 = keyGen.generateKeyPair();
        KeyPair pair2 = keyGen.generateKeyPair();

        Key key1 = pair1.getPublic();
        Key key2 = pair2.getPublic();

        System.out.println("Using Arrays.equals() with different keys: " + keysAreEqual(key1, key2));
    }


    /**
     * Compares two cryptographic keys using their encoded forms.
     *
     * @param key1 the first key to compare
     * @param key2 the second key to compare
     * @return true if the encoded forms of the keys are equal, false otherwise
     */
    private static boolean keysAreEqual(Key key1, Key key2) {
        if (key1 == null || key2 == null) {
            return false;
        }
        return Arrays.equals(key1.getEncoded(), key2.getEncoded());
    }
}