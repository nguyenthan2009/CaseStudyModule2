package view;

import controller.*;
import model.*;
import storage.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BillClient {
    public static void run() {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Bill> billList = null;
        try {
            billList = fileBill.readFile();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BillManager billManager = new BillManager(billList);
        Scanner sc = new Scanner(System.in);
        int number = 1;
        while (number != 0) {
            System.out.println("ẤN 1 thêm 1 hóa đơn");
            System.out.println("ẤN 2 sửa 1 hóa đơn");
            System.out.println("Ấn 3 để xem tất cả hóa đơn");
            System.out.println("Ấn 4 để xem thu nhập của tháng");
            System.out.println("Ấn 5 để xem trạng thái của phòng trong khoảng thời gian");
            int numbers = sc.nextInt();
            switch (numbers) {
                case 1:
                    try {
                        sc.nextLine();
                        System.out.println("Nhập mã bill");
                        String billCode = sc.nextLine();
                        System.out.println("Nhập mã đặt phòng");
                        String roomCode = sc.nextLine();
                        BookRoomManager bookRoomManager = new BookRoomManager(bookRoomList);
                        BookRoom bookRoom = bookRoomManager.findBookRoombyCode(roomCode);
                        if (bookRoom == null) {
                            System.out.println("Không tìm thấy mã đặt phòng");
                        }
                        RoomHotel roomHotel = bookRoom.getRoomHotel();
                        roomHotel.setStatus("Phòng trống");
                        RoomManager roomManager = new RoomManager(roomHotelList);
                        roomManager.editRoom(roomManager.getIndexbyCode(roomHotel.getRoomCode()), roomHotel);
                        System.out.println("Nhập ngày bắt đầu thuê");
                        LocalDate startDay = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        System.out.println("Nhập ngày kết thúc thuê");
                        LocalDate endDay = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        if (bookRoom != null) {
                            Bill bill = new Bill(billCode, bookRoom, startDay, endDay);
                            billManager.addBill(bill);
                            bookRoomManager.deleteBookRoom(bookRoom);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                sc.nextLine();
                System.out.println("Thêm bill thành công, bạn muốn tiếp tục chương trình chứ");
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
                        System.out.println("Nhập mã  Bill bạn muốn sửa");
                        String billCode = sc.nextLine();
                        System.out.println("Nhập mã Bill mới bạn muốn");
                        String newBillCode = sc.nextLine();
                        System.out.println("Nhập mã đặt phòng mới");
                        String newRoomCode = sc.nextLine();
                        BookRoomManager bookRoomManager = new BookRoomManager(bookRoomList);
                        BookRoom bookRoom = bookRoomManager.findBookRoombyCode(newRoomCode);
                        if (bookRoom == null) {
                            System.out.println("Không tìm thấy phòng");
                        }
                        RoomHotel roomHotel = bookRoom.getRoomHotel();
                        roomHotel.setStatus("Phòng trống");
                        RoomManager roomManager = new RoomManager(roomHotelList);
                        roomManager.editRoom(roomManager.getIndexbyCode(roomHotel.getRoomCode()), roomHotel);
                        System.out.println("Nhập ngày bắt đầu thuê ");
                        LocalDate startDay = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        System.out.println("Nhập ngày kết thúc thuê");
                        LocalDate endDay = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        if (bookRoom != null) {
                            Bill bill = new Bill(newBillCode, bookRoom, startDay, endDay);
                            billManager.editBill(billManager.getIndexByCode(billCode), bill);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sc.nextLine();
                    System.out.println(" Sửa Bill phòng thành công, bạn muốn tiếp tục chương trình chứ");
                    String b = sc.nextLine();
                    if(b.equals("Tiếp tục")){
                        System.out.println("Tiếp tục nhé");
                    }else {
                        number =0;
                    }
                    break;
                case 3:
                    billManager.showAllBill();
                   sc.nextLine();
                   System.out.println(" Đã show tất cả các bill, bạn muốn tiếp tục chương trình chứ");
                   String c = sc.nextLine();
                   if (c.equals("Tiếp tục")) {
                    System.out.println("Tiếp tục nhé");
                   } else {
                    number = 0;
                  }
                    break;

                case 4:
                    System.out.println("Nhập ngày đầu của tháng muốn xem");
                    LocalDate startMonth = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    System.out.println("Nhập ngày cuối của tháng muốn xem");
                    LocalDate endMonth = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    double totalMoneyInMonth = billManager.totalMoneyInMonth(startMonth, endMonth);
                    System.out.println("Tổng thu nhập của tháng vừa nhập là" + totalMoneyInMonth);
                    sc.nextLine();
                    System.out.println(" Hiện thu nhập của tháng  thành công, bạn muốn tiếp tục chương trình chứ");
                    String d = sc.nextLine();
                    if(d.equals("Tiếp tục")){
                        System.out.println("Tiếp tục nhé");
                    }else {
                        number =0;
                    }
                    break;
                case 5:
                    System.out.println("Nhập ngày bắt đầu");
                    LocalDate start = LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt());
                    System.out.println("Nhập ngày kết thúc");
                    LocalDate end = LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt());
                    sc.nextLine();
                    System.out.println("nhập mã phòng muốn xem trạng thái trong khoảng thời gian trên");
                    String codeRoom = sc.nextLine();
                    billManager.getManager().sort(billManager);
                    List<Bill> billList1 = billManager.getListBookInTime(start,end,codeRoom);
                    for(int i=0;i<billList1.size();i++){
                        System.out.println(codeRoom + "có khách ở từ" +billList1.get(i).getStartDay()+"tới"+ billList1.get(i).getEndDay() +
                                "và trống từ" + billList1.get(i).getEndDay().plusDays(1)+ "tới" + billList1.get(i=i+1).getStartDay()
                       );
                    }
                    sc.nextLine();
                    System.out.println(" Đã hiện trạng thái của phòng trong khoảng thời gian trên, bạn muốn tiếp tục chương trình chứ");
                    String e = sc.nextLine();
                    if(e.equals("Tiếp tục")){
                        System.out.println("Tiếp tục nhé");
                    }else {
                        number =0;
                    }
                    default:
                    System.out.println("No choice");
                    break;
                }
            }


        }
    }

