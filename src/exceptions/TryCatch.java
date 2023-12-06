package exceptions;

public class TryCatch {
    public static void main(String[] args) {
        String nullString = null;
        try {
            nullString.replace(";", " ");
        } catch (NullPointerException nullPointerException) {
            nullString = "Quelque chose";
            nullString = nullString.replace(" ", "");
            System.out.println("Problème réglé : ");
            System.out.println("nullString = " + nullString);
        }
        System.out.println();
        try {
            int[] anIntArray = new int[2];
            System.out.println("anIntArray[5] = " + anIntArray[5]);
        } catch (Exception exception) {
            System.out.println("exception.getClass().getSimpleName() = " + exception.getClass().getSimpleName());
            System.out.println("exception.getMessage() = " + exception.getMessage());
            // Conserver l'affichage du problème dans la console, sans planter le programme
            exception.printStackTrace(System.out);
        }
        System.out.println();

        /*
        * 3 types de problèmes pouvant intervenir durant l'exécution du programme, ceux-cis sont des 'Throwable'
        * Error : Ne dépends pas du code, mais de l'environnement d'exécution
        * Exception : Le cas le plus classique pour indiquer un défaut de programmation
        * RuntimeException : Représente des problèmes liés aux données utilisées durant l'exécution du programme (on ne force pas la gestion de RuntimeException)
        * */

        try {
            throwError();
            throwRuntimeException();
            throwException();
            throwCustomException();
            throwCustomRuntimeException();
        } catch (Exception exception) {
            System.out.println("exception.getClass().getSimpleName() = " + exception.getClass().getSimpleName());
            System.out.println("exception.getMessage() = " + exception.getMessage());
        } finally { // Toujours exécuté
            System.out.println("Toujours présent !");
        }

    }

    private static void throwException() throws Exception {
        throw new Exception("Generic Exception");
    }

    private static void throwCustomException() throws CustomException {
        throw new CustomException();
    }

    private static void throwRuntimeException() {
        throw new RuntimeException("Generic RuntimeException");
    }
    private static void throwCustomRuntimeException() {
        throw new CustomRuntimeException("Custom RuntimeException");
    }

    private static void throwError() {
        throw new Error("Generic Error");
    }
}
