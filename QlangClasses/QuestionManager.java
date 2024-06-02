package QlangClasses;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionManager implements QuestionInterface {
    private ArrayList<QuestionInterface> hierarchicalQuestions;
    private String category;

    public QuestionManager(String category) {
        this.hierarchicalQuestions = new ArrayList<>();
        this.category = category;
    }

    public QuestionInterface getInstance() {
        Random random = new Random();
        int randomIndex = random.nextInt(hierarchicalQuestions.size());
        return hierarchicalQuestions.get(randomIndex).getInstance();
    }

    public void addQuestion(QuestionInterface question) {
        this.hierarchicalQuestions.add(question);
    }

    public String getId() {
        return this.category;
    }

    public Fraction execute(Scanner scanner) {
        return this.getInstance().execute(scanner);
    }
}