package com.example.comptermsquiz;

import android.provider.BaseColumns;

public final class Quiz9Contract {

    private Quiz9Contract(){}

    public static class Question1Table implements BaseColumns {


        public static final String TABLE_NAME = "quiz1_questions";
        public static final String COLUMN_QUESTION1 = "question1";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
    }
}

