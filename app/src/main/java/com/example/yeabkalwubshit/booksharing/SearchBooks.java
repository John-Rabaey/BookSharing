package com.example.yeabkalwubshit.booksharing;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class SearchBooks extends AppCompatActivity {

    private EditText mSearchView;
    private EditText mDepartment;
    private Button mSearchBook;
    private ListView mSearchResultList;
    private SearchResultDisplay displayAdapter;
    ArrayList<Book> searchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_books);

        mSearchView = findViewById(R.id.searcherBox);
        mDepartment = findViewById(R.id.departmentText);
        mSearchBook = findViewById(R.id.submitSearchRequest);
        mSearchResultList = findViewById(R.id.searchResultList);

        searchResult = NetworkServices.fetchBooks();
        displayAdapter = new SearchResultDisplay(this, searchResult);

        mSearchBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setListAdapter();
            }
        });

        mSearchResultList.setAdapter(displayAdapter);
    }

    void setListAdapter() {
        searchResult = searchBooks();
        displayAdapter.clear();
        for(Book book: searchResult) {
            displayAdapter.add(book);
        }
        displayAdapter.notifyDataSetChanged();
    }

    ArrayList<Book> searchBooks() {
        String searchText = mSearchView.getText().toString();
        String department = mDepartment.getText().toString();

        ArrayList<Book> booksInDepartment = SortBookList.getAndFilterBookList(department);
        SortBookList.sortBookList(booksInDepartment, searchText);
        System.out.println("Got books of size = " + booksInDepartment.size());
        Collections.reverse(booksInDepartment);
        return booksInDepartment;
    }

    public class SearchResultDisplay extends ArrayAdapter<Book> {
        public SearchResultDisplay(Context context, ArrayList<Book> data) {
            super(context, 0, data);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            System.out.println("Getting view");

            // Get the data item for this position
            final Book book = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(
                        R.layout.search_result_cell, parent, false);
            }

            TextView title = convertView.findViewById(R.id.searchCellTitle);
            TextView description = convertView.findViewById(R.id.searchCellDescription);

            title.setText(book.getBookName());
            description.setText(book.getDescription());

            return convertView;
        }
    }
}
