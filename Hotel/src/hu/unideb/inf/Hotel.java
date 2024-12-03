package hu.unideb.inf;

import java.util.Objects;

public class Hotel {
    private String hotelName;
    private int rooms;
    private int availableRooms;
    private int bookedRooms;

    /**
     * Parameterized constructor which inicialize all fields in Hotel class.
     * @param hotelName the name of the hotel
     * @param rooms the number of rooms in the hotel
     * @param availableRooms the number of available rooms in the hotel
     * @param bookedRooms the number of booked rooms in the hotel
     */

    public Hotel(String hotelName, int rooms, int availableRooms, int bookedRooms) {
        this.hotelName = hotelName;
        this.rooms = rooms;
        this.availableRooms = availableRooms;
        this.bookedRooms = bookedRooms;
    }

    /**
     * This method check there is available room in the hotel
     * @return true if there is available room, false otherwise
     */
    public boolean isRoomAvailable(){
        return availableRooms>0;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getRooms() {
        return rooms;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public int getBookedRooms() {
        return bookedRooms;
    }

    /**
     * This and other object equals if the rooms and hotelName filed equals
     * @param other the other object
     * @return true if this and other object equals, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Hotel hotel)) return false;
        return rooms == hotel.rooms && Objects.equals(hotelName, hotel.hotelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelName, rooms);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hotel{");
        sb.append("hotelName='").append(hotelName).append('\'');
        sb.append(", rooms=").append(rooms);
        sb.append(", availableRooms=").append(availableRooms);
        sb.append(", bookedRooms=").append(bookedRooms);
        sb.append('}');
        return sb.toString();
    }
}
