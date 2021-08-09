package controller;

import model.Bill;
import model.RoomHotel;
import storage.fileBill;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BillManager implements Comparator<Bill> {
    List<Bill> manager = new ArrayList<>();

    public BillManager(List<Bill> manager) {
        this.manager = manager;
    }

    public List<Bill> getManager() {
        return manager;
    }

    public void setManager(List<Bill> manager) {
        this.manager = manager;
    }
    public void addBill(Bill bill) throws IOException {
        manager.add(bill);
        fileBill.writefile(manager);
    }
    public Bill findBillbyCode(String code){
        Bill  bill = null;
        for(int i=0;i<manager.size();i++){
            if(manager.get(i).getBillCode().equals(code)){
                bill = manager.get(i);
            }
        }
        return bill;
    }
    public int getIndexByCode(String code){
        int index = -1;
        for (int i=0;i<manager.size();i++){
            if(manager.get(i).getBillCode().equals(code)) {
                 index = i;
            }
        }
        return index;
    }
    public void editBill(int index,Bill newBill)throws IOException{
        manager.set(index,newBill);
        fileBill.writefile(manager);
    }
    public void deleteBill(Bill bill) throws IOException{
        manager.remove(bill);
        fileBill.writefile(manager);
    }
    public void showAllBill(){
        for (Bill bill:
             manager) {
            System.out.println(bill);
        }
    }
    public double totalMoneyInMonth(LocalDate startMonth,LocalDate endMonth){
         double totalMoney = 0;
        for(int i=0;i<manager.size();i++){
           if((manager.get(i).getStartDay().isAfter(startMonth))&&(manager.get(i).getEndDay().isBefore(endMonth))){
               totalMoney += manager.get(i).getMoneyRoom();
           }
        }
        return totalMoney;
    }
    public List<Bill> getListBookInTime(LocalDate localDate1, LocalDate localDate2, String codeRoom){
             List<Bill> billList = new ArrayList<>();
       for (int i=0;i<manager.size();i++){
             if(manager.get(i).getBookRoom().getRoomHotel().getRoomCode().equals(codeRoom)&& manager.get(i).getStartDay().isAfter(localDate1)&&manager.get(i).getEndDay().isBefore(localDate2)){
                 billList.add(manager.get(i));
             }
       }
       return  billList;
   }

    @Override
    public int compare(Bill o1, Bill o2) {
        return o1.getStartDay().compareTo(o2.getStartDay());
    }
}