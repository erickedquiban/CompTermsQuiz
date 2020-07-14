package com.example.comptermsquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.comptermsquiz.Quiz4Contract.Question1Table;

import java.util.ArrayList;

public class Quiz4DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz4.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public Quiz4DbHelper(Context context) {
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
        Question q1 = new Question( "Is an interpreted, high-level, general-purpose programming language", "A.  Java", "B. Python", "C. Go", 2);
        addQuestion(q1);
        Question q2 = new Question("interpreted scripting language that conforms to the ECMAScript specification.", "A.  C#", "B. JavaScript", "C. C++", 2);
        addQuestion(q2);
        Question q3 = new Question("Is a general-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible.", "A. Java", "B. Ruby", "C. Jvascript", 1);
        addQuestion(q3);
        Question q4 = new Question(" Is a general-purpose, multi-paradigm, compiled programming language developed by Apple Inc.", "A.  Swift", "B. Ruby", "C. Python", 1);
        addQuestion(q4);
        Question q5 = new Question("Also known as Golang, is a statically typed, compiled programming language designed at Google.", "A. Swift", "B. Java", "C. Go", 3);
        addQuestion(q5);
        Question q6 = new Question("Is a general-purpose, multi-paradigm programming language encompassing strong typing etc.", "A. C#", "B. C", "C. C++", 1);
        addQuestion(q6);
        Question q7 = new Question("Created by Bjarne Stroustrup?", "A. C++", "B. C", "C. C#", 1);
        addQuestion(q7);
        Question q8 = new Question("Is a general-purpose programming language providing support for functional programming and a strong static type system.", "A. Scala", "B. Java", "C. Ruby", 1);
        addQuestion(q8);
        Question q9 = new Question("_________ is a cross-platform, statically typed, general-purpose programming language?", "A. Java", "B. Kotlin", "C. Ruby", 2);
        addQuestion(q9);
        Question q10 = new Question("Created by Yukihiro Matsumoto?", "A. Java", "B. Ruby", "C. Html", 3);
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
