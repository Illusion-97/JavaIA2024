package objects;

import java.util.Random;

/*
* D'origine une interface définit un 'Contrat' (une structure) que doit respecter une classe
* On y écrit des 'signatures' de méthode qui doivent être présente dans la classe qui implémente l'interface
* */
public interface Chien {
    // une variable definie dans une interface se comporte comme une variable 'static'
    // En plus, elle est également 'final', on ne changera pas sa valeur, mais on pourra l'utiliser
    // On considère une variable 'static final' comme une constante (si possible : nom de variable en MAJ)
    Random RANDOM = new Random();


    void bark(); // Signature de méthode (dans une interface la visibilité des méthodes est 'public')

    // une methode avec le même nom et le même type de retour qu'une autre est dite 'surchargée' si elle possède des paramètres différents
    default void bark(String voice) {
        // default dans une interface permet de fournir un corps de méthode commun aux classes qui implémentent l'interface
        System.out.println(this + " : " + voice);
    }

    void fight(Chien adversaire);

    default Chien getVainqueur(Chien adversaire, String motif) {
        System.out.println(this + " se bat pour " + motif);
        Chien vainqueur = RANDOM.nextBoolean() ? this : adversaire;
        vainqueur.bark();
        return vainqueur;
    }
}
