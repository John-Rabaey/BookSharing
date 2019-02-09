package com.example.yeabkalwubshit.booksharing;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class HomePage extends AppCompatActivity {

    public static String userName;
    ListView entryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        setTitle(userName + "'s Home Page");

        entryList = findViewById(R.id.homePageList);

        HomePageEntry post = new HomePageEntry(
                "Post",
                "Post items you want to exchange/sell.",
                "Post items"
        );
        HomePageEntry feed = new HomePageEntry(
                "Find A Book",
                "Search a book among postings.",
                "Find Books"
        );

        HomePageEntry[] homePageEntries = new HomePageEntry[] {post, feed};
        ArrayList<HomePageEntry> homePageEntryList = new ArrayList<>(Arrays.asList(homePageEntries));
        HomePageEntryAdapter adapter = new HomePageEntryAdapter(this, homePageEntryList);
        entryList.setAdapter(adapter);

    }

    public class HomePageEntryAdapter extends ArrayAdapter<HomePageEntry> {
        public HomePageEntryAdapter(Context context, ArrayList<HomePageEntry> data) {
            super(context, 0, data);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // Get the data item for this position
            final HomePageEntry entry = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(
                        R.layout.home_page_entry_cell, parent, false);
            }

            TextView title = convertView.findViewById(R.id.title);
            TextView description = convertView.findViewById(R.id.description);

            Button goButton = convertView.findViewById(R.id.goBtn);
            goButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (entry.activityName) {
                        case "Post" : {
                            openPostItem();
                            break;
                        }
                    }
                }
            });

            title.setText(entry.activityName);
            description.setText(entry.description);
            goButton.setText(entry.buttonLabel);

            return convertView;
        }
    }

    private void openPostItem() {
        Intent intent = new Intent(HomePage.this,
                PostItem.class);
        startActivity(intent);
    }
}
