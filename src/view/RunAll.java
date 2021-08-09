package view;

import controller.UserManager;
import model.User;
import storage.fileUser;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RunAll {
    public static void main(String[] args) {
        StaffClient staffClient = new StaffClient();
        RoomHotelClient roomHotelClient = new RoomHotelClient();
        CustomerClient customerClient = new CustomerClient();
        BookClient bookClient = new BookClient();
        BillClient billClient = new BillClient();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Đăng nhập để vào hệ thống");
            System.out.println("Mời bạn nhập tài khoản");
            String accountName = sc.nextLine();
            System.out.println("Mời bạn nhập mật khẩu");
            String password = sc.nextLine();
            try {
                if (login(accountName, password)) {
                    System.out.println("Đăng nhập thành công");
                    break;
                }else {
                    System.out.println("Đăng nhập thất bại");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        String a = sc.nextLine();
        while(true){
            System.out.println("Ấn 1 để quản lý nhân viên");
            System.out.println("Ấn 2 để quản lý khách ");
            System.out.println("Ấn 3 để quản lý Phòng khách sạn");
            System.out.println("Ấn 4 để quản lý đặt phòng cho khách");
            System.out.println("Ấn 5 để quản lý Bill");
            System.out.println("Ấn 0 để thoát chương trình");
            int number = sc.nextInt();
            switch (number){
                case 1:
                    staffClient.run();
                    break;
                case 2:
                    customerClient.run();
                    break;
                case 3:
                    roomHotelClient.run();
                    break;
                case 4:
                    bookClient.run();
                    break;
                case 5:
                    billClient.run();
                    break;
                case 0:
                    System.exit(0);
                System.out.println("No choice");
                    break;
            }

        }

    }
    public static  boolean login(String accountName,String password) throws  ClassNotFoundException {
        try{
        List<User> users = fileUser.readFile();
        UserManager userManager = new UserManager(users);
          for(int i =0; i<users.size();i++){
              if(users.get(i).getAccount().equals(accountName)&&users.get(i).getPassword().equals(password)){
                  return true;
              }
          }
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

}
