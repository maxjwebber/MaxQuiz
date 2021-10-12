package org.launchcode;

public class QuizRunner {

    public static void main(String[] args) {
	    Quiz myQuiz = new Quiz();
        myQuiz.addQuestion(new LinearScaleQuestion("What's a good number of wheels for a car to have?",5,3,5));
        myQuiz.addQuestion(new MultipleChoiceQuestion("Which of these Pokemon is weak to Fire attacks?",10,new String[]{"Bulbasaur", "Machop", "Geodude", "Charmander"},"Bulbasaur"));
        myQuiz.addQuestion(new TrueFalseQuestion("Max's favorite band is They Might Be Giants.",5,"True"));
        myQuiz.addQuestion(new CheckboxQuestion("Which of these tastes good on toast?",10,new String[]{"Butter","Cheese","Jelly","Vaseline"},new String[]{"Butter","Cheese","Jelly"}));
        myQuiz.addQuestion(new OpenEndedQuestion("In 50 characters or less, describe your relationship with your best friend.",20,50));
        myQuiz.runQuiz();
        myQuiz.gradeQuiz();

    }
}
