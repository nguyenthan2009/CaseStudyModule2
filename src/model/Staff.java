package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Staff implements Serializable {
    private String staffCode;
    private String staffName;
    private int workDay;
    private double  salary;

    public Staff(String staffCode, String staffName, int workDay, double salary) {
        this.staffCode = staffCode;
        this.staffName = staffName;
        this.workDay = workDay;
        this.salary = salary;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getActualsalary(){
        return salary*workDay;
    }

    @Override
    public String toString() {
        return "model.Staff{" +
                "staffCode='" + staffCode + '\'' +
                ", staffName='" + staffName + '\'' +
                ", workDay=" + workDay +
                ", salary=" + salary + "  " + "Actualsalary=" +getActualsalary()+
                '}';
    }
}
