package controller;

import model.Staff;
import storage.fileStaff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaffManager {
    List<Staff> ListStaff = new ArrayList<>();

    public StaffManager() {
    }

    public StaffManager(List<Staff> listStaff) {
        ListStaff = listStaff;
    }

    public List<Staff> getListStaff() {
        return ListStaff;
    }

    public void setListStaff(List<Staff> listStaff) {
        ListStaff = listStaff;
    }
    public void addStaff(Staff staff) throws IOException {
        ListStaff.add(staff);
        fileStaff.writefile(ListStaff);
    }
    public Staff findStaffbyCode(String code){
        Staff staff = null;
        for(int i =0;i<ListStaff.size();i++){
            if(ListStaff.get(i).getStaffCode().equals(code)){
                staff = ListStaff.get(i);
            }
        }
        return  staff;
    }
    public int getIndexbyCode(String code){
        int index =-1;
        for(int i =0;i<ListStaff.size();i++){
            if(ListStaff.get(i).getStaffCode().equals(code)){
                index = i;
            }
        }
        return index;
    }
    public void editStaff(int index,Staff staff){
        ListStaff.set(index,staff);
    }
    public void deleteStaff(Staff staff) throws IOException{
         ListStaff.remove(staff);
         fileStaff.writefile(ListStaff);
    }
    public void showAllStaff(){
        for (Staff staff:
             ListStaff) {
            System.out.println(staff);
        }
    }

    public  List<Staff> getstaffList() {
        try {
           ListStaff  = fileStaff.readFile();
        } catch (IOException var2) {
            var2.printStackTrace();
        } catch (ClassNotFoundException var3) {
            var3.printStackTrace();
        }

        return ListStaff;
    }
}
