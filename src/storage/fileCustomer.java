package storage;

import model.Customer;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileCustomer {
    public static void writefile(List<Customer> customersList) throws IOException {
        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("Customer.txt"));

        ois.writeObject(customersList);
        ois.close();
    }

    public static List<Customer> readFile() throws IOException, ClassNotFoundException {
        List<Customer> list = new ArrayList<>();
        File file = new File("Customer.txt");
        if (file.length() > 0) {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream(file));
            list = (List<Customer>) out.readObject();
            out.close();
        }
        return list;
    }
}
