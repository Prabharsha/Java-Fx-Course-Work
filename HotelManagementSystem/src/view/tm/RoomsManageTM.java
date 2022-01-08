package view.tm;

import javafx.scene.control.Button;

public class RoomsManageTM {
    private String roomNumber;
    private String roomType;
    private Button delete;
    private Button edit;

    public RoomsManageTM() {
    }

    public RoomsManageTM(String roomNumber, String roomType, Button delete, Button edit) {
        this.setRoomNumber(roomNumber);
        this.setRoomType(roomType);
        this.setDelete(delete);
        this.setEdit(edit);
    }


    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
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

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }
}
