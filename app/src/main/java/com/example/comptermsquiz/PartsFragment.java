package com.example.comptermsquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class PartsFragment extends Fragment {

    ImageView imgClick1;
    ImageView imgClick2;
    ImageView imgClick3;
    ImageView imgClick4;
    ImageView imgClick5;
    ImageView imgClick6;
    ImageView imgClick7;
    ImageView imgClick8;
    Button btnSpeak;
    TextView editText;
    Button btnStop;
    TextToSpeech textToSpeech;




    public PartsFragment(){

    }
    public View onCreateView(  LayoutInflater inflater,   ViewGroup container,
                               Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_parts,container,false);


        imgClick1 = (ImageView)view.findViewById(R.id.imageView3);
        final MediaPlayer mp1 = MediaPlayer.create(getActivity(), R.raw.computercase);

        imgClick2 = (ImageView)view.findViewById(R.id.imageView4);
        final MediaPlayer mp2 = MediaPlayer.create(getActivity(), R.raw.monitor);

        imgClick3 = (ImageView)view.findViewById(R.id.imageView5);
        final MediaPlayer mp3 = MediaPlayer.create(getActivity(), R.raw.keyboard);

        imgClick4 = (ImageView)view.findViewById(R.id.imageView6);
        final MediaPlayer mp4 = MediaPlayer.create(getActivity(), R.raw.mouse);

        imgClick5 = (ImageView)view.findViewById(R.id.imageView7);
        final MediaPlayer mp5 = MediaPlayer.create(getActivity(), R.raw.motherboard);

        imgClick6 = (ImageView)view.findViewById(R.id.imageView8);
        final MediaPlayer mp6 = MediaPlayer.create(getActivity(), R.raw.ram);

        imgClick7 = (ImageView)view.findViewById(R.id.imageView10);
        final MediaPlayer mp7 = MediaPlayer.create(getActivity(), R.raw.avr);

        imgClick1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1){
                Toast.makeText(getActivity(), "Computer Case", Toast.LENGTH_LONG).show();
                mp1.start();
            }
        });

        imgClick2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1){
                Toast.makeText(getActivity(), "Monitor", Toast.LENGTH_LONG).show();
                mp2.start();
            }
        });

        imgClick3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1){
                Toast.makeText(getActivity(), "Keyboard", Toast.LENGTH_LONG).show();
                mp3.start();
            }
        });

        imgClick4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1){
                Toast.makeText(getActivity(), "Mouse", Toast.LENGTH_LONG).show();
                mp4.start();
            }
        });

        imgClick5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1){
                Toast.makeText(getActivity(), "Motherboard", Toast.LENGTH_LONG).show();
                mp5.start();
            }
        });

        imgClick6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1){
                Toast.makeText(getActivity(), "Random Access Memory", Toast.LENGTH_LONG).show();
                mp6.start();
            }
        });

        imgClick7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1){
                Toast.makeText(getActivity(), "AVR", Toast.LENGTH_LONG).show();
                mp7.start();
            }
        });






//texttospeech start here

        textToSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA ||
                            result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(getActivity(), "This language is not supported!",
                                Toast.LENGTH_SHORT);
                    } else {
                        btnStop.setEnabled(true);
                        btnSpeak.setEnabled(true);
                        textToSpeech.setPitch(0.6f);
                        textToSpeech.setSpeechRate(1.0f);
                        speak();
                    }
                }
            }
        });

        // Init View

        btnSpeak = (Button)view.findViewById(R.id.btnSpeak);
        editText = (TextView)view.findViewById(R.id.editText);
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();

            }
        });

        btnStop = (Button)view.findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
                textToSpeech.stop();

            }
        });

        Button quiz = (Button) view.findViewById(R.id.quiz1);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
                textToSpeech.stop();

                Intent int2 = new Intent(getActivity(), Quizpartofcomp.class);
                startActivity(int2);
            }
        });

        return view;
    }




    //Text to speech codes continue
    private void speak() {
        String text = editText.getText().toString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onDestroyView() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }




}



