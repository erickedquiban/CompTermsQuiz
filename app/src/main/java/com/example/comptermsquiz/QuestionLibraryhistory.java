package com.example.comptermsquiz;

public class QuestionLibraryhistory {
    private String mQuestions1[]= {
            "1. An English mathematics professor who designed the Analytic Engine?" ,
            "2. Computers can be classified into how many generations?",
            "3. In what generation of computers can only perform a single task and had " +
                    "no Operating System. What generation is this?",
            "4. .During this generation of computers over 100 computer programming " +
                    "language were developed, computers had memory and Operating System." +
                    " What generation is this?",
            "5..In what generation of computers where it became smaller,more " +
                    "powerful,more reliable and they were able to run many different programs " +
                    "at the same time.",

            "Thank You for taking Quiz",


    };

    private String mChoices [] [] ={
            {"Charles Darwin","Steve Jobs","Mark Zuckerberg","Charles Babbage"},
            {"1","2","3","4"},
            {"Fourth Generation","Third Generation","Second Generation","First Generation"},
            {"Fourth Generation","Third Generation","Second Generation","First Generation"},
            {"Fourth Generation","Third Generation","Second Generation","First Generation"},

            {"","","",""},

    };


    private String mCorrectAnswers[]= {"Charles Babbage","3","First Generation","Second Generation","Third Generation","utot"};


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
