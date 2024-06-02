package QlangClasses;

import java.util.Scanner;

public class OpenQuestion extends Question {
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
        clone = new OpenQuestion(super.getResult(), this.question, this.getID());
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
    public String getID() {
        return super.getID();
    }

    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public String getAnswer() {
        return this.answer;
    }

    @Override
    public QuestionInterface getInstance() {
        return new OpenQuestion(super.getResult(), this.question, this.getID());
    }
}