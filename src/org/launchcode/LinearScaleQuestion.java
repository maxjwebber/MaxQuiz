package org.launchcode;

import java.util.Scanner;

public class LinearScaleQuestion extends Question{

    private int minAcceptable;
    private int maxAcceptable;

    public LinearScaleQuestion(String questionText, int pointValue, int minAcceptable, int maxAcceptable) {
        super(questionText, pointValue);
        this.minAcceptable = minAcceptable;
        this.maxAcceptable = maxAcceptable;
    }

    @Override
    public boolean askQuestion(Scanner scan)
    {
        System.out.println(getQuestionText());
        Integer choice = -1;
        boolean invalidChoice = true;
        while(invalidChoice)
        {
            choice = scan.nextInt();
            scan.nextLine();
            if (choice<0)
            {
                System.out.println("Invalid choice. Positive numbers (or zero) only, please.");
            }
            else
                invalidChoice = false;
        }
        provideAnswer(choice.toString());
        return choice >= minAcceptable && choice <= maxAcceptable;
    }
}
