package org.launchcode;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Question {
    private final String questionText;
    private final int pointValue;
    private final ArrayList<String> providedAnswers;

    public Question(String questionText, int pointValue) {
        this.questionText = questionText;
        this.pointValue = pointValue;
        this.providedAnswers = new ArrayList<String>();
    }

    public int getPointValue() {
        return pointValue;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getProvidedAnswers() {
        return providedAnswers;
    }

    public void provideAnswer(String providedAnswer) {
        this.providedAnswers.add(providedAnswer);
    }

    public boolean askQuestion(Scanner scan)
    {
        return true;
    }


}
