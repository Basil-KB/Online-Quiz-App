package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Step 1: Create list of questions
	        List<Question> questions = new ArrayList<>();
	        questions.add(new Question(
	        		"Which language is used for Android development?",
	                new String[]{"1. Python", "2. Java", "3. C#", "4. Ruby"},
	                1 // index for "Java"
	        ));
	        questions.add(new Question(
	                "Which planet is known as the Red Planet?",
	                new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"},
	                1
	        ));
	        questions.add(new Question(
	                "What is the largest ocean on Earth?",
	                new String[]{"1. Atlantic Ocean", "2. Pacific Ocean", "3. Indian Ocean", "4. Arctic Ocean"},
	                1
	        ));
	        questions.add(new Question("Which company developed Java?",
	                new String[]{"1. Sun Microsystems", "2.Microsoft ", "3. Apple", "4. Oracle"},
	                0
	        ));
	        
	        // Step 2: Ask how many players
	        System.out.print("Enter number of players: ");
	        int playerCount = Integer.parseInt(scanner.nextLine()); // safe input
	        // Step 3: Run quiz and score user
	        
	     // Step 3: Loop for each player
	        for (int p = 1; p <= playerCount; p++) {
	            System.out.println("\n===== Player " + p + "'s Turn =====");
	            System.out.print("Enter your name: ");
	            String playerName = scanner.nextLine();

	            int score = 0;

	            // Step 4: Loop through each question
	            for (int i = 0; i < questions.size(); i++) {
	                Question q = questions.get(i);
	                System.out.println("\nQ" + (i + 1) + ": " + q.questionText);
	                for (String opt : q.options) {
	                    System.out.println(opt);
	                }

	                // Input validation loop
	                int answer;
	                while (true) {
	                    System.out.print("Your answer (1-4): ");
	                    try {
	                        answer = Integer.parseInt(scanner.nextLine()) - 1; // convert to 0-based
	                        if (answer >= 0 && answer < q.options.length) {
	                            break;
	                        } else {
	                            System.out.println("Invalid choice! Please enter a number between 1 and 4.");
	                        }
	                    } catch (NumberFormatException e) {
	                        System.out.println("Invalid input! Please enter a number.");
	                    }
	                }

	                // Check answer
	                if (q.checkAnswer(answer)) {
	                    System.out.println("✅ Correct!\n");
	                    score++;
	                } else {
	                    System.out.println("❌ Wrong! Correct answer was: " + q.options[q.correctOption] + "\n");
	                }
	            }

	            // Step 5: Show result for this player
	            System.out.println("===== " + playerName + "'s Results =====");
	            System.out.println("Score: " + score + "/" + questions.size());
	            double percentage = ((double) score / questions.size()) * 100;
	            System.out.printf("Percentage: %.2f%%\n", percentage);

	            if (percentage >= 80) {
	                System.out.println("Grade: A (Excellent!)");
	            } else if (percentage >= 50) {
	                System.out.println("Grade: B (Good job!)");
	            } else {
	                System.out.println("Grade: C (Needs Improvement!)");
	            }
	        }

	        scanner.close();
	    }
	}