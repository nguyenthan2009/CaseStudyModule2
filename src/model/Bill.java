package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Bill implements Serializable {
    private String billCode;
    private BookRoom bookRoom;
    private LocalDate startDay;
    private LocalDate endDay;


    public Bill(String billCode, BookRoom bookRoom,LocalDate startDay, LocalDate endDay) {
        this.billCode = billCode;
        this.bookRoom = bookRoom;
        this.endDay = endDay;
        this.startDay = startDay;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public BookRoom getBookRoom() {
        return bookRoom;
    }

    public void setBookRoom(BookRoom bookRoom) {
        this.bookRoom = bookRoom;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }
    public double getMoneyRoom(){
        return  (endDay.getDayOfMonth()-startDay.getDayOfMonth())*bookRoom.getRoomHotel().getRoomPrice();
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billCode='" + billCode + '\'' +
                ", bookRoom=" + bookRoom +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", MoneyRoom=" + getMoneyRoom() +
                '}';
    }
}
