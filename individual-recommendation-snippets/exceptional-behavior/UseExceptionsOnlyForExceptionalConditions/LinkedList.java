/**
 * A class demonstrating Recommendation 07: ERR50-J. Use exceptions only for exceptional conditions 
 * from the SEI CERT Oracle Coding Standard for java.
 *
 * This recommendation is demonstrated with the use a LinkedList class that contains the methods:
 * toStringGood and toStringBad.
 * 
 * toStringGood is compliant with recommendation ERR50-J. toStringBad is not. toString Bad uses
 * a try-catch statement to detect the end of the linked list. This is not an exceptional case,
 * so an exception should not be used. It is better to provide the while loop with a proper
 * condition to detect the end of the linked list, as toStringGood does, even though both 
 * toStringGood and toStringBad are functional.
 * @author Emmett Connolly
 */

public class LinkedList {
    /**
     * A nested class implementing the node data structure used for singly-linked lists. Only String data is accepted.
     * @author Emmett Connolly
     */
    public class Node {
        public String data; //stores node data
        private Node next; //stores the next node

        /**
         * Class Constructor specifying the value of the node's data.
         * @param data
         */
        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Retrieves the next node in the list.
         * @return the pointer to the next node.
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Sets the value of the next node.
         * @param node
         */
        public void setNext(Node node) {
            this.next = node;
        }
        
    }

    public Node head; //stores the head of the list

    /**
     * Class constructor
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * Class constructor specifying the node to set as the head of the list.
     * @param node
     */
    public LinkedList(Node node) {
        this.head = node;
    }

    /**
     * Adds a node to the head of the list given the string data of the new node.
     * @param data
     */
    public void addToHead(String data) {
        Node newHead = new Node(data);
        Node oldHead = this.head;
        if (oldHead != null) {
            newHead.setNext(oldHead);
        }
        this.head = newHead;
    }

    /**
     * Removes the head of the list.
     */
    public void removeHead() {
        if (this.head == null) {
            return;
        }
        this.head = this.head.getNext();

    }
    
    /**
     * Converts the elements of the list into a string in a recommendation-compliant way
     */
    public String toStringGood() {
        Node current = this.head;
        StringBuilder list = new StringBuilder();
        while (current != null) {
            list.append(current.data + " -> ");
            current = current.getNext();
        }
        list.append("null");
        return list.toString();
    }

    /**
     * Converts the elements of the list into a string in a way that is non-compliant with the recommendation
     */
    public String toStringBad() {
        Node current = this.head;
        StringBuilder list = new StringBuilder();
        try {
            while (true) {
                list.append(current.data + " -> ");
                current = current.getNext();
            }
        } catch (NullPointerException e) {
            
        }
        
        list.append("null");
        return list.toString();
    }
    
    /**
     * Main method to test the functionality of the toStringGood and toStringBad methods.
     * @param args
     */
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.addToHead("red");
        myList.addToHead("blue");
        myList.addToHead("green");
        System.out.println("Print with toStringBad:");
        System.out.println(myList.toStringBad());

        System.out.println("\nPrint with toStringGood:");
        System.out.println(myList.toStringGood());
    }
}




