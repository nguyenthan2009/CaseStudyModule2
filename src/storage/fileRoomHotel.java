package storage;

import model.RoomHotel;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileRoomHotel {
    public static void writefile(List<RoomHotel> roomHotelList) throws IOException {
        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("roomHotel.txt"));

        ois.writeObject(roomHotelList);
        ois.close();
    }

    public static List<RoomHotel> readFile() throws IOException, ClassNotFoundException {
        List<RoomHotel> list = new ArrayList<>();
        File file = new File("roomHotel.txt");
        if (file.length() > 0) {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream(file));
            list = (List<RoomHotel>) out.readObject();
            out.close();
        }
        return list;
    }
}
