package com.example.yeabkalwubshit.booksharing;

import android.arch.lifecycle.ViewModelProvider;

import java.util.*;


/* Write a method that takes (ArrayList) and a (Search Text)
 * Return a new array sorted by the Least Common Subsequence.
 *
 */

class SortBookList {


    /*public static void main(String[] args) {

        int lcsTest = getLCS("hello", "");

        System.out.println(lcsTest);

        ArrayList<String> bookList = new ArrayList<String>(Arrays.asList("Iliad", "Odyssey", "Dante", "Red Riding Hood", "Random Book"));

        //Edits

        sortBookList(bookList, "Dan");

        System.out.println(bookList);

        for (String string : bookList) {

            int lcs = getLCS(string, "Dan");

            System.out.println(string + " = " + lcs);

        }


    }*/

    static ArrayList<Book> getAndFilterBookList(String department) {
        ArrayList<Book> books = NetworkServices.fetchBooks();
        if(department.equals("")) return books;
        ArrayList<Book> filtered = new ArrayList<>();
        for(Book book : books) {
            if(book.getDepartment().equals(department)) {
                filtered.add(book);
            }
        }
        return filtered;
    }

    static void sortBookList(ArrayList<Book> bookList, String searchString) {


        //search is the user text searched for
        final String search = searchString;


        Collections.sort(bookList, new Comparator<Book>() {

            public int compare(Book b1, Book b2) {

                int lX = getLCS(b1.getBookName(), search);
                int lY = getLCS(b2.getBookName(), search);

                return lX - lY;

            }


        });
    }



    public static int getLCS(String string1, String string2) {

        int rowLength = string1.length() + 1;

        int colLength = string2.length() + 1;

        int[][] table = new int[rowLength][colLength];

        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();

        for (int i = 1; i < rowLength; i++) {

            for (int j = 1; j < colLength; j++) {

                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {

                    table[i][j] = table[i - 1][j - 1] + 1;

                } else {

                    table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);

                }
            }
        }
        return table[rowLength - 1][colLength - 1];
    }
}
