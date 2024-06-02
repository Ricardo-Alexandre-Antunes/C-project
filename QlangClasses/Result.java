package QlangClasses;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;

public class Result {
    private String name;
    private int id;
    private Fraction grade;
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    private ArrayList<String> solutions;
    private ArrayList<Fraction> grades;

    public Result() {
        this.name = "";
        this.id = -1;
        this.grade = new Fraction(0, 1); // Initialize with a valid fraction
        this.questions = new ArrayList<String>();
        this.answers = new ArrayList<String>();
        this.grades = new ArrayList<Fraction>();
        this.solutions = new ArrayList<String>();
    }

    public void updateGrade(Fraction result, String question, String solution, String answer) {
        this.questions.add(question);
        this.answers.add(answer);
        this.grades.add(result);
        this.solutions.add(solution);
        if (result != null && this.grade != null) {
            result = Fraction.simplifyFraction(result);
            System.out.println("Question grade: " + result);
            this.grade.setNumerator(this.grade.getNumerator() + result.getNumerator());
            this.grade.setDenominator(this.grade.getDenominator() + result.getDenominator());
        } else {
            this.grade = null;
        }
    }

    public void resetGrade() {
        this.grade = new Fraction(0, 1); // Reset to a valid fraction
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fraction getGrade() {
        return this.grade;
    }

    public void askName(Scanner scanner, String prompt) {
        System.out.print(prompt);
        this.name = scanner.nextLine();
        scanner.close();
        this.setName(name);
    }

    public void askID(Scanner scanner, String prompt) {
        System.out.print(prompt);
        this.id = scanner.nextInt();
        scanner.close();
        this.setID(id);
    }

    public void exportToFile(BufferedWriter w) {
        // System.out.println(this.grade.getNumerator() + "/" +
        // this.grade.getDenominator());
        try {
            w.write("Name: " + this.getName() + "\n");
            if (this.getId() == -1) {
                w.write("ID: " + "\n");
            } else {
                w.write("ID: " + this.getId() + "\n");
            }
            for (int question = 1; question <= this.questions.size(); question++) {
                
                w.write("Question " + question + ": " + this.questions.get(question - 1) + "\n");
                w.write("Answer: " + this.answers.get(question - 1) + "\n");
                w.write("Solution: " + this.solutions.get(question - 1) + "\n");
                if (this.grades.get(question - 1) != null) {
                    w.write("Grade: " + this.grades.get(question - 1) + "\n");
                } else {
                    w.write("Grade: Undefined\n");
                }
                w.write("--------------------\n");
            }
            w.write("Final Grade: " + ((this.grade == null) ? "Undefined" : this.grade) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Quizz completed. Check your result in result.txt");
    }
}