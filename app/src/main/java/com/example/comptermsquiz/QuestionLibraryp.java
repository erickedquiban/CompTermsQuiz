package com.example.comptermsquiz;

public class QuestionLibraryp {
    private String mQuestions1[]= {
            "A type writer - style device which uses an arrangement of buttons or key to act as mechanical levers or " +
                    "electronic switches?" ,
           " A metal and plastic box that contains the main components of the computer?",
            " One of the most essential parts of computer system.",
            "The brain of Computer?",
            "A device similar to a television used as to give a graphical display of the output from a computer?",
            "An input device that is moved over a pad or other flat surface to produce a corresponding movement of" +
                    "pointer on a graphical display?",
            " RAM stands for?",
            " ROM stands for?",
            " A computer chip on the motherboard or more specifically a RAM chip which means it would normally lose" +
                    "the setting it's storing when the computer is shut down?",
            "Thank You for taking Quiz",


    };

    private String mChoices [] [] ={
            {"Mouse","Monitor","Motherboard","Keyboard"},
            {"Heat Sink","Computer Case","Printer","Scanner"},
            {"Motherboard","Modem","RJ45","USB"},
            {"CPU","Memory","Keyboard","Screen"},
            {"Scanner","AVR","Monitor","Xerox Machine"},
            {"Mouse","Desktop","Touch pad","Track ball"},
            {"Resource App. Memory","Random Access Memory","Revise Access Memory","None of the Above"},
            {"Ready Operated Machine","Random Access Memory","Read Only Memory","None of the Above"},
            {"ROM","CMOS","Motherboard","RAM"},
            {"","","",""},

    };


    private String mCorrectAnswers[]= {"Keyboard","Computer Case","Motherboard","CPU","Monitor","Mouse","Random Access Memory",
    "Read Only Memory","CMOS","utot"};


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
