package com.example.comptermsquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quizhistoryofcomp extends AppCompatActivity {

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";
    public static final String KEY_SCORE = "keyScore";

    TextView alert;
    Button btn2;
    Button btn3;
    private TextView textViewHighscore;
    private TextView textViewScore;

    private int highscore, current_highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizhistoryofcomp);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        alert = (TextView) findViewById(R.id.alert);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(Quizhistoryofcomp.this, CompActivity.class);
                startActivity(int1);
                // myMenu.findItem(R.id.nav_his)
                //       .setEnabled(true);
            }
        });

//wag dito
        textViewHighscore = findViewById(R.id.tv_highscore);
        loadHighscore();

        textViewScore = findViewById(R.id.recent);
        loadScore();

        Button buttonStartQuiz = findViewById(R.id.btn1);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz2();
            }
        });
    }

    private void startQuiz2() {
        Intent intent = new Intent(Quizhistoryofcomp.this, Quiz2.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(Quiz2.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
                int recent_score = data.getIntExtra(Quiz2.EXTRA_RECENT_SCORE, 0);
                if (recent_score >= current_highscore || recent_score <= current_highscore) {
                    updateScore(recent_score);
                }
            }
        }
    }


    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore: " + highscore);
    }

    private void loadScore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        current_highscore = prefs.getInt(KEY_SCORE, 0);
        textViewScore.setText("Recent Score: " + current_highscore);
        if (current_highscore <= 5) {
            alert.setText("");
            btn2.setEnabled(false);
        }


    }


    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();


    }
    private void  updateScore (int highscoreNew) {
        current_highscore = highscoreNew;
        textViewScore.setText("Recent Score: " + current_highscore);
        if (current_highscore <= 5) {
            alert.setText("You have to Read more about the topic!");
            btn2.setEnabled(false);

        } else if (current_highscore >= 6 ){
            alert.setText("Congratulations you meet the passing score");
            btn2.setEnabled(true);
            // quiz1.setEnabled(true);
        }



        SharedPreferences prefs  = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_SCORE, current_highscore);
        editor.apply();
    }




}
