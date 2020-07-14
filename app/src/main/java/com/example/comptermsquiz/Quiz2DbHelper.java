package com.example.comptermsquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.comptermsquiz.Quiz2Contract.Question1Table;

import java.util.ArrayList;

public class Quiz2DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz2.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public Quiz2DbHelper(Context context) {
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
        Question q1 = new Question( "An English mathematics professor who designed the Analytic Engine?", "A.Charles Babbage", "B. Steve Jobs", "C. Charles Darwin", 1);
        addQuestion(q1);
        Question q2 = new Question("It is invented by chinese around 4,000 years ago?", "A. Pascaline", "B. Difference Engine", "C.Abacus", 3);
        addQuestion(q2);
        Question q3 = new Question("It composed of 9 ivory strips or bone marked with numbers to multiply and divide?", "A. Abacus", "B. Napier's Bone", "C. Tabulating Machine", 2);
        addQuestion(q3);
        Question q4 = new Question("Also known as Arithmetic Machine or Adding Machine?", "A. Stepped Reckoner", "B. Analytical Engine", "C. Pascaline", 3);
        addQuestion(q4);
        Question q5 = new Question("It is digital mechanical calculator?", "A. Difference Engine", "B. Stepped Reckoner", "C. Abacus", 2);
        addQuestion(q5);
        Question q6 = new Question("It is a mechanical computer which could perform simple calculations?", "A. Difference Engine", "B. Differential Analyzer", "C. Mark 1", 1);
        addQuestion(q6);
        Question q7 = new Question("A mechanical computer that used punch-cards as input?", "A. Stepped Reckoner", "B. Analytical Engine", "C. Pascaline", 2);
        addQuestion(q7);
        Question q8 = new Question("He invented the Tabulating Machine?", "A. Herman Hollerith", "B. Vannevar Bush", "C. Howard Aiken", 1);
        addQuestion(q8);
        Question q9 = new Question("When did introduced the differential Analyzer?", "A. 1910", "B. 1920", "C. 1930", 3);
        addQuestion(q9);
        Question q10 = new Question("The first programmable digital computer?", "A. Mark 3", "B. Mark 1", "C. Mark 2", 2);
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
