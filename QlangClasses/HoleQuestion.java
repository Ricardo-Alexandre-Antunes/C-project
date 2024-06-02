package QlangClasses;
import java.util.Scanner;

public class HoleQuestion extends Question {
    String[] question;
    String[] solution;
    String[] answer;
    Fraction score;
    HoleQuestion clone;

    public HoleQuestion(Result result, String[] question, String[] solution, String id) {
        super(result, id);
        this.question = question;
        this.solution = solution;
        this.answer = new String[solution.length];
        this.score = new Fraction(0, this.solution.length); // Initialize with a valid fraction
        this.clone = null;
    }

    private Fraction rightAnswer() {
        this.score.setNumerator(this.score.getNumerator() + 1);
        String answerCompilation = "";
        for (int i = 0; i < answer.length; i++) {
            answerCompilation += answer[i];
            if (i < answer.length - 1) {
                answerCompilation += ", ";
            }
        }
        String solutionCompilation = "";
        for (int i = 0; i < solution.length; i++) {
            solutionCompilation += solution[i];
            if (i < solution.length - 1) {
                solutionCompilation += ", ";
            }
        }

        this.getResult().updateGrade(this.score, this.getQuestion(), solutionCompilation, answerCompilation);
        return this.score;
    }

    private Fraction wrongAnswer() {
        String answerCompilation = "";
        for (int i = 0; i < answer.length; i++) {
            answerCompilation += answer[i];
            if (i < answer.length - 1) {
                answerCompilation += ", ";
            }
        }
        String solutionCompilation = "";
        for (int i = 0; i < solution.length; i++) {
            solutionCompilation += solution[i];
            if (i < solution.length - 1) {
                solutionCompilation += ", ";
            }
        }
        this.getResult().updateGrade(this.score, this.getQuestion(), solutionCompilation, answerCompilation);
        return this.score;
    }

    @Override
    public Fraction execute(Scanner scanner) {
        clone = new HoleQuestion(super.getResult(), this.question, this.solution, this.getID());
        return clone.run(scanner);
    }

    public Fraction run(Scanner scanner) {
        StringBuilder questionText = new StringBuilder();
        for (int i = 0; i < question.length; i++) {
            questionText.append(question[i]);
            if (i < question.length - 1) {
                questionText.append(" __" + (i + 1) + "__ ");
            }
        }
        System.out.println(questionText.toString());

        for (int i = 0; i < answer.length; i++) {
            System.out.print((i + 1) + " - ");
            this.answer[i] = scanner.nextLine().trim();
        }

        boolean isCorrect = true;
        for (int i = 0; i < solution.length; i++) {
            if (!solution[i].equals(answer[i])) {
                isCorrect = false;
                break;
            }
        }

        if (isCorrect) {
            return rightAnswer();
        } else {
            return wrongAnswer();
        }
    }

    @Override
    public String getID() {
        return super.getID();
    }

    @Override
    public String getQuestion() {
        return String.join("", question);
    }

    public String getSolution() {
        return String.join("", solution);
    }

    public String getAnswer() {
        return String.join("", answer);
    }

    @Override
    public QuestionInterface getInstance() {
        return new HoleQuestion(super.getResult(), this.question, this.solution, this.getID());
    }
}