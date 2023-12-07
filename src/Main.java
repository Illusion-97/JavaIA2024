import com.sun.security.jgss.GSSUtil;
import flux.Streams;
import flux.lambda.Lambdas;
import objects.Jardin;
import operations.Boucles;
import operations.Conditions;
import operations.MathsOperations;
import types.Types;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    private static final Map<String, Consumer<String[]>> MAINS = Map.of(
            "TYPES", Types::main,
            "MATHS", MathsOperations::main,
            "CONDITIONS", Conditions::main,
            "BOUCLES", Boucles::main,
            "CLASSES", Jardin::main,
            "LAMBDAS", Lambdas::main,
            "STREAMS", Streams::main
    );

    private static final List<String> MAINS_KEYS = MAINS.keySet().stream().toList();
    // Un Set<> est une List<> sans doublons
    //private static final Set<String> MAINS_KEYS = MAINS.keySet();

    public static void main(String[] args) {

        // Objet pouvant récupérer une saisie dans la console
        //String line = scanner.nextLine();
        //int saisie = scanner.nextInt();
        /*boolean invalid = true;
        do {
            try {
                System.out.println("Saisissez un entier : ");
                Scanner scanner = new Scanner(System.in);
                int saisie = scanner.nextInt();
                invalid = false;
                System.out.println(saisie);
            } catch (Exception e) {
                System.out.println("Saisie invalide.");
            }
        } while (invalid);*/
      /*  System.out.println("Saisissez un entier : ");
        System.out.println(getInputInt());*/
        displayMenu();
    }

    private static int getInputInt() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Saisie invalide.");
            return getInputInt();
        }
    }

    private static void displayMenu() {
        System.out.println("Saisissez le numéro du programme à lancer :");
        for (String key : MAINS_KEYS) {
            System.out.printf("%d\t->\t%s%n", MAINS_KEYS.indexOf(key), key);
        }
    }
}