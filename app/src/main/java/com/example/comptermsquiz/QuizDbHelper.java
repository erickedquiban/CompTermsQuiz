package com.example.comptermsquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.comptermsquiz.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CompQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
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
        Question q1 = new Question( "A type writer - style device which uses an arrangement of buttons or key to act as mechanical levers or electronic switches?", "A. Mouse", "B. Keyboard", "C. Motherboard", 2);
        addQuestion(q1);
        Question q2 = new Question("A metal and plastic box that contains the main components of the computer?", "A. Heat Sink", "B. Computer Case", "C. Printer", 2);
        addQuestion(q2);
        Question q3 = new Question("One of the most essential parts of computer system?", "A. Motherboard", "B. Modem", "C. RJ45", 1);
        addQuestion(q3);
        Question q4 = new Question("The brain of Computer?", "A. CPU", "B. Memory", "C. Keyboard", 1);
        addQuestion(q4);
        Question q5 = new Question("A device similar to a television used as to give a graphical display of the output from a computer?", "A. Scanner", "B. AVR", "C. Monitor", 3);
        addQuestion(q5);
        Question q6 = new Question("An input device that is moved over a pad or other flat surface to produce a corresponding movement of pointer on a graphical display?", "A. Mouse", "B. Desktop", "C. Touch pad", 1);
        addQuestion(q6);
        Question q7 = new Question("RAM stands for?", "A. Resource Application Memory", "B. Random Access Memory", "C. Revice Access Memory", 2);
        addQuestion(q7);
        Question q8 = new Question(" ROM stands for?", "A. Ready Operated Machine", "B. Read Only Memory", "C. Revice Access Memory", 2);
        addQuestion(q8);
        Question q9 = new Question(" A computer chip on the motherboard .It's storing when the computer is shut down?", "A. ROM", "B. CMOS", "C. Motherboard", 2);
        addQuestion(q9);
        Question q10 = new Question(" Central Processing Unit?", "A. ROM", "B. CMOS", "C. CPU", 3);
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
