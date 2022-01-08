package view.tm;

import javafx.scene.control.Button;

public class CustomerTM {
    private String NIC;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String roomNumber;
    private Button delete;
    private Button edit;

    public CustomerTM() {
    }

    public CustomerTM(String NIC, String name, String address, String contact, String email, String roomNumber,Button delete,Button edit) {
        this.setNIC(NIC);
        this.setName(name);
        this.setAddress(address);
        this.setContact(contact);
        this.setEmail(email);
        this.setRoomNumber(roomNumber);
        this.setDelete(delete);
        this.setEdit(edit);
    }



    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }
}
