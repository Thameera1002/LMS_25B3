package com.devstack.lms;

import java.io.Serializable;

public abstract class LibraryItems implements Serializable {
    private String title;
    private String author;
    private String serialNumber;

    protected boolean isBorrowed;

    public LibraryItems(String title, String author, String serialNumber) {
        this.title = title;
        this.author = author;
        this.serialNumber = serialNumber;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getSerialNumber() {
        return serialNumber;
    }

    public abstract void borrowItem(User user);


}
