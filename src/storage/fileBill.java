package storage;

import model.Bill;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileBill {
    public static void writefile(List<Bill> billList) throws IOException {
        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("Bill.txt"));

        ois.writeObject(billList);
        ois.close();
    }

    public static List<Bill> readFile() throws IOException, ClassNotFoundException {
        List<Bill> list = new ArrayList<>();
        File file = new File("Bill.txt");
        if (file.length() > 0) {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream(file));
            list = (List<Bill>) out.readObject();
            out.close();
        }
        return list;
    }
}
