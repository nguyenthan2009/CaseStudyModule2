package view;
import controller.RoomManager;
import model.RoomHotel;
import model.Staff;
import storage.fileRoomHotel;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RoomHotelClient {
    public static void run() {
        List<RoomHotel> roomHotelList = null;
        try{
            roomHotelList = fileRoomHotel.readFile();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        RoomManager roomManager = new RoomManager(roomHotelList);
        Scanner sc = new Scanner(System.in);
        int number =1;
        while(number!=0){
            System.out.println("ẤN 1 để thêm một phòng");
            System.out.println("ẤN 2 để sửa thông tin 1 phòng");
            System.out.println("Ấn 3 để xoá 1 phòng");
            System.out.println("Ấn 4 để hiện các phòng theo trạng thái");
            System.out.println("Ấn 5 để hiện thông tin tất cả các phòng");
            int numbers = sc.nextInt();
            switch (numbers){
                case 1:
                    try {
                        sc.nextLine();
                        System.out.println("Nhập mã phòng");
                        String roomCode = sc.nextLine();
                        System.out.println("Nhập tên phòng");
                        String nameRoom = sc.nextLine();
                        System.out.println("Nhập số toilet của phòng");
                        int toilet = sc.nextInt();
                        System.out.println("Nhập số lượng phòng ngủ của phòng");
                        int bedRoom = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Nhập trạng thái của phòng");
                        String status = sc.nextLine();
                        System.out.println("Nhập giá phòng");
                        double priceRoom = sc.nextDouble();
                        RoomHotel roomHotel = new RoomHotel(roomCode,nameRoom,toilet,bedRoom,status,priceRoom);
                        roomManager.addRoom(roomHotel);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    sc.nextLine();
                    System.out.println("Đã thêm một phòng,bạn muốn tiếp tục chương trình chứ");
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
                        System.out.println("Nhập mã phòng bạn muốn sửa");
                        String code = sc.nextLine();
                        System.out.println("Nhập mã  mới cho phòng");
                        String roomCode = sc.nextLine();
                        System.out.println("Nhập tên mới phòng");
                        String nameRoom = sc.nextLine();
                        System.out.println("Nhập số toilet mới của phòng");
                        int toilet = sc.nextInt();
                        System.out.println("Nhập số lượng phòng ngủ mới của phòng");
                        int bedRoom = sc.nextInt();
                        System.out.println("Nhập trạng thái mới của phòng");
                        String status = sc.nextLine();
                        System.out.println("Nhập giá mới của phòng");
                        double priceRoom = sc.nextDouble();
                        RoomHotel newRoomHotel = new RoomHotel(roomCode,nameRoom,toilet,bedRoom,status,priceRoom);
                        roomManager.editRoom(roomManager.getIndexbyCode(code),newRoomHotel);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    sc.nextLine();
                    System.out.println("Đã sửa 1 phòng, bạn muốn tiếp tục chương trình chứ");
                    String b = sc.nextLine();
                    if(b.equals("Tiếp tục")){
                        System.out.println("Tiếp tục nhé");
                    }else {
                        number =0;
                    }
                    break;
                case 3:
                    try{
                        sc.nextLine();
                    System.out.println("Nhập mã phòng bạn muốn xoá");
                    String roomCode = sc.nextLine();
                    roomManager.deleteRoom(roomManager.findRoombyCode(roomCode));
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    sc.nextLine();
                    System.out.println("Đã xóa 1 phòng, bạn muốn tiếp tục chương trình chứ");
                    String c = sc.nextLine();
                    if(c.equals("Tiếp tục")){
                        System.out.println("Tiếp tục nhé");
                    }else {
                        number =0;
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Nhập trạng trái của phòng");
                    String status = sc.nextLine();
                    roomManager.showfocusStatus(status);
                    System.out.println("Đã show phòng theo trạng thái , bạn muốn tiếp tục chương trình chứ");
                    String d = sc.nextLine();
                    if(d.equals("Tiếp tục")){
                        System.out.println("Tiếp tục nhé");
                    }else {
                        number =0;
                    }
                    break;
                case 5:
                    roomManager.showAllRoom();
                    sc.nextLine();
                    System.out.println("Đã show tất cả các phòng, bạn muốn tiếp tục chương trình chứ");
                    String e = sc.nextLine();
                    if(e.equals("Tiếp tục")){
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
