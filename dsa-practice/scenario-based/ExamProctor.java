import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
public class ExamProctor {
    private Stack<Integer> navigationStack;
    private Map<Integer, String> answers;
    private Map<Integer, String> correctAnswers;
    public ExamProctor() {
        navigationStack = new Stack<>();
        answers = new HashMap<>();
        correctAnswers = new HashMap<>();
        // Correct answers
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");
    }
    // Navigate to question
    public void visitQuestion(int questionId) {
        navigationStack.push(questionId);
        System.out.println("Visited Question: " + questionId);
    }
    // Store answer
    public void submitAnswer(int questionId, String answer) {
        answers.put(questionId, answer);
        System.out.println("Answer saved for Question " + questionId);
    }
    // Go back
    public void goBack() {
        if (!navigationStack.isEmpty()) {
            navigationStack.pop();
            System.out.println("Went back to previous question.");
        } else {
            System.out.println("No previous question.");
        }
    }
    // Evaluate exam
    public int evaluateScore() {
        int score = 0;
        for (int qId : correctAnswers.keySet()) {
            if (correctAnswers.get(qId).equals(answers.get(qId))) {
                score++;
            }
        }
        return score;
    }
    // Main method
    public static void main(String[] args) {
        ExamProctor exam = new ExamProctor();
        exam.visitQuestion(1);
        exam.submitAnswer(1, "A");
        exam.visitQuestion(2);
        exam.submitAnswer(2, "C");
        exam.visitQuestion(3);
        exam.submitAnswer(3, "C");
        exam.goBack();
        int score = exam.evaluateScore();
        System.out.println("Final Score: " + score);
    }
}
