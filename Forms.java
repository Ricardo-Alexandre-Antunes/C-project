import java.util.Scanner;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.FileNotFoundException;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Paths;

class Forms {
    static class Result {
        private String name;
        private int id;
        private Fraction grade;

        public Result(String name, int id) {
            this.name = name;
            this.id = id;
            this.grade = new Fraction(0, 0);
        }

        public Result() {
            this.name = "";
            this.id = -1;
            this.grade = new Fraction(0, 0);
        }

        public void updateGrade(int answer) {
            grade.updateGrade(answer);
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public Fraction getGrade() {
            return grade;
        }

        public void exportToFile(String fileName) {
            File exportFile = new File(fileName);
            PrintStream filePrinter = new PrintStream(exportFile);
            filePrinter.print("Grade: " + this.grade + "\n");
        }

    }

    static class Fraction {
        private Integer x;
        private Integer y;

        public Fraction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void updateGrade(int x) {
            if (this.x == null) {
                return;
            }
            if (x == -1) {
                this.y++;
            } else if (x == 0) {
                this.x = null;
                this.y++;
            } else {
                this.x++;
                this.y++;
            }
        }

        @Override
        public String toString() {
            if (this.x == null) {
                return "Undefined";
            }
            if (this.y == 0) {
                return "Invalid Fraction (division by zero)";
            }
            return ((double) this.x / this.y) * 100 + "%";
        }
    }

    abstract static class Question {
        abstract int execute(Scanner sc);

        abstract String getQuestion();

        abstract int getQuestionId();

    }

    static class HoleQuestion extends Question {
        String[] question;
        String[] solution;
        String[] answer;
        int id;
        int result;

        public HoleQuestion(String[] question, String[] solution) {
            this.question = question;
            this.solution = solution;
            this.answer = new String[solution.length];
            this.id = 0;
        }

        @Override
        public int execute(Scanner scanner) {
            System.out.println(question.length);
            for (int i = 0; i < question.length; i++) {
                System.out.print(question[i]);
                if (i != solution.length) {
                    answer[i] = scanner.nextLine();
                }
            }
            return answer.equals(solution) ? 1 : -1;
        }

        @Override
        public int getQuestionId() {
            return this.id;
        }

        @Override
        public String getQuestion() {
            String question_str = "";
            for (int i = 0; i < this.question.length; i++) {
                question_str += this.question[i];
            }
            return question_str;
        }

        public String getSolution() {
            String solution_str = "";
            for (int i = 0; i < this.solution.length; i++) {
                solution_str += this.solution[i];
            }
            return solution_str;
        }

        public String getAnswer() {
            String answer_str = "";
            for (int i = 0; i < this.answer.length; i++) {
                answer_str += this.answer[i];
            }
            return answer_str;
        }

    }

    static class OpenQuestion extends Question {
        String question;
        String answer;
        int id;
        Scanner sc;

        public OpenQuestion(String question) {
            this.question = question;
            this.answer = "";
            this.id = 0;
        }

        @Override
        public int execute(Scanner scanner) {
            StringBuilder sb = new StringBuilder();

            System.out.println("Answer the following question:");
            System.out.println(question);
            System.out.println("Type 'END' on a new line when you are done.");

            while (true) {
                System.out.print("Answer:");
                String inputLine = scanner.nextLine();
                if (inputLine.equalsIgnoreCase("END")) {
                    break;
                }
                sb.append(inputLine).append("\n");
            }

            answer = sb.toString();
            return 0;
        }

        @Override
        public int getQuestionId() {
            return this.id;
        }

        @Override
        public String getQuestion() {
            return "";
        }
    }

    public static class CodeOpenQuestion extends Question {
        private String question;
        private String answer;
        private int id;
        private String solutionFile;
        private String inputFilePath;

        // Constructor to initialize the CodeOpenQuestion with a question and
        // solutionFile.
        public CodeOpenQuestion(String question, String solutionFile) {
            this.question = question;
            this.solutionFile = solutionFile;
            this.answer = "";
            this.id = 0;
            this.inputFilePath = "CodeOpenQuestionInputFile.txt";
            createInputFile();
        }

        // Method to create the input file
        private void createInputFile() {
            try {
                File inputFile = new File(inputFilePath);
                if (inputFile.createNewFile()) {
                    System.out.println("File created: " + inputFilePath);
                } else {
                    System.out.println("File already exists: " + inputFilePath);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating the input file.");
                e.printStackTrace();
            }
        }

        // Executes the question prompt, reads the user's submitted file, and compares
        // it to the solution.
        @Override
        public int execute(Scanner scanner) {
            System.out.println(question);
            System.out.println("Please write your code in the file: " + inputFilePath);
            System.out.println("Once you have completed, type 'SUBMIT' to submit your code.");

            while (true) {
                System.out.print("Command: ");
                String inputLine = scanner.nextLine();
                if (inputLine.equalsIgnoreCase("SUBMIT")) {
                    break;
                } else {
                    System.out.println("Invalid command. Type 'SUBMIT' when you are ready.");
                }
            }

            try {
                // Read user's code from the inputFilePath
                String userCode = new String(Files.readAllBytes(Paths.get(inputFilePath)));

                // Read solution code from the solutionFile
                String solutionCode = new String(Files.readAllBytes(Paths.get(solutionFile)));

                // Store the user's answer
                answer = userCode.strip();

                String code_solution = solutionCode.strip();

                // Compare the user's code with the solution code
                if (this.answer.equals(code_solution)) {
                    System.out.println("Your code matches the solution!");
                    return 1; // Success
                } else {
                    System.out.println("Your code does not match the solution. Please try again.");
                    return 0; // Failure
                }

            } catch (IOException e) {
                System.out.println("Error reading the files: " + e.getMessage());
                return -1; // Error
            }
        }

        // Gets the unique question ID.
        @Override
        public int getQuestionId() {
            return this.id;
        }

        // Gets the question text.
        @Override
        public String getQuestion() {
            return this.question;
        }
    }

    // Additional methods and functionality can be added as needed.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Result result = new Result();
        String filename = "result.txt";
        result.name = "User Name"; // Placeholder for user name
        result.id = 1; // Placeholder for user ID
        writer.write("Name: " + result.name + "\n");
        writer.write("ID: " + result.id + "\n");

        // Question 1
        String[] question = { "A atribuição de valor em PIL usa o operador ", "." };
        String[] answer = { ":=" }; // Placeholder para respostas
        HoleQuestion q1 = new HoleQuestion(question, answer);
        int a = q1.execute(scanner);
        result.updateGrade(a);
        result.exportToFile(writer);

        // Open Question
        OpenQuestion q2 = new OpenQuestion("Defina a estrutura de dados lista ligada.");
        result.updateGrade(q2.execute(scanner));
        result.exportToFile(writer);

        // CodeOpenQuestion
        String even_odd_question = "Implemente um programa que, pedindo um número inteiro do utilizador com o texto 'Number: ', escreva na consola se este é par (even) ou ímpar (odd).";
        String codeOpen_file_name = "codeOpenTestFile.txt";
        CodeOpenQuestion q3 = new CodeOpenQuestion(even_odd_question, codeOpen_file_name);
        result.updateGrade(q3.execute(scanner));
        result.exportToFile(codeOpen_file_name);

        scanner.close();
    }

}
