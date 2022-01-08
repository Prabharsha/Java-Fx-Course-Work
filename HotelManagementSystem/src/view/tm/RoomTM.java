package view.tm;

import javafx.scene.control.Button;

public class RoomTM {
    private String roomNumber;
    private String roomAvailability;
    private Button available;

    public RoomTM() {
    }

    public RoomTM(String roomNumber, String roomAvailability, Button available) {
        this.setRoomNumber(roomNumber);
        this.setRoomAvailability(roomAvailability);
        this.setAvailable(available);
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

    public Button getAvailable() {
        return available;
    }

    public void setAvailable(Button available) {
        this.available = available;
    }
}
