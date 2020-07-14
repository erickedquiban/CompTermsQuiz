package com.example.comptermsquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ListenActivity extends AppCompatActivity {
    TextView History;
    MediaPlayer l_f;
    Button play;
    Button pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);
        l_f = MediaPlayer.create(ListenActivity.this, R.raw.how);


        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l_f.start();

                pause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        l_f.pause();
                    }
                });


                Toast.makeText(getApplicationContext(), "Letter M", Toast.LENGTH_SHORT).show();



            }
        });
    }}

