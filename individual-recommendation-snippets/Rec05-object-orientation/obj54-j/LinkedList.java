/**
 * A class demonstrating Recommendation 05: 
 * OBJ54-J: Do not attempt to help the garbage collector by setting local reference variables to null
 * from the SEI CERT Oracle Coding Standard for java.
 *
 * This recommendation is demonstrated with the use a LinkedList class that contains a remove method.
 * This method finds and removes a node from a linked list. This is accomplished by setting the previous 
 * Node’s next pointer to point to the target Node’s next pointer. The target node is never manually set 
 * to null; the garbage collector handles the unreachable node.
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
     * Removes a node from the list given the data of the node to be removed.
     * @param data
     */
    public void remove(String data) {
        Node current = this.head;
        Node prev = null;
        while (current != null) {
            if (current.data == data) {
                if (current == this.head) {
                    this.removeHead();
                    return;
                } else {
                    prev.setNext(current.getNext());
                    return;
                }
            }
            prev = current;
            current = current.getNext();

        }
        System.out.println("*** SPECIFIED NODE NOT FOUND ***");
    }


    
    /**
     * Converts the elements of the list into a string
     */
    public String toString() {
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
     * Main method to test the functionality of the remove method.
     * @param args
     */
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.addToHead("red");
        myList.addToHead("blue");
        myList.addToHead("green");
        System.out.println("Linked List:");
        System.out.println(myList.toString());

        myList.remove("blue");
        System.out.println("\nLinked List after removing blue:");
        System.out.println(myList.toString());
    }
}




