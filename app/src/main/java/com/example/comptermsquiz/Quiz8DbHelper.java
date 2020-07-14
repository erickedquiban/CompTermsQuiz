package com.example.comptermsquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.comptermsquiz.Quiz8Contract.Question1Table;

import java.util.ArrayList;

public class Quiz8DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz8.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public Quiz8DbHelper(Context context) {
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
        Question q1 = new Question( "Facebook  is the 2nd biggest social media site around, with more than two Million people using it every month.", "A.True", "B. False", "C. Test", 2);
        addQuestion(q1);
        Question q2 = new Question("YouTube is a massaging application used to connects people to one another.", "A. True", "B. False", "C. Test", 2);
        addQuestion(q2);
        Question q3 = new Question("WhatsApp was only used by people to communicate with their family and friends.", "A. True", "B. False", "C. Test", 1);
        addQuestion(q3);
        Question q4 = new Question("Instagram It allows you to share a wide range of content such as photos, videos, Stories, and live videos?", "A. True", "B. False", "C. Test", 1);
        addQuestion(q4);
        Question q5 = new Question("WeChat Besides messaging and calling, users can now use WeChat to shop online and make payment offline, transfer money, make reservations, book taxis, and more", "A. True", "B. False", "C. Test", 1);
        addQuestion(q5);
        Question q6 = new Question("Messenger used to be a messaging feature within Instagram.?", "A. True", "B. False", "C. Test", 2);
        addQuestion(q6);
        Question q7 = new Question("Tik Tok It was the world’s most downloaded app in the first quarter of 2018, beating Facebook, Instagram, and other social media apps", "A. True", "B. False", "C. Test", 1);
        addQuestion(q7);
        Question q8 = new Question("Twitter is a social media site for news, entertainment, sports, politics, and more.", "A. True", "B. False", "C. Test", 1);
        addQuestion(q8);
        Question q9 = new Question("LinkedIn is a video, resume and job search site only. ", "A. True", "B. False", "C. Test", 2);
        addQuestion(q9);
        Question q10 = new Question("Viber allows users to send messages and multimedia, call, share stickers and GIFs, and more. ", "A. True", "B. False", "C. Test", 1);
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
