import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import QlangClasses.*;

public class Ex1Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        QuestionInterface q1, q2, q3, q4;
        Result result = new Result();
        Fraction grade;
        String evenOddQuestion, codeSolution;

        // define user
        System.out.print("Enter your name: ");
        result.setName(scanner.nextLine().trim());
        System.out.print("Enter your ID: ");
        result.setID(scanner.nextInt());

        System.out.println("\nNome: " + result.getName() + ", id: "+ Integer.toString(result.getId()) + "\n");
        scanner.nextLine();

        // q1 -> HoleQuestion
        String[] question = new String[] { "A atribuição de valor em PIL usa o operador ", "." };
        String[] solution = new String[] { ":=" };
        q1 = new HoleQuestion(result, question, solution, "A.B.C");
        grade = q1.execute(scanner);

        // q2 -> OpenQuestion
        q2 = new OpenQuestion(result, "Defina a estrutura de dados lista ligada.", "A.E");
        q2.execute(scanner);

        // q3 -> codeOpenQuestion
        evenOddQuestion = "Implemente um programa que, pedindo um número inteiro do utilizador com o texto 'Number: ', escreva na consola se este é par (even) ou ímpar (odd).";
        codeSolution =  "if n % 2 = 0 then\n" +
                        "    writeln \"even\"\n" + 
                        "else\n" + 
                        "    writeln \"odd\"\n" + 
                        "end;";
        Code code = new Code(codeSolution);
        q3 = new CodeOpenQuestion(result, evenOddQuestion, code, "Question.Code1");
        q3.execute(scanner);

        // q4 -> CodeHoleQuestion
        String question4 = "Complete o seguinte código.";
        Code code4 = new Code("   n := integer(read \"Number: \");\n" +
                            "   write \"Number \",n, \" is \";\n" +
                            "   if n % 2 = 0 then" + "\n" +
                            "      writeln \"even\"\n" +
                            "   else\n" +
                            "   writeln \"odd\"\n" +
                            "   end;\n"
                            );
        String[] solution4 = new String[] { "n % 2 = 0", "else" };
        String[] grades4 = new String[] { "10", "5" };
        q4 = new CodeHoleQuestion(result, question4, code4, solution4, grades4, "Question.Code2");
        q4.execute(scanner);

        // export to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))) {
            result.exportToFile(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }                 
    }
}