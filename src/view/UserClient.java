package view;

import controller.UserManager;
import model.User;
import storage.fileUser;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserClient {
    public static void main(String[] args) {
        List<User> userList = null;
        try {
            userList = fileUser.readFile();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        UserManager userManager = new UserManager(userList);
        while (true){
            System.out.println("Ấn 1 để đăng kí tài khoản");
            System.out.println("Ấn 2 để xoá tài khoản");
            System.out.println("Ấn 3 để xem tất cả tài khoản");
            System.out.println("Ấn 0 để thoát");
            int number = sc.nextInt();
            switch (number){
                case 1:
                    try {
                       registration(userManager);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                case 2:
                    break;
                case 3:
                    userManager.showUser();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No choice");
                    break;
            }

            }

        }

    public static void  registration(UserManager userManager) throws IOException {
        Pattern pattern = Pattern.compile("^[a-z0-9]{8,16}$");
        Pattern pattern1 = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        Scanner sc = new Scanner(System.in);
        User User = new User();
        System.out.println("Mời bạn đăng kí tài khoản");
        while (true) {
            System.out.println("Mời bạn nhập tài khoản ");
            String user = sc.nextLine();
            boolean user1 = pattern.matcher(user).matches();
            if (user1&&(userManager.getNumberOfNameAccount(user)==0)) {
                User.setAccount(user);
                System.out.println("Tài khoản hợp lệ");
                break;
            } else {
                System.out.println("Tài khoản không hợp lệ or đã có trong hệ thống, mời nhập lại");
            }
        }
        while (true) {
            System.out.println("Mời bạn nhập mật khẩu ");
            String password = sc.nextLine();
            boolean password1 = pattern.matcher(password).matches();
            if (password1) {
                User.setPassword(password);
                System.out.println("Mật khẩu hợp lệ");
                break;
            } else {
                System.out.println("Mật khẩu không hợp lệ, mời nhập lại ");
            }
        }
        while (true) {
            System.out.println("Mời bạn nhập email ");
            String email = sc.nextLine();
            boolean email1 = pattern1.matcher(email).matches();
            if (email1) {
                User.setEmailUser(email);
                System.out.println("Email hợp lệ");
                break;
            } else {
                System.out.println("Email không hợp lệ, mời nhập lại");
            }
        }
        while (true) {
            System.out.println("Mời bạn nhập họ tên ");
            String userName = sc.nextLine();
            boolean userName1 = pattern.matcher(userName).matches();
            if (userName1) {
                User.setNameUser(userName);
                System.out.println("Họ tên  hợp lệ");
                break;
            } else {
                System.out.println("Họ tên không hợp lệ, mời nhập lại");
            }
        }
        userManager.addUser(User);

        System.out.println("Tài khoản đăng kí thành công");
    }
}



