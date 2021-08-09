package model;

import java.io.Serializable;
import java.time.LocalDate;

public class BookRoom implements Serializable {
    private String codeBookRoom;
    private Customer customer;
    private Staff staff;
    private RoomHotel roomHotel;

    public BookRoom(String codeBookRoom,Customer customer, Staff staff, RoomHotel roomHotel) {
        this.customer = customer;
        this.staff = staff;
        this.roomHotel = roomHotel;
        this.codeBookRoom = codeBookRoom;
    }

    public String getCodeBookRoom() {
        return codeBookRoom;
    }

    public void setCodeBookRoom(String codeBookRoom) {
        this.codeBookRoom = codeBookRoom;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public RoomHotel getRoomHotel() {
        return roomHotel;
    }

    public void setRoomHotel(RoomHotel roomHotel) {
        this.roomHotel = roomHotel;
    }


    @Override
    public String toString() {
        return "BookRoom{" +
                "codeBookRoom='" + codeBookRoom + '\'' +
                ", customer=" + customer +
                ", staff=" + staff +
                ", roomHotel=" + roomHotel +
                '}';
    }
}
