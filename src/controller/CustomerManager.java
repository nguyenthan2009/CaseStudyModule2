package controller;

import model.Customer;
import storage.fileCustomer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    List<Customer> List = new ArrayList<>();

    public CustomerManager(List<Customer> list) {
        List = list;
    }
    public CustomerManager(){

    }

    public java.util.List<Customer> getList() {
        return List;
    }

    public void setList(List<Customer> list) {
        List = list;
    }

    public void addCustomer(Customer customer) throws IOException {
        List.add(customer);
        fileCustomer.writefile(List);

    }
    public Customer findCustomerbyName(String name){
        Customer customer = null;
        for(int i =0;i<List.size();i++){
            if(List.get(i).getCustomerName().equals(name)){
                customer = List.get(i);
            }
        }
        return  customer;
    }
    public void deleteCustomer(Customer customer) throws IOException{
        List.remove(customer);
        fileCustomer.writefile(List);

    }
    public void showAllCustomer(){
        for (Customer customer :
                List) {
            System.out.println(customer);
        }
    }

}

