package com.example.comptermsquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class FragmentLesson4 extends Fragment {

    Button btnSpeak;
    TextView editText;
    Button btnStop;
    TextToSpeech textToSpeech;
    public FragmentLesson4(){

    }
    public View onCreateView(  LayoutInflater inflater,   ViewGroup container,
                               Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.activity_fragment_lesson4,container,false);



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

                Intent int2 = new Intent(getActivity(), Quizmotherofcomp.class);
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



