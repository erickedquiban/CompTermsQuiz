package com.example.comptermsquiz;

public class QuestionLibrarypro {
    private String mQuestions1[]= {
            "1. What was the name of the first operating system kernels implemented in a language other than assembly?" ,
            "2. Who is the developer of a language between 1969 and 1973 know as C language?",
            "3. What was the name of the oldest languge still in use created by John Backus ?",
            "4. FORTRAN stands for ?",
            "5. He modified the C language to C++  the most popular programming language he created. Who is he ?",
            "6.  This is develop since 1995 to run set top boxes for interactive television?",
            "7.  What language is know as a low level programming language? ?",

            "Thank You for taking Quiz",


    };

    private String mChoices [] [] ={
            {"C language","Fortran","Assembly","Java"},
            {"Jonh Backus","Newton","Dennis Retchie","Charlse Babbage"},
            {"Fortran","C Language","Assembly","Java"},
            {"Formula Translation","Formula Transent","Formulated Translation","None of the above"},
            {"Micheal Bijarne","Isaac Newton","Dennis Ritchie","Bjarne Stroustrup"},
            {"C language","Fortran","Assembly","Java"},
            {"C language","Fortran","Assembly","Java"},

            {"","","",""},

    };


    private String mCorrectAnswers[]= {"C language","Dennis Retchie","Fortran","Formula Translation","Bjarne Stroustrup","Java","Assembly",
    "utot"};


    public String getQuestion (int a) {
        String question= mQuestions1[a];
        return question;
    }

    public String getChoice11(int a) {
        String choice1=mChoices[a][0];
        return choice1;
    }

    public String getChoice12(int a) {
        String choice2=mChoices[a][1];
        return choice2;
    }
    public String getChoice13(int a) {
        String choice3=mChoices[a][2];
        return choice3;
    }
    public String getChoice14(int a) {
        String choice4= mChoices     [a][3];
        return choice4;

    }  public String getmCorrectAnswers(int a){
        String answer1 = mCorrectAnswers[a];
        return answer1;
    }
}
