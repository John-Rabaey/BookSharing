package com.example.yeabkalwubshit.booksharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText mUserName;
    private EditText mPassowrd;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserName = (EditText) findViewById(R.id.userNameText);
        mPassowrd = (EditText) findViewById(R.id.passwordText);
        mLogin = (Button) findViewById(R.id.btnLogin);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runLogin();
            }
        });
    }

    void runLogin() {
        String userName = mUserName.getText().toString();
        String passWord = mPassowrd.getText().toString();

        if(userName.length() != 0 && passWord.length() != 0) {
            openHomePage(userName);
        }


    }

    private void openHomePage(String userName) {
        Intent intent = new Intent(MainActivity.this,
                HomePage.class);
        HomePage.userName = userName;
        startActivity(intent);
    }
}
