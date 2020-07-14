package com.example.comptermsquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.comptermsquiz.Quiz9Contract.Question1Table;

import java.util.ArrayList;

public class Quiz9DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz9.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public Quiz9DbHelper(Context context) {
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
        Question q1 = new Question( "Who is the founder of the C programming language, and co-developer of UNIX?", "A.Dennis Ritchie", "B. Leonardo de Carpio", "C. Jhonny Deep", 1);
        addQuestion(q1);
        Question q2 = new Question("Who invented GOOGLE along with Sergey Brin. Who’s now the CEO of Alphabet Inc.??", "A. Barrack Obama", "B. Larry Page", "C. Dennis Ritchie", 2);
        addQuestion(q2);
        Question q3 = new Question("What is the Name of the person that created FACEBOOK?", "A. Mark Sucherberg", "B. Mark Zuckerberg", "C. Marc Zuckerberg", 2);
        addQuestion(q3);
        Question q4 = new Question("_________is a computer programmer and co-founder of Microsoft which is the largest software company in the world.?", "A. Bill Gates", "B.John Cusack", "C. Justine Bieber", 1);
        addQuestion(q4);
        Question q5 = new Question("He is a Finnish-American software engineer and creator of the Linux kernel, which became the kernel for operating systems like Linux OS, Chrome OS, and Android. ", "A. Bill Gates", "B. Mark Zuckerberg", "C.Linus Torvalds", 3);
        addQuestion(q5);
        Question q6 = new Question("He re-wrote most of UNIX into the C programming language in 1973 together with Dennis Ritchie.?", "A. Keanu Reeves", "B. Satoshi Nakamoto", "C. Ken Thompson", 3);
        addQuestion(q6);
        Question q7 = new Question("He imagined an open platform where people everywhere could freely share information, access opportunities, and work with one another despite geographical limitations.?", "A. Tim Berners-Lee", "B. Dennis Ritchie", "C. Alan Turing", 1);
        addQuestion(q7);
        Question q8 = new Question("___________ was a computer scientist, mathematician, logician, and creator of the Turing machine, which simulates computer algorithms?", "A.Alan Turing", "B. Linus Torvalds", "C. Donald Trump", 1);
        addQuestion(q8);
        Question q9 = new Question("Ada Lovelace was an English mathematician, and the world’s first computer programmer. She was born in the year??", "A. 1966", "B. 1815", "C. 1901", 2);
        addQuestion(q9);
        Question q10 = new Question("Who is the founder of Bitcoin??", "A. Satoshi Nakamoto ", "B. Kenshin Himura", "C. Ken Thompson", 1);
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
