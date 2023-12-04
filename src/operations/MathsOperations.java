package operations;

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


    }
}
