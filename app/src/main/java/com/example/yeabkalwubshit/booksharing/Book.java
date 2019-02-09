package com.example.yeabkalwubshit.booksharing;

public class Book {

    private final String bookName;
    private final long id;

    private String ownerName;
    private String departmentName;

    public Book(long id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    public void setOwner (String OwnerName) {
        this.ownerName = ownerName;
    }
    public void setDepartment (String departmentName) {
        this.departmentName = departmentName;
    }

    public String getOwnerName() {return this.ownerName;}
    public long getId() {return this.id;}
    public String getDepartment() {return this.departmentName;}
    public String getBookName() {return this.bookName;}

}
