package QlangClasses;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class CodeHoleQuestion extends Question {
    Code code;
    String[] solution;
    String[] answer;
    String[] grades;
    String question;
    int denominator;
    int numerator;
    Fraction score;
    CodeHoleQuestion clone;
    List<String> code_arr;

    public CodeHoleQuestion(Result result, String question, Code code, String[] solution, String[] grades, String id) {
        super(result, id);
        this.question = question;
        this.solution = solution;
        this.code = code; //isto aqui vai ter de ser passado do tipo code e a descoberta dos espaços vai ser feita separando em subs
        this.answer = new String[solution.length];
        this.grades = grades;
        this.numerator = 0;
        this.denominator = 0;
        this.clone = null;
        setDenominator();
        this.score = new Fraction(this.numerator, this.denominator); // Initialize with a valid fraction
        this.code_arr = splitString(code.getCode(), solution);
    }

    public QuestionInterface getInstance() {
        return new CodeHoleQuestion(super.getResult(), this.question, this.code, this.solution, this.grades, super.getID());
    }

    private void setDenominator() {
        for (int i = 0; i < grades.length; i++) {
            this.denominator += Integer.parseInt(grades[i]);
        }
    }

    public static List<String> splitString(String code, String[] solution) {
        // Construir o padrão regex a partir do array B
        StringBuilder patternBuilder = new StringBuilder();
        for (String s : solution) {
            if (patternBuilder.length() != 0) {
                patternBuilder.append("|");
            }
            patternBuilder.append(Pattern.quote(s));
        }
        String pattern = patternBuilder.toString();
        
        // Dividir a string A usando o padrão regex
        String[] splitArray = code.split(pattern);
        
        // Converter o array resultante em uma lista
        List<String> splitResult = new ArrayList<>();
        for (String str : splitArray) {
            splitResult.add(str);
        }
        
        return splitResult;
    }

    private Fraction finishedAnswer() {
        this.score.setNumerator(numerator);
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
        return this.run(scanner);
    }

    public Fraction run(Scanner scanner) {
        StringBuilder codeText = new StringBuilder();
        for (int i = 0; i < code_arr.size(); i++) {
            codeText.append(code_arr.get(i));
            if (i < code_arr.size() - 1) {
                codeText.append(" __" + (i + 1) + "__ ");
            }
        }
        System.out.println(codeText.toString());

        for (int i = 0; i < answer.length; i++) {
            System.out.print((i + 1) + " - ");
            this.answer[i] = scanner.nextLine().trim();
        }

        for (int i = 0; i < solution.length; i++) {
            if (solution[i].equals(answer[i])) {
                numerator += Integer.parseInt(grades[i]);
            }
        }

        return finishedAnswer();
    }

    @Override
    public String getQuestion() {
        return this.question;
    }

    public String getSolution() {
        return String.join("", solution);
    }

    public String getAnswer() {
        return String.join("", answer);
    }
}