package com.example.comptermsquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.comptermsquiz.Quiz7Contract.Question1Table;

import java.util.ArrayList;

public class Quiz7DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz7.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public Quiz7DbHelper(Context context) {
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
        Question q1 = new Question( "The internet is a global information network that connects millions of computers.", "A.True", "B. False", "C. Test", 1);
        addQuestion(q1);
        Question q2 = new Question("The internet got its start in United States more than 50 years ago as a government weapon in the Cold War.", "A.True", "B.False", "C. Test", 1);
        addQuestion(q2);
        Question q3 = new Question("In 1962, a scientist from M.I.T and DARPA named J.C.R. Licklider proposed a “galactic network” of computers that could talk to one another.", "A.True", "B.False", "C. Test", 1);
        addQuestion(q3);
        Question q4 = new Question("In 1965, another M.I.T. scientist developed a way of sending information form one computer to another that he called (packet switching). ", "A.True", "B.False", "C. Test", 1);
        addQuestion(q4);
        Question q5 = new Question("In 1969, ARPANET delivered its first message: a (node-to-node) communication from one computer to another but it crashed the full network. ", "A. True", "B. False", "C. Test", 1);
        addQuestion(q5);
        Question q6 = new Question("By the end of 1968, just four computers were connected to the ARPANET, but the network grew steadily during the 1970’s.", "A. True", "B. False", "C. Test", 2);
        addQuestion(q6);
        Question q7 = new Question("Berners-Zie created the first browser and the internet that we know today.", "A. True", "B. False", "C. Test", 2);
        addQuestion(q7);
        Question q8 = new Question("WWW means Word Wide Web", "A. True", "B. False", "C. Test", 2);
        addQuestion(q8);
        Question q9 = new Question("TPC means Transfortation Control Protocol", "A. True", "B. False", "C. Test", 2);
        addQuestion(q9);
        Question q10 = new Question("The internet is a global information network that connects millions of computers. ", "A. True", "B. False", "C. Test", 1);
        addQuestion(q10);



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
