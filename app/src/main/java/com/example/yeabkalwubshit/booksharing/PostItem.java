package com.example.yeabkalwubshit.booksharing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PostItem extends AppCompatActivity {

    private EditText mBookNameBox;
    private EditText mBookSubjectBox;
    private EditText mBookDescriptionBox;
    private RadioButton mNewButton;
    private TextView mProfessorBox;

    private Button mSubmitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_item);

        setTitle("Post Item");

        mBookNameBox = findViewById(R.id.bookName);
        mBookSubjectBox = findViewById(R.id.bookSubject);
        mBookDescriptionBox = findViewById(R.id.bookDescription);
        mNewButton = findViewById(R.id.newBook);
        mSubmitButton = findViewById(R.id.submitLising);
        mProfessorBox = findViewById(R.id.professor);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validInput = checkInputs();
                if(!validInput) {
                    Toast toast = Toast.makeText(getApplicationContext(), "All inputs are required",
                            Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Book book = createBook();
                    boolean successPushingBookToDb = pushBookToDb(book);
                    if(successPushingBookToDb) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Successfully posted a new book " + "(" + book.getBookName()
                        + ")", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Failed to post item to db. Please, try again later.",
                                Toast.LENGTH_SHORT);
                    }
                }
            }
        });
    }

    Book createBook() {
        Long id = getId();
        String name = mBookNameBox.getText().toString();
        String subject = mBookSubjectBox.getText().toString();
        String description = mBookDescriptionBox.getText().toString();
        String professor = mProfessorBox.getText().toString();

        boolean isNew = mNewButton.isChecked();
        Book book = new Book(id, name, subject, description, professor, isNew);
        return book;

    }

    boolean pushBookToDb(Book book) {
        return true;
    }

    boolean checkInputs() {
        String name = mBookNameBox.getText().toString();
        String subject = mBookSubjectBox.getText().toString();
        String description = mBookDescriptionBox.getText().toString();
        String professor = mProfessorBox.getText().toString();

        boolean isValid = name.length() != 0
                && subject.length() != 0
                && description.length() != 0
                && professor.length() != 0;
        return isValid;
    }

    Long getId() {
        return 0L;
    }

}
