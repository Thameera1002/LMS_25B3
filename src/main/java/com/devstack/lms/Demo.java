package com.devstack.lms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) throws IOException {
        Library library = new Library();

        List<LibraryItems> itemList = LibrayIO.loadItemFromFile("itemList.lms");
        for (LibraryItems item : itemList) {
            library.addItem(item);
        }

        List<User> userList = LibrayIO.loadUserFromFile("userList.lms");
        for (User user : userList) {
            library.addUser(user);
        }

        Map<String,String> borrowedItemList = LibrayIO.loadBorrowedItemsFromFile("borrowedItemList.lms");
        for (Map.Entry<String, String> entry : borrowedItemList.entrySet()) {
            library.getBorrowedItems().put(entry.getKey(),entry.getValue());
        }


        System.out.println("Library Items:");
        itemList.forEach(item -> System.out.println(item.getTitle()+ "\t"+ item.getAuthor()+"\t"+ item.getSerialNumber()));


        System.out.println("\nUser List:");
        userList.forEach(user -> System.out.println(user.getName()));


        boolean exit = false;
        while (!exit){
            System.out.println("\n\nLibrary Menu:\n\n");
            System.out.println("1. Create an Item");
            System.out.println("2. Create a User");
            System.out.println("3.Borrow an Item");
            System.out.println("4.Return an Item");
            System.out.println("5.Exit");

            BufferedReader mainOption = new BufferedReader(new InputStreamReader(System.in));
            int mainChoiceString;
            try {
                mainChoiceString = Integer.parseInt(mainOption.readLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (mainChoiceString==1){
                System.out.println("\n\nCreating an Item:\n");
                System.out.println("Which item do you want to create?\n1.Book\n2.Magazine");
                BufferedReader itemOption = new BufferedReader(new InputStreamReader(System.in));
                int itemChoice = Integer.parseInt(itemOption.readLine());
                if (itemChoice==1){
                    System.out.println("Enter Book Title:");
                    String bookTitile = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    System.out.println("Enter Book Author:");
                    String bookAuthor = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    System.out.println("Enter Book Serial Number:");
                    String bookSerialNumber = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    for (LibraryItems item : library.getLibraryItems()) {
                        if(Objects.equals(item.getSerialNumber(),bookSerialNumber)){
                            System.out.println("Item with this serial number already exists!");
                            continue;
                        }
                    }
                    LibraryItems createBook = new Book(bookTitile,bookAuthor,bookSerialNumber);
                    library.addItem(createBook);
                    System.out.println("Book created successfully!");
                }else if (itemChoice==2){
                    System.out.println("Enter Magazine Title:");
                    String magazineTitile = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    System.out.println("Enter Magazine Author:");
                    String magazineAuthor = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    System.out.println("Enter Magazine Serial Number:");
                    String magazineSerialNumber = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    for (LibraryItems item : library.getLibraryItems()) {
                        if(Objects.equals(item.getSerialNumber(),magazineSerialNumber)){
                            System.out.println("Item with this serial number already exists!");
                            continue;
                        }
                    }
                    LibraryItems createMagazine = new Magazine(magazineTitile,magazineAuthor,magazineSerialNumber);
                    library.addItem(createMagazine);
                    System.out.println("Magazine created successfully!");
                }
            } else if (mainChoiceString==2) {
                //You can implement user creation here
            } else if (mainChoiceString==3) {

            }
        }

//        LibraryItems book1 = new Book("1984", "George Orwell", "B001");
//        LibraryItems book2 = new Book("Sample Book", "Henry Alex", "B002");
//        LibraryItems magazine1 = new Magazine("Time", "Various", "M001");
//        LibraryItems magazine2 = new Magazine("Sample Magazine", "John Doe", "M002");
//
//        library.addItem(book1);
//        library.addItem(book2);
//        library.addItem(magazine1);
//        library.addItem(magazine2);
//
//        User user1 = new User("Alice");
//        User user2 = new User("Bob");
//
//        library.addUser(user1);
//        library.addUser(user2);

//        System.out.println("Library Items:");
//        library.getLibraryItems().forEach(item -> System.out.println(item.getTitle()+ "\t"+ item.getAuthor()+"\t"+ item.getSerialNumber()));
//        System.out.println("\nUsers:");
//        library.getUserList().forEach(user -> System.out.println(user.getName()));

        LibrayIO.saveItemToFile(library.getLibraryItems(),"itemList.lms");
        LibrayIO.saveUserToFile(library.getUserList(),"userList.lms");
        LibrayIO.saveBorrowedItemsToFile(library.getBorrowedItems(),"borrowedItemList.lms");

    }
}
