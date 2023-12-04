package operations;

import java.util.Random;

public class MathsOperations {
    public static void main(String[] args) {
        // region Conversion implicite
        int anInt = 10;
        double aDouble = 9.36;
        float aFloat = 5.81f; // Précision apportée puisque par défaut les nombres à virgule sont considérées 'double'

        double aDoubleFromInt = anInt;
        float aFloatFromInt = anInt;

        // double étant plus 'lourd' que int, la conversion automatique n'est pas possible
        int anIntFromDouble = (int) aDouble; // Caster signifie forcer une conversion de type
        float aFloatFromDouble = (float) aDouble;
        int anIntFromFloat = (int) aFloat;

        int anIntResult = anInt + anInt;
        double aDoubleResult = anInt + aDouble;
        int anIntResultFromDoubleCasted = anInt + ((int) aDouble); // Cast la valeur la plus lourde
        int anIntResultCasted = (int) (anInt + aDouble); // Cast le résultat
        System.out.println("anIntResultFromDoubleCasted = " + anIntResultFromDoubleCasted);
        System.out.println("anIntResultCasted = " + anIntResultCasted);
        //endregion

        // region STRING
        String aString = "String Content";
        System.out.println(aString + " String added");
        System.out.println(aString + " And an Int : " + anInt);
        aString += " And a Double : ";
        aString += aDouble;
        System.out.println(aString);
        aString = aString.substring(0,14);
        System.out.println(aString);
        //String.format permet de mettre en forme un affichage
        /*
        * %s -> emplacement dans le format pour un String
        * %d -> emplacement pour un nombre (entier)
        * %f -> est personnalisable avec le nombre de digits avant et apres la virgule
        * %n -> est un saut de ligne
        * */
        System.out.println(String.format("%s And a Float : %10.3f !", aString, aFloat));
        // en comparaison avec println, printf (print format) ne saute pas automatiquement la ligne
        System.out.printf("%s And a Float : %10.3f !%n", aString, aFloat);
        // endregion

        // region Random
        // Je déclare une variable de type Random que je nomme random
        Random random; // Est une déclaration
        // La première affectation à une déclaration est appelée initialisation
        random = new Random();
        // Il est possible de faire les deux étapes précédantes en une seule
        // Random random = new Random(); (Attention on ne déclare jamais 2 fois le même nom de variable)

        boolean randomBoolean = random.nextBoolean();
        int randomInt = random.nextInt();
        long randomLong = random.nextLong();
        int randomIntWithBound = random.nextInt(10); // From 0 to 9
        int randomIntFromTo = random.nextInt(5,16); // From 5 to 15
        double[] aRandomDoubleArray = random.doubles(5).toArray(); // tableau de 5 double aléatoires
        int[] randomIntArray = random.ints(5, 1, 101).toArray();

        // endregion
    }
}
