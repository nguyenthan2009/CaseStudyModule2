package storage;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileUser {
    public static void writefile(List<User> userListtList) throws IOException {
        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("user.txt"));

        ois.writeObject(userListtList);
        ois.close();
    }

    public static List<User> readFile() throws IOException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
        File file = new File("user.txt");
        if (file.length() > 0) {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream(file));
            list = (List<User>) out.readObject();
            out.close();
        }
        return list;
    }
}
