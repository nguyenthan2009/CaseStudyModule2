package view;

import controller.BookRoomManager;
import controller.CustomerManager;
import controller.RoomManager;
import controller.StaffManager;
import model.*;
import storage.fileBookRoom;
import storage.fileCustomer;
import storage.fileRoomHotel;
import storage.fileStaff;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BookClient {
    public static void run() {
        List<Customer> customerList = null;
        try {
            customerList = fileCustomer.readFile();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Staff> staffList = null;
        try {
            staffList = fileStaff.readFile();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<RoomHotel> roomHotelList = null;
        try {
            roomHotelList = fileRoomHotel.readFile();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<BookRoom> bookRoomList = null;
        try {
            bookRoomList = fileBookRoom.readFile();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BookRoomManager bookRoomManager = new BookRoomManager(bookRoomList);
        Scanner sc = new Scanner(System.in);
        int number = 1;
        while (number != 0) {
            System.out.println("ẤN 1 để book phòng cho khách");
            System.out.println("ẤN 2 sửa 1 BookRoom");
            System.out.println("Ấn 3 để xóa 1 BookRoom");
            System.out.println("ẤN 4 để xem tất cả BookRoom");
            System.out.println("Ấn 0 để thoát chương trình");
            int numbers = sc.nextInt();
            switch (numbers) {
                case 1:
                    try {
                        sc.nextLine();
                        System.out.println("Nhập mã đặt phòng");
                        String bookCode = sc.nextLine();
                        System.out.println("Nhập tên khách hàng");
                        String customerName = sc.nextLine();
                        CustomerManager customerManager = new CustomerManager(customerList);
                        Customer customer = customerManager.findCustomerbyName(customerName);
                        if (customer == null) {
                            System.out.println("không tìm thấy");
                        }
                        System.out.println("Nhập mã nhân viên");
                        String staffCode = sc.nextLine();
                        StaffManager staffManager = new StaffManager(staffList);
                        Staff staff = staffManager.findStaffbyCode(staffCode);
                        if (staff == null) {
                            System.out.println("không tìm thấy");
                        }
                        System.out.println("Nhập mã phòng");
                        String roomCode = sc.nextLine();
                        RoomManager roomManager = new RoomManager(roomHotelList);
                        RoomHotel roomHotel = roomManager.findRoombyCode(roomCode);
                        if (roomHotel == null) {
                            System.out.println("Không tìm thấy");
                        }else {
                            if (roomManager.checkEmptyRoom(roomHotel)) {
                                roomHotel.setStatus("Đang ở");
                                roomManager.editRoom(roomManager.getIndexbyCode(roomCode), roomHotel);
                                if (customer != null && staff != null && roomHotel != null) {
                                    BookRoom bookRoom = new BookRoom(bookCode, customer, staff, roomHotel);
                                    bookRoomManager.addBookRoom(bookRoom);
                                }
                            } else {
                                System.out.println("Phòng hiện có người đang thuê");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Thông tin chưa chính xác, mời nhập lại");
                    }
                    sc.nextLine();
                    System.out.println("Book phòng thành công, bạn muốn tiếp tục chương trình chứ");
                    String a = sc.nextLine();
                    if(a.equals("Tiếp tục")){
                        System.out.println("Tiếp tục nhé");
                    }else {
                        number =0;
                    }
                    break;
                case 2:
                    try{
                        sc.nextLine();
                        System.out.println("Nhập mã đặt Phòng bạn muốn sửa");
                        String bookCode = sc.nextLine();
                        System.out.println("Nhập mã đặt phòng mới");
                        String newBookCode = sc.nextLine();
                        System.out.println("Nhập tên khách hàng ");
                        String customerName = sc.nextLine();
                        CustomerManager customerManager = new CustomerManager(customerList);
                        Customer customer = customerManager.findCustomerbyName(customerName);
                        if (customer == null) {
                            System.out.println("không tìm thấy");
                        }
                        System.out.println("Nhập mã nhân viên");
                        String staffCode = sc.nextLine();
                        StaffManager staffManager = new StaffManager(staffList);
                        Staff staff = staffManager.findStaffbyCode(staffCode);
                        if (staff == null) {
                            System.out.println("không tìm thấy");
                        }
                        System.out.println("Nhập mã phòng");
                        String roomCode = sc.nextLine();
                        RoomManager roomManager = new RoomManager(roomHotelList);
                        RoomHotel roomHotel = roomManager.findRoombyCode(roomCode);
                        if (roomHotel == null) {
                            System.out.println("Không tìm thấy");
                        }else {
                            if (roomManager.checkEmptyRoom(roomHotel)) {
                                roomHotel.setStatus("Đang ở");
                                roomManager.editRoom(roomManager.getIndexbyCode(roomCode), roomHotel);
                                if (customer != null && staff != null && roomHotel != null) {
                                    BookRoom bookRoom = new BookRoom(newBookCode, customer, staff, roomHotel);
                                    bookRoomManager.editBookRoom(bookRoomManager.getIndexbyCode(bookCode),bookRoom);
                                }
                            } else {
                                System.out.println("Phòng hiện có người đang thuê");
                            }
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                        System.out.println("Thông tin chưa chính xác, mời nhập lại");
                    }
                    sc.nextLine();
                    System.out.println(" Sửa Book phòng thành công, bạn muốn tiếp tục chương trình chứ");
                    String b = sc.nextLine();
                    if(b.equals("Tiếp tục")){
                        System.out.println("Tiếp tục nhé");
                    }else {
                        number =0;
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Nhập mã đặt phòng bạn muốn xoá ");
                        String codeRoom = sc.nextLine();
                        bookRoomManager.deleteBookRoom(bookRoomManager.findBookRoombyCode(codeRoom));
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    sc.nextLine();
                    System.out.println(" Xoá Book phòng thành công, bạn muốn tiếp tục chương trình chứ");
                    String c = sc.nextLine();
                    if(c.equals("Tiếp tục")){
                        System.out.println("Tiếp tục nhé");
                    }else {
                        number =0;
                    }
                    break;

                    case 4:
                    bookRoomManager.showAll();
                    sc.nextLine();
                    System.out.println("Đã show tất cả đặt phòng của khách hiện tại, bạn muốn tiếp tục chương trình chứ");
                    String d = sc.nextLine();
                    if(d.equals("Tiếp tục")){
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
