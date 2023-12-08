import java.util.List;
import java.util.Scanner;

public class CheatSheet {
    private static String jvm = "JVM"; // Static variable shared by all object of the class
    public String title; // Object variable declaration : {visibility} {Type / Class} {name}
    protected int a = 1, b = 2; // Multiple declaration with initialisation;

    public CheatSheet(String title) { // Constructor
        this.title = title; // Object variable's initialisation
    }

    private static void printJVM() {  // Static method shared by all object of the class
        System.out.print( // Console's output
                jvm // Parameter given to the method
        );
    }

    public int calcul( //Object method declaration : {visibility} {return Type / Class} {name}
            int firstArg, // Method Parameter
            int secondArg,
            int thirdArg
    ) { // Method body
        int result = firstArg + secondArg - thirdArg; // Local variable
        return result; // Method's Exit point
    }

    public static void main(String[] args) {
        System.out.println();
        CheatSheet cheatSheet = new CheatSheet("Cheat Sheet"); // Object creation;
        int version = cheatSheet.calcul(cheatSheet.a, 2, cheatSheet.b); // Object method call
        System.out.printf("Title : %s Version %d \n",cheatSheet.title,version); // String.format : %s for String values, %d for numbers, \n line break
        System.out.println();
        System.out.println(".java / .class / JAR / " + jvm + " / JRE / JDK"); // String concatenation
        System.out.println("Command 'javac' compile code in a .java file in Bytecode in a .class file");
        System.out.println("Multiple compiled files can be packaged in a archive type : JAR (or WAR)");
        System.out.print("The ");
        printJVM(); // Method call
        System.out.println("""
                 read and execute the Bytecode from the .class files
                As the code is not written for specific environment but for the JVM, Java applications are said 'WORA'
                It means 'Write Once Run Anywhere' as any machine with a JRE installed can run them"""); // Preserve the structure

        String[] jre = {jvm, "java DDL containing java core's classes"}; // Array
        System.out.println("The JRE contains : ");
        for (String string : jre) { // Loop 'foreach'
            System.out.println("-> " + string);
        }
        System.out.println("The JDK contains the JRE and the Java Development Tools (JDT) including compiler (javac), JavaDebugger, JavaDoc , etc.");
        System.out.println("Do you want to see the java version benefiting of the Long-Term Support (LTS) ? Y/N");
        String userInput =
        new Scanner(System.in) // Console Input
                .next(); // Capture the fist char validated (Enter) by the user
        if (userInput != null && userInput.equalsIgnoreCase("Y")) { // Condition
            List<String> lts = List.of( // List
                    "-> 7 (Ended on July 2022)",
                    "-> 8 (Until December 2030)",
                    "-> 11 (Until September 2026)",
                    "-> 17 (Until September 2029 or later)",
                    "-> 21 (Release September 2023 / Supported Until December 2030)"
            );
            lts.forEach(System.out::println);
        }
    }
}
