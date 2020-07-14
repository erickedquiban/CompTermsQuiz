package com.example.comptermsquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class HistoryFragment extends Fragment {
   ImageView imgClick;
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

   public HistoryFragment() {
   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.history, container, false);




      imgClick = (ImageView) view.findViewById(R.id.imageabacus);
      final MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.abacus);

      imgClick2 = (ImageView) view.findViewById(R.id.imagenb);
      final MediaPlayer mp2 = MediaPlayer.create(getActivity(), R.raw.napiers_bone);

      imgClick3 = (ImageView) view.findViewById(R.id.imagepas);
      final MediaPlayer mp3 = MediaPlayer.create(getActivity(), R.raw.pascaline);

      imgClick4 = (ImageView) view.findViewById(R.id.imagestep);
      final MediaPlayer mp4 = MediaPlayer.create(getActivity(), R.raw.stepped);

      imgClick5 = (ImageView) view.findViewById(R.id.imagede);
      final MediaPlayer mp5 = MediaPlayer.create(getActivity(), R.raw.diffengine);

      imgClick6 = (ImageView) view.findViewById(R.id.imageana);
      final MediaPlayer mp6 = MediaPlayer.create(getActivity(), R.raw.anengine);

      imgClick7 = (ImageView) view.findViewById(R.id.imagetm);
      final MediaPlayer mp7 = MediaPlayer.create(getActivity(), R.raw.tambulating_machine);

      imgClick8 = (ImageView) view.findViewById(R.id.imageda);
      final MediaPlayer mp8 = MediaPlayer.create(getActivity(), R.raw.diff_analyzer);


      imgClick.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view1) {
            Toast.makeText(getActivity(), "Abacus", Toast.LENGTH_LONG).show();
            mp.start();
         }
      });

      imgClick2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view1) {
            Toast.makeText(getActivity(), "Napier's Bones", Toast.LENGTH_LONG).show();
            mp2.start();
         }
      });

      imgClick3.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view1) {
            Toast.makeText(getActivity(), "Pascaline", Toast.LENGTH_LONG).show();
            mp3.start();
         }
      });

      imgClick4.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view1) {
            Toast.makeText(getActivity(), "Stepped Reckoner or Leibnitz wheel", Toast.LENGTH_LONG).show();
            mp4.start();
         }
      });

      imgClick5.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view1) {
            Toast.makeText(getActivity(), "Difference Engine", Toast.LENGTH_LONG).show();
            mp5.start();
         }
      });

      imgClick6.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view1) {
            Toast.makeText(getActivity(), "Analytical Engine", Toast.LENGTH_LONG).show();
            mp6.start();
         }
      });

      imgClick7.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view1) {
            Toast.makeText(getActivity(), "Tabulating Machine", Toast.LENGTH_LONG).show();
            mp7.start();
         }
      });

      imgClick8.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view1) {
            Toast.makeText(getActivity(), "Differential Analyzer", Toast.LENGTH_LONG).show();
            mp8.start();
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
               Intent int2 = new Intent(getActivity(), Quizhistoryofcomp.class);
               startActivity(int2);
               speak();
               textToSpeech.stop();

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

