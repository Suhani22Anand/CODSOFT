package CodSOFT;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.List;

class QuizQuestion {
    String question;
    List<String> options;
    int correctAnswer;
    
    public QuizQuestion(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}
public class QuizApplication {
	private static boolean answered = false;
    private static int score = 0;
    private static List<String> results = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<QuizQuestion> quiz = new ArrayList<>();
        quiz.add(new QuizQuestion("Ghibli art form is of which country?", 
                List.of("1. INDIA", "2. JAPAN", "3. CHINA", "4.KOREA "), 2));
        quiz.add(new QuizQuestion("best water absorbing material?", 
                List.of("1. cotton", "2. SAP", "3.foam ", "4. none"), 2));
        quiz.add(new QuizQuestion("PM Modi came into power in year?", 
                List.of("2017 ", "2. 2014", "3. 2015", "4. 6"), 2));
        
        System.out.println("Welcome to the Quiz Application!");
        System.out.println("You will have 10 seconds to answer each question.\n");
        for (int i = 0; i < quiz.size(); i++) {
            QuizQuestion currentQuestion = quiz.get(i);
            answered = false;
            
            
            System.out.println("\nQuestion " + (i + 1) + ": " + currentQuestion.question);
            for (String option : currentQuestion.options) {
                System.out.println(option);
            }
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    if (!answered) {
                        System.out.println("\nTime's up!");
                        results.add("Q" + (i + 1) + ": Time's up - Correct answer was " + 
                                  currentQuestion.options.get(currentQuestion.correctAnswer - 1));
                        scanner.nextLine(); // Clear any pending input
                        timer.cancel();
                    }
                }
            }, 10000);
            System.out.print("\nYour answer (1-4): ");
            int userAnswer = 0;
            try {
                userAnswer = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
            }
            
           
            if (userAnswer == currentQuestion.correctAnswer) {
                score++;
                results.add("Q" + (i + 1) + ": Correct!");
                System.out.println("Correct!");
            } else if (userAnswer >= 1 && userAnswer <= 4) {
                results.add("Q" + (i + 1) + ": Incorrect - Correct answer was " + 
                          currentQuestion.options.get(currentQuestion.correctAnswer - 1));
                System.out.println("Incorrect! Correct answer was " + 
                                  currentQuestion.options.get(currentQuestion.correctAnswer - 1));
            }
            
            answered = true;
            timer.cancel();
        }
        System.out.println("\nQuiz Completed!");
        System.out.println("Your final score: " + score + "/" + quiz.size());
        System.out.println("\nResults Summary:");
        for (String result : results) {
            System.out.println(result);
        }
        
        scanner.close();
    }
}


