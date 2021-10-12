package org.launchcode;

import java.util.Scanner;

public abstract class ScorableQuestion extends Question {
    private String[] possibleAnswers;
    private String[] correctAnswers;

    public ScorableQuestion(String questionText, int pointValue, String[] possibleAnswers, String[] correctAnswers) {
        super(questionText, pointValue);
        this.possibleAnswers = possibleAnswers;
        this.correctAnswers = correctAnswers;
    }

    public String[] getPossibleAnswers() {
        return possibleAnswers;
    }

    public String[] getCorrectAnswers() {
        return correctAnswers;
    }

    @Override
    public boolean askQuestion(Scanner scan)
    {
        System.out.println(getQuestionText());
        int choice = -1;
        String[] possibleAnswers = getPossibleAnswers();
        for (int i = 0; i < possibleAnswers.length; i++) {
            System.out.println(i+") "+possibleAnswers[i]);
        }
        boolean invalidChoice = true;
        while(invalidChoice)
        {
            choice = scan.nextInt();
            scan.nextLine();
            if (choice<0||choice>=possibleAnswers.length)
            {
                System.out.println("Invalid choice.");
            }
            else
                invalidChoice = false;
        }
        provideAnswer(possibleAnswers[choice]);
        if (possibleAnswers[choice].equals(getCorrectAnswers()[0]))
            return true;
        else
            return false;
    }
}
