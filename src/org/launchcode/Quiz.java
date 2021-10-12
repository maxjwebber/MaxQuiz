package org.launchcode;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Question> questions;
    private int pointsPending;
    private int pointsGained;
    private int maxPoints;

    public Quiz() {
        questions = new ArrayList<>();
        pointsPending = 0;
        pointsGained = 0;
        maxPoints = 0;
    }

    public void addQuestion(Question question)
    {
        questions.add(question);
    }
    public void runQuiz()
    {
        Scanner scanner = new Scanner(System.in);
        for (Question question: questions)
        {
            maxPoints+= question.getPointValue();
            if (question.askQuestion(scanner))
            {
                if (question instanceof OpenEndedQuestion)
                {
                    //question was answered, but needs an instructor to grade it.
                    pointsPending+=question.getPointValue();
                }
                else
                {
                    //question was answered correctly
                    pointsGained+= question.getPointValue();
                }
            }
        }
        scanner.close();
    }
    public void gradeQuiz()
    {
        System.out.println("FINAL RESULTS");
        if (pointsPending==0)
        {
            System.out.println(pointsGained+" points gained out of "+maxPoints+": "+((double)pointsGained / maxPoints * 100)+"%");
        }
        else
        {
            System.out.println(pointsGained+" points gained out of "+maxPoints+" ("+pointsPending+" points pending instructor grade)."+ " Maximum score is "+(((double)pointsGained+pointsPending) / maxPoints * 100)+"%");
        }
    }

}
