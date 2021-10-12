package org.launchcode;

import java.util.Scanner;

public class OpenEndedQuestion extends Question{

    private int characterLimit;

    public OpenEndedQuestion(String questionText, int pointValue, int characterLimit) {
        super(questionText, pointValue);
        this.characterLimit = characterLimit;
    }

    @Override
    public boolean askQuestion(Scanner scan) {
        System.out.println(getQuestionText());
        String answer = scan.nextLine();
        if (answer.length() > 0)
        {
            if (characterLimit < answer.length())
            {
                System.out.println("Character limit exceeded. Answer shortened to "+characterLimit+" characters.");
                answer = answer.substring(0,characterLimit);
            }
            provideAnswer(answer);
            return true;
        }
        else
        {
            provideAnswer("");
            return false;
        }
    }
}
