package com.example.comptermsquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizProgActivity extends AppCompatActivity {
    private QuestionLibrarypro mQuestionLibrary1 = new QuestionLibrarypro();
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;


    private String mAnswer;
    private int mScore = 0;
    private int mQeustionNumber1 =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_prog);

        Button high1 = (Button)findViewById(R.id.high);

        mScoreView= (TextView)findViewById(R.id.core);
        mQuestionView= (TextView)findViewById(R.id.question);
        mButtonChoice1=(Button) findViewById(R.id.choice1);
        mButtonChoice2=(Button) findViewById(R.id.choice2);
        mButtonChoice3=(Button) findViewById(R.id.choice3);
        mButtonChoice4=(Button) findViewById(R.id.choice4);

        high1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(QuizProgActivity.this, HighscoreActivity.class);
                int1.putExtra("score",mScore);
                startActivity(int1);

            }
        });
        updateQuestion();
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice1.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(QuizProgActivity.this, "", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizProgActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice2.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(QuizProgActivity.this, " ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizProgActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice3.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(QuizProgActivity.this, " ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizProgActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice4.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(QuizProgActivity.this, " ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizProgActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void updateQuestion() {
        mQuestionView.setText(mQuestionLibrary1.getQuestion(mQeustionNumber1));
        mButtonChoice1.setText(mQuestionLibrary1.getChoice11(mQeustionNumber1));
        mButtonChoice2.setText(mQuestionLibrary1.getChoice12(mQeustionNumber1));
        mButtonChoice3.setText(mQuestionLibrary1.getChoice13(mQeustionNumber1));
        mButtonChoice4.setText(mQuestionLibrary1.getChoice14(mQeustionNumber1));

        mAnswer = mQuestionLibrary1.getmCorrectAnswers(mQeustionNumber1);
        mQeustionNumber1++;

    }

    private void updateScore (int point){
        mScoreView.setText(""+ mScore);

    }


}
