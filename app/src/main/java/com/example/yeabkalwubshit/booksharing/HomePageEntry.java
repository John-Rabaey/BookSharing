package com.example.yeabkalwubshit.booksharing;

public class HomePageEntry {
    String activityName; // `FEED`, `POST`
    String description;
    String buttonLabel;

    public HomePageEntry(String name, String desc, String label) {
        this.activityName = name;
        this.description = desc;
        this.buttonLabel = label;
    }
}
