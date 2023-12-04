package types;

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
    }
}
