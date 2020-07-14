package com.example.comptermsquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.comptermsquiz.Quiz6Contract.Question1Table;

import java.util.ArrayList;

public class Quiz6DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz6.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public Quiz6DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                Question1Table.TABLE_NAME + "(" +
                Question1Table._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Question1Table.COLUMN_QUESTION1 + " TEXT, " +
                Question1Table.COLUMN_OPTION1 + " TEXT, " +
                Question1Table.COLUMN_OPTION2 + " TEXT, " +
                Question1Table.COLUMN_OPTION3 + " TEXT, " +
                Question1Table.COLUMN_ANSWER_NR + " INTEGER " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Question1Table.TABLE_NAME);
        onCreate(db);

    }

    private void fillQuestionsTable() {
        Question q1 = new Question( "Stack Overflow is a question and answer site for professional and enthusiast programmers.", "A.True", "B.False", "C. Test", 2);
        addQuestion(q1);
        Question q2 = new Question("Google Code Jam is an international programming competition hosted and administered by Google.", "A. True", "B. False", "C. Test", 1);
        addQuestion(q2);
        Question q3 = new Question("Topcoder is a crowdsourcing company with an open global community of designers, developers, data scientists, and competitive programmers.", "A. True", "B. False", "C. Test", 1);
        addQuestion(q3);
        Question q4 = new Question("Coderbyte is a web application built to help you practice programming and improve your coding skills.", "A. True", "B. False", "C. Test", 1);
        addQuestion(q4);
        Question q5 = new Question("SQLZoo is a free,(learn-by-doing) SQL course that has you punching out queries and wracking your brain for the solutions from the very beginning.", "A. True", "B. False", "C. Test", 1);
        addQuestion(q5);
        Question q6 = new Question("Codecademy is an online interactive platform that offers free coding classes.", "A. True", "B. False", "C. Test", 1);
        addQuestion(q6);
        Question q7 = new Question("Coursera is an American online learning platform founded by Stanford professors Andrew Ng and Daphne Koller .", "A. True", "B. False", "C. Test", 1);
        addQuestion(q7);
        Question q8 = new Question("Scratch is a block-based visual programming language and online community ", "A. True", "B. False", "C. Test", 1);
        addQuestion(q8);

    }

    private void addQuestion(Question question1) {
        ContentValues cv = new ContentValues();
        cv.put(Question1Table.COLUMN_QUESTION1, question1.getQuestion());
        cv.put(Question1Table.COLUMN_OPTION1, question1.getOption1());
        cv.put(Question1Table.COLUMN_OPTION2, question1.getOption2());
        cv.put(Question1Table.COLUMN_OPTION3, question1.getOption3());
        cv.put(Question1Table.COLUMN_ANSWER_NR, question1.getAnswerNr());
        db.insert(Question1Table.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {

        ArrayList<Question> question1List = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Question1Table.TABLE_NAME, null);

        if(c.moveToFirst()){
            do{
                Question question1 = new Question();
                question1.setQuestion(c.getString(c.getColumnIndex(Question1Table.COLUMN_QUESTION1)));
                question1.setOption1(c.getString(c.getColumnIndex(Question1Table.COLUMN_OPTION1)));
                question1.setOption2(c.getString(c.getColumnIndex(Question1Table.COLUMN_OPTION2)));
                question1.setOption3(c.getString(c.getColumnIndex(Question1Table.COLUMN_OPTION3)));
                question1.setAnswerNr(c.getInt(c.getColumnIndex(Question1Table.COLUMN_ANSWER_NR)));
                question1List.add(question1);

            }while (c.moveToNext());

        }
        c.close();
        return question1List;
    }
}
