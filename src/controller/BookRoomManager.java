package controller;

import model.BookRoom;
import model.Customer;
import storage.fileBookRoom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookRoomManager {
    List<BookRoom> bookRooms = new ArrayList<>();

    public BookRoomManager(List<BookRoom> bookRooms) {
        this.bookRooms = bookRooms;
    }

    public List<BookRoom> getBookRooms() {
        return bookRooms;
    }

    public void setBookRooms(List<BookRoom> bookRooms) {
        this.bookRooms = bookRooms;
    }
    public void addBookRoom(BookRoom bookRoom) throws IOException {
        bookRooms.add(bookRoom);
        fileBookRoom.writefile(bookRooms);
    }
    public BookRoom findBookRoombyCode(String code){
        BookRoom bookRoom = null;
        for(int i =0;i<bookRooms.size();i++){
            if(bookRooms.get(i).getCodeBookRoom().equals(code)){
                bookRoom = bookRooms.get(i);
            }
        }
        return  bookRoom;
    }
    public int getIndexbyCode(String code) {
        int index = -1;
        for (int i = 0; i < bookRooms.size(); i++) {
            if (bookRooms.get(i).getCodeBookRoom().equals(code)) {
                index = i;
            }
        }
        return index;
    }
    public void editBookRoom(int index,BookRoom newBookroom) throws IOException{
        bookRooms.set(index,newBookroom);
        fileBookRoom.writefile(bookRooms);
    }
    public void deleteBookRoom(BookRoom BookRoom) throws  IOException{
        bookRooms.remove(BookRoom);
        fileBookRoom.writefile(bookRooms);
    }
    public void showAll(){
        for (BookRoom bookroom:
             bookRooms) {
            System.out.println(bookroom);
        }
    }

}
