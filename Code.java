import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.util.ArrayList;

class Forms {
    static class Result {
        private String name;
        private int id;
        private Fraction grade;
        private ArrayList<String> questions;
        private ArrayList<String> answers;
        private ArrayList<Fraction> grades;

        
        public Result(String name, int id) {
            this.name = name;
            this.id = id;
            this.grade = new Fraction(0, 1); // Initialize with a valid fraction
            this.questions = new ArrayList<String>();
            this.answers = new ArrayList<String>();
            this.grades = new ArrayList<Fraction>();
        }

        public Result() {
            this.name = "";
            this.id = -1;
            this.grade = new Fraction(0, 1); // Initialize with a valid fraction
        }

        public void updateGrade(Fraction result) {
            if (result != null && this.grade != null) {
                result = Fraction.simplifyFraction(result);
                System.out.println("Question grade: " + result);
                this.grade.setNumerator(this.grade.getNumerator() + result.getNumerator());
                this.grade.setDenominator(this.grade.getDenominator() + result.getDenominator());
            }
            else{
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

        public void askName(Scanner scanner, String prompt){
            System.out.print(prompt);
            this.name = scanner.nextLine();
            scanner.close();
            this.setName(name);
        }

        public void askID(Scanner scanner, String prompt){
            System.out.print(prompt);
            this.id = scanner.nextInt();
            scanner.close();
            this.setID(id);
        }

        public void exportToFile(BufferedWriter w) {
            //System.out.println(this.grade.getNumerator() + "/" + this.grade.getDenominator());
            try {
                w.write("Grade: " + ((this.grade == null) ? "Undefined" : this.grade)  + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Quizz completed. Check your result in result.txt");
        }
    }

    static class Fraction {
        private Integer numerator;
        private Integer denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Integer getNumerator() {
            return numerator;
        }

        public void setNumerator(Integer numerator) {
            this.numerator = numerator;
        }

        public Integer getDenominator() {
            return denominator;
        }

        public void setDenominator(Integer denominator) {
            this.denominator = denominator;
        }

        public static Fraction addFractions(Fraction fraction1, Fraction fraction2) {
            int newNumerator = fraction1.numerator * fraction2.denominator + fraction2.numerator * fraction1.denominator;
            int newDenominator = fraction1.denominator * fraction2.denominator;
            return new Fraction(newNumerator, newDenominator);
        }

        public static Fraction subtractFractions(Fraction fraction1, Fraction fraction2) {
            int newNumerator = fraction1.numerator * fraction2.denominator - fraction2.numerator * fraction1.denominator;
            int newDenominator = fraction1.denominator * fraction2.denominator;
            return new Fraction(newNumerator, newDenominator);
        }

        public static Fraction multiplyFractions(Fraction fraction1, Fraction fraction2) {
            int newNumerator = fraction1.numerator * fraction2.numerator;
            int newDenominator = fraction1.denominator * fraction2.denominator;
            return new Fraction(newNumerator, newDenominator);
        }

        public static Fraction divideFractions(Fraction fraction1, Fraction fraction2) {
            int newNumerator = fraction1.numerator * fraction2.denominator;
            int newDenominator = fraction1.denominator * fraction2.numerator;
            return new Fraction(newNumerator, newDenominator);
        }

        public static Fraction simplifyFraction(Fraction fraction) {
            int gcd = 1;
            int smaller = Math.min(Math.abs(fraction.numerator), Math.abs(fraction.denominator));
            for (int i = 2; i <= smaller; i++) {
                if (fraction.numerator % i == 0 && fraction.denominator % i == 0) {
                    gcd = i;
                }
            }
            return new Fraction(fraction.numerator / gcd, fraction.denominator / gcd);
        }


        @Override
        public String toString() {
            if (this.denominator == 0) {
                return "null";
            }
            return ((double) this.numerator / this.denominator) * 100 + "%";
        }
    }

    public interface QuestionInterface {
        public Fraction execute(Scanner sc);
    }

    abstract static class Question implements QuestionInterface {
        private Result result;

        public Question(Result result) {
            this.result = result;
        }

        public Result getResult() {
            return this.result;
        }

        abstract String getQuestion();

        abstract String getAnswer();

        abstract int getQuestionId();
    }

    static class HoleQuestion extends Question {
        String[] question;
        String[] solution;
        String[] answer;
        int id;
        Fraction score;

        public HoleQuestion(Result result, String[] question, String[] solution) {
            super(result);
            this.question = question;
            this.solution = solution;
            this.answer = new String[solution.length];
            this.id = 0;
            this.score = new Fraction(0, this.solution.length); // Initialize with a valid fraction
        }

        private Fraction rightAnswer() {
            this.score.setNumerator(this.score.getNumerator() + 1);
            return this.score;
        }

        private Fraction wrongAnswer() {
            return this.score;
        }

        @Override
        public Fraction execute(Scanner scanner) {
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
        public int getQuestionId() {
            return this.id;
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
    }

    static class OpenQuestion extends Question {
        String question;
        String answer;
        int id;

        public OpenQuestion(Result result, String question) {
            super(result);
            this.question = question;
            this.answer = "";
            this.id = 0;
        }

        @Override
        public Fraction execute(Scanner scanner) {
            StringBuilder sb = new StringBuilder();

            System.out.println("Answer the following question:");
            System.out.println(question);
            System.out.println("Type 'END' on a new line when you are done.");

            while (true) {
                System.out.print("Answer: ");
                String inputLine = scanner.nextLine();
                if (inputLine.equalsIgnoreCase("END")) {
                    break;
                }
                sb.append(inputLine).append("\n");
            }

            answer = sb.toString().trim();
            // Open questions are usually not graded here
            return null;
        }

        @Override
        public int getQuestionId() {
            return this.id;
        }

        @Override
        public String getQuestion() {
            return this.question;
        }

        @Override
        public String getAnswer() {
            return this.answer;
        }
    }

    public static class CodeOpenQuestion extends Question {
        private String question;
        private Code answer;
        private int id;
        private String solutionFile;
        private String inputFilePath;
        private Fraction score;

        public CodeOpenQuestion(Result result, String question, String solutionFile) {
            super(result);
            this.question = question;
            this.solutionFile = solutionFile;
            this.answer = new Code("");
            this.id = 0;
            this.inputFilePath = "CodeOpenQuestionInputFile.txt";
            this.score = new Fraction(0, 1); // Initialize with a valid fraction
            createInputFile();
        }

        public String getAnswer() {
            return this.answer.getCode();
        }

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

        @Override
        public Fraction execute(Scanner scanner) {
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
                String userCode = new String(Files.readAllBytes(Paths.get(inputFilePath))).strip();
                String solutionCode = new String(Files.readAllBytes(Paths.get(solutionFile))).strip();

                answer = new Code(userCode);

                if (solutionCode.equals(this.answer.getCode())) {
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
            }
            catch (IOException e) {
                System.out.println("Error deleting the input file: " + e.getMessage());
            }
                return this.score;
        }

        private void rightAnswer() {
            this.score.setNumerator(1);
            this.getResult().updateGrade(this.score);
        }

        private void wrongAnswer() {
            this.score.setNumerator(0);
            this.getResult().updateGrade(this.score);
        }

        @Override
        public int getQuestionId() {
            return this.id;
        }

        @Override
        public String getQuestion() {
            return this.question;
        }
    }

    public static class CodeHoleQuestion extends Question {
        String[] question;
        String[] solution;
        String[] answer;
        String[] grades;
        int id;
        int denominator;
        int numerator;
        Fraction score;

        public CodeHoleQuestion(Result result, String[] question, String[] solution, String[] grades) {
            super(result);
            this.question = question;
            this.solution = solution;
            this.answer = new String[solution.length];
            this.grades = grades;
            this.id = 0;
            this.numerator = 0;
            this.denominator = 0;
            setDenominator();
            this.score = new Fraction(this.numerator, this.denominator); // Initialize with a valid fraction
        }

        private void setDenominator() {
            for (int i = 0; i < grades.length; i++) {
                this.denominator += Integer.parseInt(grades[i]);
            }
        }

        private Fraction finishedAnswer() {
            this.score.setNumerator(numerator);
            this.getResult.
            return this.score;
        }

        @Override
        public Fraction execute(Scanner scanner) {
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

            for (int i = 0; i < solution.length; i++) {
                if (solution[i].equals(answer[i])) {
                    numerator += Integer.parseInt(grades[i]);
                }
            }

            return finishedAnswer();
        }

        @Override
        public int getQuestionId() {
            return this.id;
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
    }

    public static class Code {
        private String code;

        public Code(String code_inline){
            this.code = code_inline.strip();
        }

        public Code(File code_file) {
            readCodeFromFile(code_file);
        }

        public void readCodeFromFile(File codeFile) {
            try (Scanner scanner = new Scanner(codeFile)) {
                StringBuilder code = new StringBuilder();
                while (scanner.hasNext()) {
                    code.append(scanner.next()).append(" ");
                }
                // Removing the last added space for cleaner code output if needed
                if (code.length() > 0) {
                    code.setLength(code.length() - 1);
                }
                this.code = code.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void execute(){
            //Esta funcao deve passar a string this.code como argumento para outro programa que a executa
            //E guarda o resultado numa variavel de tipo String
            // Usa java Runtime
            execute(new String[0]);
        }

        public void execute(String[] args) {
            try {
                String[] command;
                if (args.length == 0) {
                    // If no arguments, only pass the code to be executed
                    command = new String[] { "java", "ExternalRunner", code };
                } else {
                    // If there are arguments, pass the code and the arguments
                    command = new String[args.length + 3];
                    command[0] = "java";
                    command[1] = "ExternalRunner";
                    command[2] = code;
                    System.arraycopy(args, 0, command, 3, args.length);
                }
    
                Process process = Runtime.getRuntime().exec(command);
                process.waitFor();
    
                Scanner scanner = new Scanner(process.getInputStream()).useDelimiter("\\A");
                String result = scanner.hasNext() ? scanner.next() : "";
                System.out.println(result);
    
                scanner = new Scanner(process.getErrorStream()).useDelimiter("\\A");
                String error = scanner.hasNext() ? scanner.next() : "";
                if (!error.isEmpty()) {
                    System.err.println("Error: " + error);
                }

                scanner.close();
    
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Result result = new Result("User Name", 1); // Placeholder for user name and ID
        String filename = "result.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Name: " + result.getName() + "\n");
            writer.write("ID: " + result.getId() + "\n");

            // Question 1
            String[] question = { "A atribuição de valor em PIL usa o operador ", "." };
            String[] answer = { ":=" }; // Placeholder para respostas
            HoleQuestion q1 = new HoleQuestion(result, question, answer);
            Fraction f1 = q1.execute(scanner);
            result.updateGrade(f1);

            // Open Question
            OpenQuestion q2 = new OpenQuestion(result, "Defina a estrutura de dados lista ligada.");
            result.updateGrade(q2.execute(scanner));

            // CodeOpenQuestion
            String evenOddQuestion = "Implemente um programa que, pedindo um número inteiro do utilizador com o texto 'Number: ', escreva na consola se este é par (even) ou ímpar (odd).";
            String codeOpenFileName = "CodeOpenTestFile.txt";
            CodeOpenQuestion q3 = new CodeOpenQuestion(result, evenOddQuestion, codeOpenFileName);
            result.updateGrade(q3.execute(scanner));

            String[] question4 = { "-- PIL code from here\n" + //
                                "   n := integer(read \"Number: \"); -- type conversion: type(expression)\n" + //
                                "   write \"Number \",n, \" is \";\n" + //
                                "   if", "then -- = is the comparison operator (as in math)\n" +//
                                "      writeln \"even\"\n" +
                                "   ", "\n"+
                                "   writeln \"odd\"\n"+
                                "   end;\n" + //
                                "   -- PIL code to here" };
            String[] solution4 = {"n % 2 = 0", "else" };
            String[] grades4 = {"10", "5"};
            CodeHoleQuestion q4 = new CodeHoleQuestion(result, question4, solution4, grades4);
            result.updateGrade(q4.execute(scanner));
            result.exportToFile(writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

