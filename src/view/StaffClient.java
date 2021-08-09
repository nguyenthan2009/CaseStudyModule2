package view;
import controller.StaffManager;
import model.Staff;
import storage.fileStaff;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StaffClient {
    public static void run(){
        List<Staff> staffList = null;
        try{
            staffList = fileStaff.readFile();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        StaffManager staffManager = new StaffManager(staffList);
        Scanner sc = new Scanner(System.in);
        int number =1;
        while(number!=0){
            System.out.println("ẤN 1 để thêm nhân viên");
            System.out.println("ẤN 2 để xoá nhân viên");
            System.out.println("Ấn 3 để xem tất cả nhân viên");
            int numbers = sc.nextInt();
            switch (numbers){
                case 1:
                    try {
                        sc.nextLine();
                        System.out.println("Nhập mã nhân viên");
                        String staffCode = sc.nextLine();
                        System.out.println("Nhập tên nhân viên");
                        String name = sc.nextLine();
                        System.out.println("Nhập số ngày làm của nhân viên");
                        int dayWork = sc.nextInt();
                        System.out.println("Nhập lương nhân viên nhận mỗi ngày");
                        double salary = sc.nextDouble();
                        Staff staff = new Staff(staffCode,name,dayWork,salary);
                        staffManager.addStaff(staff);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    sc.nextLine();
                    System.out.println("Đã thêm nhân viên, bạn muốn tiếp tục chương trình chứ");
                    String a = sc.nextLine();
                    if(a.equals("Tiếp tục")){
                        System.out.println("Tiếp tục nhé");
                    }else {
                        number =0;
                    }
                    break;

                case 2:
                    try {
                        sc.nextLine();
                        System.out.println("Nhập mã nhân viên bạn muốn xoá");
                        String name1 = sc.nextLine();
                        System.out.println(staffManager.findStaffbyCode(name1));
                        staffManager.deleteStaff(staffManager.findStaffbyCode(name1));
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    System.out.println("Đã xóa nhân viên, bạn muốn tiếp tục chương trình chứ");
                    String b = sc.nextLine();
                    if(b.equals("Tiếp tục")){
                        System.out.println("Tiếp tục nhé");
                    }else {
                        number =0;
                    }
                    break;
                case 3:
                    staffManager.showAllStaff();
                    sc.nextLine();
                    System.out.println("Đã show tất cả nhân viên, bạn muốn tiếp tục chứ");
                    String c = sc.nextLine();
                    if(c.equals("Tiếp tục")){
                        System.out.println("Tiếp tục nhé");
                    }else {
                        number =0;
                    }
                    break;
                default:
                    System.out.println("No choice");
                    break;
            }
        }

    }
}
