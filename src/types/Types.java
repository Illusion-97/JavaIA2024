package types;

import java.util.ArrayList;
import java.util.List;

public class Types {

    // Déclaration de variable dans une classe : Attribut
    boolean bool;

    public static void main(String[] args) {
        //region PRIMITIF
        // Les types primitifs représentent des valeurs stockées en mémoire dont taille affectée dépends de ce type
        boolean aBoolean = false;       // 1 bit;
        byte aByte = 0;                 // 8 bits
        short aShort = 0;               // 16 bits
        char aChar = '\u0000';          // 16 bits
        int anInt = 0;                  // 32 bits
        // Par défaut les nombres à virgules sont considérées comme double
        // Pour apporter une précision de type, on ajoutera un f à la fin de la valeur pour float
        float aFloat = 0.0f;            // 32 bits
        long aLong = 0;                 // 64 bits
        double aDouble = 0.0;           // 64 bits
        //endregion

        //region REFERENCES
        // Par opposition les types référence n'ont pas de taille prédéfinie
        // Pour représenter leur valeur par défaut, on utilise null
        // En java, TOUS les types reference sont des Object
        Object anObject = null;
        // Le type String est dit IMMUTABLE
        String aString = "String Content"; // " String | ' char
        System.out.println("Before Replace : " + aString);
        System.out.println("Replace : " + aString.replace(" ", ""));
        System.out.println("After Replace : " + aString);
        // Pour conserver les changements sur type immutable, il faut réaffecter la nouvelle valeur via =
        aString = aString.replace(" ", "");
        System.out.println("After Reassignment : " + aString);
        //endregion

        //region WRAPPER
        Integer anIntWrapper = Integer.valueOf(0); // Boxing (contenir une valeur primitive dans un Object)
        int anIntUnboxed = anIntWrapper.intValue(); // Unboxig
        anIntWrapper = 10; // Boxing est automatique et passe par valueOf
        anIntUnboxed = anIntWrapper; // Unboxing automatique via intValue
        String numericString = "500";
        int anIntFromString = Integer.parseInt(numericString); // Utile pour valider du texte ou des saisies utilisateur
        System.out.println("anIntFromString = " + anIntFromString);
        //endregion

        //region COLLECTIONS
        // Création de tableau avec des valeurs spécifiées (la taille du tableau dépends des valeurs données)
        int[] anIntArray = {150,17,29,93,46};
        // On accede a une valeur du tableau en précisant son index entre [] : variable[index]
        System.out.println(anIntArray[0]); // 150 : Les index commencent à 0
        // Que les [] soient mis au niveau type ou du nom de variable, l'effet est le même
        // Pour créer un tableau dont je ne connais pas encore les valeurs, on précise la taille du tableau
        String aStringArray[] = new String[10]; // type name[] = new type[length]
        System.out.println(aStringArray[5]); // null
        aStringArray[5] = "String Content"; // Remplace le null a l'index 5 par "String Content"
        System.out.println(aStringArray[5]); // String Content
        // System.out.println(aStringArray[15]); génère une 'erreur' : ArrayIndexOutOfBoundsException

        boolean[][] aBooleanTable = {
                {true, false},
                {false, true, true},
                {}
        };
        System.out.println(aBooleanTable[1][2]); //true
        // Assure ici que chaque ligne possède le même nombre de colones
        aBooleanTable = new boolean[3][5];
        /*
         * {false, false, false, false, false}
         * {false, false, false, false, false}
         * {false, false, false, false, false}
        * */
        System.out.println(aBooleanTable[1][2]); // false
        // À l'utilisation (lecture / écriture) on passe par les index | à l'initialisation on utilise la taille


        List<String> aStringList = new ArrayList<>();
        // System.out.println(aStringList.get(0)); IndexOutOfBoundsException
        // Ajoute à la fin de la liste
        aStringList.add("first");
        System.out.println(aStringList.get(0)); // first
        String second = "second";
        aStringList.add(second);
        String third = "third";
        // Ajoute à une position précise et décale les autres éléments
        aStringList.add(0, third);
        aStringList.add(1, "fourth");
        System.out.println(aStringList.get(0)); // third
        System.out.println(aStringList.get(1)); // fourth
        System.out.println(aStringList.indexOf(second)); // 3
        // Si l'élément recherché n'est pas présent dans la liste, il retourne -1
        System.out.println(aStringList.indexOf("fifth")); // -1
        aStringList.remove(0);
        System.out.println(aStringList.get(0)); // fourth


        //endregion
    }
}
