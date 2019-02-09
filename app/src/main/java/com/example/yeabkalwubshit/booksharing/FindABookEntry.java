package com.example.yeabkalwubshit.booksharing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class FindABookEntry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_abook_entry);

        Spinner fieldSpinner = (Spinner)findViewById(R.id.spinnerField);
        Spinner courseSpinner = (Spinner) findViewById(R.id.spinnerCourse);
        Spinner professorSpinner = (Spinner) findViewById(R.id.spinnerProfessor);
    }
}
