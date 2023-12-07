import com.sun.security.jgss.GSSUtil;
import exceptions.TryCatch;
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
            "STREAMS", Streams::main,
            "EXCEPTIONS", TryCatch::main
    );

    private static final List<String> MAINS_KEYS = MAINS.keySet().stream().toList();
    // Un Set<> est une List<> sans doublons
    //private static final Set<String> MAINS_KEYS = MAINS.keySet();

    private static String[] mainArgs;
    public static void main(String[] args) {
        //System.out.println("args : " + Arrays.toString(args));
        mainArgs = args;
        displayMenu(args);
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

    private static void displayMenu(String[] args) {
        System.out.println("Saisissez le numéro du programme à lancer :");
        /*for (String key : MAINS_KEYS) {
            System.out.printf(" %d\t->\t%s%n", MAINS_KEYS.indexOf(key), key);
        }*/
        MAINS_KEYS.forEach(key -> System.out.printf(" %d\t->\t%s%n", MAINS_KEYS.indexOf(key), key));
        System.out.println("-1\t->\tQuitter");
        startMain(getInputInt(), args);
    }

    private static void startMain(int index, String[] args) {
        // faire un return dans un void permet de sortir de la methode
        if (index == -1) return;
        try {
            MAINS.get(MAINS_KEYS.get(index)).accept(args);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println("Veuillez saisir un nombre valide !");
        }
        displayMenu(args);
    }
}