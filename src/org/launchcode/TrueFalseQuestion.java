package org.launchcode;

import java.util.Scanner;

public class TrueFalseQuestion extends ScorableQuestion {

    public TrueFalseQuestion(String questionText, int pointValue, String correctAnswer) {
        super(questionText, pointValue, new String[]{"True","False"}, new String[]{correctAnswer});
    }

}
