package model;

public class RoomsManage {
    private String roomNumber;
    private String roomType;

    public RoomsManage() {
    }

    public RoomsManage(String roomNumber, String roomType) {
        this.setRoomNumber(roomNumber);
        this.setRoomType(roomType);
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}

