package com.example.comptermsquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.comptermsquiz.Quiz5Contract.Question1Table;

import java.util.ArrayList;

public class Quiz5DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz5.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public Quiz5DbHelper(Context context) {
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
        Question q1 = new Question( "A Dutch programmer best known as the author of the Python programming language.", "A.James Arthur Gosling", "B. Guido van Rossum ", "C. Brendan Eich ", 2);
        addQuestion(q1);
        Question q2 = new Question("He co-founded the Mozilla project.", "A. Martin Odersky ", "B. Brendan Eich ", "C. Bjarne Stroustrup ", 2);
        addQuestion(q2);
        Question q3 = new Question("He is a Canadian computer scientist, best known as the founder and lead designer behind the Java programming language.", "A.James Arthur Gosling", "B.Chris Lattner ", "C. Anders Hejlsberg", 1);
        addQuestion(q3);
        Question q4 = new Question("An American software engineer best known as the main author of LLVM.", "A. Chris Lattner", "B. Robert C. Pike", "C. Yukihiro Matsumoto", 1);
        addQuestion(q4);
        Question q5 = new Question("Who is the creator of Go language?", "A. Chris Lattner", "B. Anders Hejlsberg", "C. Robert Griesemer", 3);
        addQuestion(q5);
        Question q6 = new Question("He is a prominent Danish software engineer who co-designed several popular and commercially successful programming languages and development tools.", "A. Anders Hejlsberg", "B. Guido van Rossum", "C. James Arthur Gosling", 1);
        addQuestion(q6);
        Question q7 = new Question("A Danish computer scientist, most notable for the creation and development of the C++ programming language.", "A. Anders Hejlsberg", "B. Bjarne Stroustrup", "C. James Arthur Gosling", 2);
        addQuestion(q7);
        Question q8 = new Question("A German computer scientist and professor of programming methods at École Polytechnique Fédérale de Lausanne in Switzerland.", "A. Guido van Rossum", "B. Anders Hejlsberg", "C. Martin Odersky", 3);
        addQuestion(q8);
        Question q9 = new Question("A Japanese computer scientist and software programmer best known as the chief designer of the Ruby programming language.", "A. Yukihiro Matsumoto", "B. Bjarne Stroustrup", "C. Robert Griesemer", 1);
        addQuestion(q9);
        Question q10 = new Question("He designed the Scala programming language and Generic Java both with others.", "A. Yukihiro Matsumoto", "B. Martin Odersky ", "C. Guido van Rossum", 2);
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
