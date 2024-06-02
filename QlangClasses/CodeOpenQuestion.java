package QlangClasses;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CodeOpenQuestion extends Question {
    private String question;
    private Code answer;
    private Code solution;
    private String inputFilePath;
    private Fraction score;
    private CodeOpenQuestion clone;

    public CodeOpenQuestion(Result result, String question, Code solution, String id) {
        super(result, id);
        this.question = question;
        this.solution = solution;
        this.answer = new Code("");
        this.inputFilePath = "CodeOpenQuestionInputFile.txt";
        this.score = new Fraction(0, 1); // Initialize with a valid fraction
        createInputFile();
        System.out.println();
    }

    public String getAnswer() {
        return this.answer.getCode();
    }

    private void createInputFile() {
        try {
            File inputFile = new File(inputFilePath);
            inputFile.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred while creating the input file.");
            e.printStackTrace();
        }
    }

    @Override
    public Fraction execute(Scanner scanner) {
        clone = new CodeOpenQuestion(super.getResult(), this.question, this.solution, this.getID());
        return clone.run(scanner);
    }

    public Fraction run(Scanner scanner) {
        System.out.println();
        System.out.println(question);
        System.out.println("Please write your code in the file: " + inputFilePath);
        System.out.println("Once you have completed, type 'SUBMIT' to submit your code.\n");

        while (true) {
            System.out.print("Command: ");
            String inputLine = scanner.nextLine();
            if (inputLine.equalsIgnoreCase("SUBMIT")) {
                break;
            } else {
                System.out.println("Invalid command. Type 'SUBMIT' when you are ready.");
            }
        }

        // Read the user's code and the solution code and compare them
        try {
            boolean match = false;
            String userCode = new String(Files.readAllBytes(Paths.get(inputFilePath))).strip();
            

            answer = new Code(userCode);
            String solution_str = solution.getCode()

            if (solution_str.equals(this.answer.getCode().trim())) {
                System.out.println("Your code matches the solution!");
                rightAnswer();
            } else {
                System.out.println("Your code does not match the solution.");
                wrongAnswer();
            }

        } catch (IOException e) {
            System.out.println("Error reading the files: " + e.getMessage());
        }

        try {
            Files.deleteIfExists(Paths.get(inputFilePath));
        } catch (IOException e) {
            System.out.println("Error deleting the input file: " + e.getMessage());
        }
        return this.score;
    }

    private void rightAnswer() {
        this.score.setNumerator(1);
        this.getResult().updateGrade(this.score, this.getQuestion(), this.solution.getCode(), this.getAnswer());
    }

    private void wrongAnswer() {
        this.score.setNumerator(0);
        this.getResult().updateGrade(this.score, this.getQuestion(), this.solution.getCode(), this.getAnswer());
    }


    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public QuestionInterface getInstance() {
        return new CodeOpenQuestion(super.getResult(), this.question, this.solution, this.getID());
    }
}