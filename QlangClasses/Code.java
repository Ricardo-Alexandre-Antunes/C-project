package QlangClasses;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Code {
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