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

    void onButtonPress() {
        switch(activityName) {
            case "FEED": {
                // Show feed
                break;
            }
            case "POST": {
                // Show posting page
                break;
            }
        }
    }
}
