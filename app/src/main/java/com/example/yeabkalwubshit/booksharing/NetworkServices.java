package com.example.yeabkalwubshit.booksharing;

import java.util.ArrayList;

public class NetworkServices {

    public static ArrayList<Book> fetchBooks() {

        ArrayList<Book> result = new ArrayList<>();
        for(int i=0; i<5; i++) {
            Book book = new Book(Mocks.ids[i],
                    Mocks.names[i],
                    Mocks.departments[i],
                    Mocks.descriptions[i],
                    true);
            result.add(book);
        }
        return result;
    }
}
