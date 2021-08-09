package controller;

import model.RoomHotel;
import storage.fileRoomHotel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private List<RoomHotel> ListRoom = new ArrayList<>();

    public RoomManager() {
    }

    public RoomManager(List<RoomHotel> listRoom) {
        ListRoom = listRoom;
    }

    public List<RoomHotel> getListRoom() {
        return ListRoom;
    }

    public void setListRoom(List<RoomHotel> listRoom) {
        ListRoom = listRoom;
    }

    public void addRoom(RoomHotel roomHotel) throws IOException {
        ListRoom.add(roomHotel);
        fileRoomHotel.writefile(ListRoom);

    }

    public RoomHotel findRoombyCode(String code) {
        RoomHotel roomHotel = null;
        for (int i = 0; i < ListRoom.size(); i++) {
            if (ListRoom.get(i).getRoomCode().equals(code)) {
                roomHotel = ListRoom.get(i);
            }
        }
        return roomHotel;
    }

    public int getIndexbyCode(String code) {
        int index = -1;
        for (int i = 0; i < ListRoom.size(); i++) {
            if (ListRoom.get(i).getRoomCode().equals(code)) {
                index = i;
            }
        }
        return index;
    }

    public void editRoom(int index, RoomHotel newHotel) throws IOException {
        ListRoom.set(index, newHotel);
        fileRoomHotel.writefile(ListRoom);
    }
    public void deleteRoom(RoomHotel roomHotel) throws  IOException{
        ListRoom.remove(roomHotel);
        fileRoomHotel.writefile(ListRoom);
    }

    public void showAllRoom() {
        for (RoomHotel roomHotel :
                ListRoom) {
            System.out.println(roomHotel);

        }
    }
    public void showfocusStatus(String status) {
        for (int i = 0; i < ListRoom.size(); i++) {
            if (ListRoom.get(i).getStatus().equals(status)) {
                System.out.println(status + ListRoom.get(i));
            }
        }
    }
    public boolean checkEmptyRoom(RoomHotel roomHotel){
       if(roomHotel.getStatus().equals("Phòng trống")){
           return true;
       }else {
           return false;
       }
    }
}
