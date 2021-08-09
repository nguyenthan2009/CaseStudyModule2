package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable {
    private String customerName;
    private LocalDate bornDay;
    private String gender;
    private String identityCard;

    public Customer(String customerName, LocalDate bornDay, String gender, String identityCard) {
        this.customerName = customerName;
        this.bornDay = bornDay;
        this.gender = gender;
        this.identityCard = identityCard;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getAge() {
        return bornDay;
    }

    public void setAge(int age) {
        this.bornDay = bornDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCMND() {
        return identityCard;
    }

    public void setCMND(int CMND) {
        this.identityCard = identityCard;
    }

    @Override
    public String toString() {
        return "model.Customer{" +
                "customerName='" + customerName + '\'' +
                ", bornDay=" + bornDay +
                ", gender='" + gender + '\'' +
                ", identityCard=" + identityCard +
                '}';
    }
}
