package controller;

import model.User;
import storage.fileUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    List<User> User = new ArrayList<>();


    public UserManager(List<model.User> user) {
        User = user;
    }

    public List<model.User> getUser() {
        return User;
    }

    public void setUser(List<model.User> user) {
        User = user;
    }

    public void addUser(User user) throws IOException {
        User.add(user);
        fileUser.writefile(User);
    }
    public void editUser(User newUser){
        User.set(0,newUser);
       try{ fileUser.writefile(User);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
    public int getNumberOfNameAccount(String nameAccount){
        int number =0;
        for(int i =0;i< User.size();i++){
            if(User.get(i).getAccount().equals(nameAccount)){
                number++;
            }
        }
        return number;
    }

    public void showUser(){
        for (User user:
        User){
            System.out.println(user);
        }
    }
}
