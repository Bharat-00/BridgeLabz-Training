class ExamTimeExpiredException extends Exception {
    public ExamTimeExpiredException(String msg) {
        super(msg);
    }
}
interface EvaluationStrategy {
    int evaluate();
}
class ObjectiveEvaluation implements EvaluationStrategy {
    @Override
    public int evaluate() {
        return 80;
    }
}
public class OnlineExaminationSystem {
    public static void main(String[] args) {
        EvaluationStrategy eval = new ObjectiveEvaluation();
        System.out.println("Score: " + eval.evaluate());
    }
}
