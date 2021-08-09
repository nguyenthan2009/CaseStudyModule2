package model;

import java.io.Serializable;

public class RoomHotel implements Serializable {
    private String roomCode;
    public String nameRoom;
    private int toilet;
    private int bedRoom;
    private String status;
    private  double roomPrice;

    public RoomHotel(String roomCode, String nameRoom, int toilet, int bedRoom, String status, double roomPrice) {
        this.roomCode = roomCode;
        this.nameRoom = nameRoom;
        this.toilet = toilet;
        this.bedRoom = bedRoom;
        this.status = status;
        this.roomPrice = roomPrice;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public int getToilet() {
        return toilet;
    }

    public void setToilet(int toilet) {
        this.toilet = toilet;
    }

    public int getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(int bedRoom) {
        this.bedRoom = bedRoom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    @Override
    public String toString() {
        return "model.RoomHotel{" +
                "roomCode='" + roomCode + '\'' +
                ", nameRoom='" + nameRoom + '\'' +
                ", toilet=" + toilet +
                ", bedRoom=" + bedRoom +
                ", status='" + status + '\'' +
                ", roomPrice=" + roomPrice +
                '}';
    }
}
