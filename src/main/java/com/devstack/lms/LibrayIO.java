package com.devstack.lms;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrayIO {
    public static void saveItemToFile(List<LibraryItems> libraryItems,String fileName) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(libraryItems);
            System.out.println("Library items saved to file: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<LibraryItems> loadItemFromFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (List<LibraryItems>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void saveUserToFile(List<User> userList,String fileName) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(userList);
            System.out.println("Users saved to file: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> loadUserFromFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveBorrowedItemsToFile(Map<String,String> borrowedItems,String fileName) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(borrowedItems);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<String,String> loadBorrowedItemsFromFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return new HashMap<>();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (Map<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
