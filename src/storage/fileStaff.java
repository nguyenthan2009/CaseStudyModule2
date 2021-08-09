package storage;

import model.Staff;
import model.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileStaff {
    public static void writefile(List<Staff> StaffList) throws IOException {
        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("Staff.txt"));
        ois.writeObject(StaffList);
        ois.close();
    }

    public static List<Staff> readFile() throws IOException, ClassNotFoundException {
        List<Staff> list = new ArrayList<>();
        File file = new File("Staff.txt");
        if (file.length() > 0) {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream(file));
            list = (List<Staff>) out.readObject();
            out.close();
        }
        return list;
    }
}
