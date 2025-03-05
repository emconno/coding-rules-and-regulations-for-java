/**
 * Written by Dan Rascop
 * Program demonstrating the SEI CERT Oracle Coding Standard for Java - Recommendation OBJ55-J. Remove short-lived objects from long-lived container objects
 * Reference: https://wiki.sei.cmu.edu/confluence/display/java/OBJ55-J.+Remove+short-lived+objects+from+long-lived+container+objects
 */

import java.util.ArrayList;
import java.util.List;


class RemoveShortLivedObjectsFromLongLivedContainers {

    /**
     * Demonstrates the importance of removing short-lived objects from long-lived container objects.
     * 
     * This method creates a list of HotelRoom objects and fills it with 10 rooms.
     * It then sets one of the rooms to null to simulate removing a short-lived object
     * from a long-lived container.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        
        List<HotelRoom> hotel = new ArrayList<HotelRoom>();

        // fill the list with HotelRoom objects
        for (int i = 0; i < 10; i++) {
            hotel.add(new HotelRoom(i));
        }

        // Assume room 5 is no longer in use. We will set it to null to effectively remove it
        hotel.set(4, null);
    }


    static class HotelRoom {

        private int roomNumber;

        /**
         * Constructs a HotelRoom with the specified room number.
         *
         * @param roomNumber The room number of the hotel room.
         */
        public HotelRoom(int roomNumber){
            this.roomNumber = roomNumber;
        }

        /**
         * Returns the room number of the hotel room.
         *
         * @return The room number of the hotel room.
         */
        public int getRoomNumber() {
            return roomNumber;
        }
    }
}
