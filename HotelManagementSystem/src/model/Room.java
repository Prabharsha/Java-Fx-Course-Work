package model;

public class Room {
    private String roomNumber;
    private String roomAvailability;

    public Room() {
    }

    public Room(String roomNumber, String roomAvailability) {
        this.setRoomNumber(roomNumber);
        this.setRoomAvailability(roomAvailability);
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(String roomAvailability) {
        this.roomAvailability = roomAvailability;
    }
}
