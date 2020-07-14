package com.example.comptermsquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //set variables here

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;

    //default
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//called them by their designated id that you assigned

        db = new DatabaseHelper(this);  //the way of calling database on sql

        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mTextViewRegister = (TextView) findViewById(R.id.textview_register);

//intent is more likely (linking) or href

        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        //this closing braces is to advise the ide that your done with the above statement
        //intent is more likely (linking) or href but this is applicable to fragments and xml only

        mButtonLogin.setOnClickListener(new View.OnClickListener() { //submit button
            @Override
            public void onClick(View v) { //click action
                String user = mTextUsername.getText().toString().trim(); //set the sting from databse same name from database .getText
                String pwd = mTextPassword.getText().toString().trim();//set the sting
                Boolean res = db.checkUser(user, pwd); //called it from database no idea bkit nacall si password as pwd


                if (res == true)//make a condition
                {
                    Intent i = new Intent(MainActivity.this, CompActivity.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this,"Welcome User ",Toast.LENGTH_SHORT).show();
                    mTextUsername.setText("");
                    mTextPassword.setText("");

                }
                else  {
                    Toast.makeText(MainActivity.this,"Please fill up the form above",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }//always have 2 braces to close the whole app
}



//try this codes to get the user

  /*  Intent intent = getIntent();
    int score = intent.getIntExtra("score", 0);
        txtScore.setText("Your Score:   " + score);*/


