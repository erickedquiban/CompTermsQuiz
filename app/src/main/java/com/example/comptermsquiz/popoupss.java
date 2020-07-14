package com.example.comptermsquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class popoupss extends AppCompatActivity {

    Button btn;
    String uriString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.idbtn);
    }
    public void btnClick(View w){
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        uriString = "http://www.opencv-tutorial-code.blogspot.in";
        sharingIntent.putExtra(Intent.EXTRA_TEXT,uriString);
        sharingIntent.setPackage("com.facebook.katana");
        startActivity(sharingIntent);
    }
}