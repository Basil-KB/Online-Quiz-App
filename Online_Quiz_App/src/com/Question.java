package com;

public class Question {
	String questionText;
    String[] options;
    int correctOption; // index of correct answer (0-based)

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == correctOption;
    }
}