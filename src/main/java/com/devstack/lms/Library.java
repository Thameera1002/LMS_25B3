package com.devstack.lms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<LibraryItems> libraryItems;
    private List<User> userList;
    private Map<String,String> borrowedItems;

    public Library(){
        libraryItems = new ArrayList<>();
        userList = new ArrayList<>();
        borrowedItems = new HashMap<>();
    }

    public void addItem(LibraryItems item){
        libraryItems.add(item);
    }

    public void addUser(User user){
        userList.add(user);
    }

    public List<LibraryItems> getLibraryItems() {
        return libraryItems;
    }

    public List<User> getUserList() {
        return userList;
    }

    public Map<String,String> getBorrowedItems() {
        return borrowedItems;
    }

    public void borrowItem(String serialNumber,User user){
        for(LibraryItems items : libraryItems){
            if(items.getSerialNumber().equals(serialNumber)){
                if(borrowedItems.containsKey(serialNumber)){
                    System.out.println("Sorry, the item: " + items.getTitle() + " is already borrowed.");
                } else {
                    borrowedItems.put(items.getSerialNumber(), user.getName());
                    items.isBorrowed = true;
                    System.out.println(user.getName() + " borrowed the item: " + items.getTitle());
                    return;
                }
            }
        }
        System.out.println("Item with serial number " + serialNumber + " not found.");
    }

    public void returnBorrowedItem(String serialNumber){
        for(LibraryItems items : libraryItems){
            if(items.getSerialNumber().equals(serialNumber)){
                borrowedItems.remove(items.getSerialNumber());
                return;
            }
        }
        System.out.println("Item with serial number " + serialNumber + " not found.");
    }
}
