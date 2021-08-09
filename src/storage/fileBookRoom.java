package storage;

import model.Bill;
import model.BookRoom;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileBookRoom {
    public static void writefile(List<BookRoom> bookRoomList) throws IOException {
        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("BookRoom.txt"));

        ois.writeObject(bookRoomList);
        ois.close();
    }

    public static List<BookRoom> readFile() throws IOException, ClassNotFoundException {
        List<BookRoom> list = new ArrayList<>();
        File file = new File("BookRoom.txt");
        if (file.length() > 0) {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream(file));
            list = (List<BookRoom>) out.readObject();
            out.close();
        }
        return list;
    }
}
