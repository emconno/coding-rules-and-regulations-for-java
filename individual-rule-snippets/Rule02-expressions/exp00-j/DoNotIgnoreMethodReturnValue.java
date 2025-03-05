/**
 * Written by Dan Rascop
 * Program demonstrating the SEI CERT Oracle Coding Standard for Java - Rule EXP00-J. Do not ignore values returned by methods
 * Reference: https://wiki.sei.cmu.edu/confluence/display/java/EXP00-J.+Do+not+ignore+values+returned+by+methods
 */

 
class DoNotIgnoreMethodReturnValue {

    /**
     * The main method demonstrates the importance of checking the return values of methods when invoking them.
     * A simple User object is created. Then we attempt to login with invalid credentials, ignoring login()'s return value.
     * Then, we attempt to login with invalid credentials; this time checking the return value,
     * and indicating success or failure.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        
        User user = new User("admin", "abc123");

        System.out.println("\nAttempting to login without checking return value...");
        user.login("admin", "xyz789");
        
        System.out.println("\nAttempting to login; this time checking return value...");
        if(user.login("admin", "xyz789")){
            System.out.println("Login successful!");
        } else{
            System.out.println("Failed to login: credentials do not match!");
        }
    }


    private static class User {

        private String username;
        private String password;
    
        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    
        public boolean login(String username, String password) {
            return username.equals(this.username) && password.equals(this.password);
        }
    }

}
