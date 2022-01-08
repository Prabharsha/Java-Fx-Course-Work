package model;

public class Customer {
    private String NIC;
    private String name;
    private String address;
    private String contact;
    private String email;
    public Customer() {
    }

    public Customer(String NIC, String name, String address, String contact, String email, String roomNum) {
        this.NIC = NIC;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.roomNum = roomNum;
    }

    private String roomNum;

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

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
}
