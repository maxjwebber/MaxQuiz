package org.launchcode;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckboxQuestion extends ScorableQuestion{
    public CheckboxQuestion(String questionText, int pointValue, String[] possibleAnswers, String[] correctAnswers) {
        super(questionText, pointValue, possibleAnswers, correctAnswers);
    }

    @Override
    public boolean askQuestion(Scanner scan)
    {
        System.out.println(getQuestionText());
        int choice = 0;
        String[] possibleAnswers = getPossibleAnswers();
        boolean invalidChoice = true;
        boolean stillChoosing = true;
        boolean [] checked = new boolean[possibleAnswers.length];
        for (boolean box: checked)
        {
            box = false;
        }
        while(invalidChoice || stillChoosing)
        {
            for (int i = 0; i < possibleAnswers.length; i++) {
                if (checked[i])
                    System.out.println("[X] "+i+") "+possibleAnswers[i]);
                else
                    System.out.println("[ ] "+i+") "+possibleAnswers[i]);
            }
            System.out.println("Enter a number to check the box. Enter -1 when finished.");
            choice = scan.nextInt();
            scan.nextLine();
            if (choice>=possibleAnswers.length)
            {
                System.out.println("Invalid choice.");
                invalidChoice = true;
            }
            else if (choice<0)
            {
                invalidChoice = false;
                stillChoosing = false;
            }
            else
            {
                invalidChoice = false;
                checked[choice] = true;
            }
        }
        for (int i = 0; i < checked.length; i++) {
            if(checked[i])
                provideAnswer(possibleAnswers[i]);
        }
        ArrayList<String> provided = getProvidedAnswers();
        String [] correct = getCorrectAnswers();
        if (correct.length != provided.size())
            return false;
        for (String s : correct) {
            if (!provided.contains(s))
                return false;
        }
        return true;
    }
}
