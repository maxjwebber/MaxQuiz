package org.launchcode;


public class MultipleChoiceQuestion extends ScorableQuestion {

    public MultipleChoiceQuestion(String questionText, int pointValue, String[] possibleAnswers, String correctAnswer) {
        super(questionText, pointValue, possibleAnswers,new String[]{correctAnswer});
    }

}
