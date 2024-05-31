import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

class Pota {
    static class Result {
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
                    w.write("Grade: " + this.grades.get(question - 1) + "\n");
                    w.write("--------------------\n");
                }
                w.write("Final Grade: " + ((this.grade == null) ? "Undefined" : this.grade) + "\n");
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
            int newNumerator = fraction1.numerator * fraction2.denominator
                    + fraction2.numerator * fraction1.denominator;
            int newDenominator = fraction1.denominator * fraction2.denominator;
            return new Fraction(newNumerator, newDenominator);
        }

        public static Fraction subtractFractions(Fraction fraction1, Fraction fraction2) {
            int newNumerator = fraction1.numerator * fraction2.denominator
                    - fraction2.numerator * fraction1.denominator;
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

        public void addQuestion(QuestionInterface q1, String rah, int count);

        public String getQuestionId();
    }

    abstract static class Question implements QuestionInterface {
        private Result result;
        private String id;

        public Question(Result result, String id) {
            this.result = result;
            this.id = id;
        }

        public Result getResult() {
            return this.result;
        }

        abstract String getQuestion();

        abstract String getAnswer();

        public String getQuestionId() {
            return "";
        }

        @Override
        public void addQuestion(QuestionInterface q1, String rah, int count) {
            // TODO Auto-generated method stub
            System.err.println("Method not implemented");
        }
    }

    static class HoleQuestion extends Question {
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
            clone = new HoleQuestion(super.getResult(), this.question, this.solution, super.getQuestionId());
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
        public String getQuestionId() {
            return super.id;
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

        public Fraction getScore() {
            return score;
        }

        public HoleQuestion getClone() {
            return clone;
        }
    }

    static class OpenQuestion extends Question {
        String question;
        String answer;
        OpenQuestion clone;

        public OpenQuestion(Result result, String question, String id) {
            super(result, id);
            this.question = question;
            this.answer = "";
            this.clone = null;
        }

        @Override
        public Fraction execute(Scanner scanner) {
            clone = new OpenQuestion(super.getResult(), this.question, super.getQuestionId());
            return clone.run(scanner);
        }

        public Fraction run(Scanner scanner) {
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
            this.getResult().updateGrade(null, this.getQuestion(), "Undefined", this.getAnswer());
            return null;
        }

        @Override
        public String getQuestionId() {
            return super.id;
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
        private String solutionFile;
        private String inputFilePath;
        private Fraction score;
        private CodeOpenQuestion clone;

        public CodeOpenQuestion(Result result, String question, String solutionFile, String id) {
            super(result, id);
            this.question = question;
            this.solutionFile = solutionFile;
            this.answer = new Code("");
            this.inputFilePath = "CodeOpenQuestionInputFile.txt";
            this.score = new Fraction(0, 1); // Initialize with a valid fraction
            this.clone = null;
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
            clone = new CodeOpenQuestion(super.getResult(), this.question, this.solutionFile, super.getQuestionId());
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
            } catch (IOException e) {
                System.out.println("Error deleting the input file: " + e.getMessage());
            }
            return this.score;
        }

        private void rightAnswer() {
            this.score.setNumerator(1);
            this.getResult().updateGrade(this.score, this.getQuestion(), "Undefined", this.getAnswer());
        }

        private void wrongAnswer() {
            this.score.setNumerator(0);
            this.getResult().updateGrade(this.score, this.getQuestion(), "Undefined", this.getAnswer());
        }

        @Override
        public String getQuestionId() {
            return super.id;
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
        int denominator;
        int numerator;
        Fraction score;
        CodeHoleQuestion clone;

        public CodeHoleQuestion(Result result, String[] question, String[] solution, String[] grades, String id) {
            super(result, id);
            this.question = question;
            this.solution = solution;
            this.answer = new String[solution.length];
            this.grades = grades;
            this.numerator = 0;
            this.denominator = 0;
            this.clone = null;
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
            clone = new CodeHoleQuestion(super.getResult(), this.question, this.solution, this.grades,
                    super.getQuestionId());
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

            for (int i = 0; i < solution.length; i++) {
                if (solution[i].equals(answer[i])) {
                    numerator += Integer.parseInt(grades[i]);
                }
            }

            return finishedAnswer();
        }

        @Override
        public String getQuestionId() {
            return super.id;
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

        public Code(String code_inline) {
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

        public void execute() {
            // Esta funcao deve passar a string this.code como argumento para outro programa
            // que a executa
            // E guarda o resultado numa variavel de tipo String
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
                scanner.close();

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

    static class QuestionManager implements QuestionInterface {
        private ArrayList<QuestionInterface> hierarchicalQuestions;
        private String category;

        public QuestionManager(String category) {
            this.hierarchicalQuestions = new ArrayList<>();
            this.category = category;
        }

        public void addQuestion(QuestionInterface question, String cat, int count) {
            String[] category = cat.split("\\.");
            if (category.length == count + 1) {
                for (QuestionInterface q : this.hierarchicalQuestions) {
                    if (cat.equals(q.getQuestionId())) {
                        System.out.println("A question with (" + cat + ") is already defined!");
                    }
                }
                this.hierarchicalQuestions.add(question);
                return;
            } else {
                String newCat = "";
                for (int i = 0; i <= count; i++) {
                    newCat += category[i];
                    if (i != count) {
                        newCat += ".";
                    }
                }
                boolean found = false;
                for (QuestionInterface q : this.hierarchicalQuestions) {
                    System.out.println("a");
                    if (newCat.equals(q.getQuestionId())) {
                        count++;
                        q.addQuestion(question, cat, count);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    QuestionManager subManager = new QuestionManager(newCat);
                    this.hierarchicalQuestions.add(subManager);
                    count++;
                    subManager.addQuestion(question, cat, count);
                }
            }
        }

        @Override
        public String getQuestionId() {
            return this.category;
        }

        public Fraction execute(Scanner scanner) {
            Random random = new Random();
            int randomIndex = random.nextInt(hierarchicalQuestions.size());
            System.out.println("INDEXXXXXXXXXXXXXXXXX" + randomIndex);
            QuestionInterface randomQuestion = hierarchicalQuestions.get(randomIndex);
            System.out.println("ID" + randomIndex);
            return randomQuestion.execute(scanner);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Result result = new Result(); // Placeholder for user name and ID
        String filename = "result.txt", evenOddQuestion, codeOpenFileName;
        String name;
        int id;
        Fraction f1;
        QuestionManager QM = new QuestionManager("root");

        // Define user
        System.out.println("Nome: ");
        name = scanner.nextLine();
        result.setName(name);
        System.out.println("ID: ");
        id = scanner.nextInt();
        result.setID(id);
        scanner.nextLine(); // Consume the newline character

        // Question 1
        String[] question = new String[] { "A atribuição de valor em PIL usa o operador ", "." };
        String[] answer = new String[] { ":=" }; // Placeholder para respostas
        QuestionInterface q1 = new HoleQuestion(result, question, answer, "Question.Banana.q1");
        QM.addQuestion(q1, "Question.Banana.q1", 0);

        f1 = q1.execute(scanner);

        // Open Question
        QuestionInterface OpenQuestion = new OpenQuestion(result, "Defina a estrutura de dados lista ligada.",
                "OpenQuestion");
        QM.addQuestion(OpenQuestion, "OpenQuestion", 0);
        OpenQuestion.execute(scanner);

        // CodeOpenQuestion
        evenOddQuestion = "Implemente um programa que, pedindo um número inteiro do utilizador com o texto 'Number: ', escreva na consola se este é par (even) ou ímpar (odd).";
        codeOpenFileName = "CodeOpenTestFile.txt";
        QuestionInterface Code1 = new CodeOpenQuestion(result, evenOddQuestion, codeOpenFileName, "Question.Code1");
        QM.addQuestion(Code1, "Question.Code1", 0);
        Code1.execute(scanner);

        // CodeHoleQuestion
        String[] question4 = new String[] {
                "-- PIL code from here\n" +
                        "   n := integer(read \"Number: \"); -- type conversion: type(expression)\n" +
                        "   write \"Number \",n, \" is \";\n" +
                        "   if",
                "then -- = is the comparison operator (as in math)\n" +
                        "      writeln \"even\"\n" +
                        "   ",
                "\n" +
                        "   writeln \"odd\"\n" +
                        "   end;\n" +
                        "   -- PIL code to here"
        };
        String[] solution4 = new String[] { "n % 2 = 0", "else" };
        String[] grades4 = new String[] { "10", "5" };
        QuestionInterface q4 = new CodeHoleQuestion(result, question4, solution4, grades4, "Question.Hole");
        QM.addQuestion(q4, "A.P", 0);
        q4.execute(scanner);

        // Export results to file
        QM.execute(scanner);
        QM.execute(scanner);
        QM.execute(scanner);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            result.exportToFile(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
