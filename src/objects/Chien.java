package objects;

/*
* D'origine une interface définit un 'Contrat' (une structure) que doit respecter une classe
* On y écrit des 'signatures' de méthode qui doivent être présente dans la classe qui implémente l'interface
* */
public interface Chien {
    void bark(); // Signature de méthode (dans une interface la visibilité des méthodes est 'public')

    // une methode avec le même nom et le même type de retour qu'une autre est dite 'surchargée' si elle possède des paramètres différents
    default void bark(String voice) {
        // default dans une interface permet de fournir un corps de méthode commun aux classes qui implémentent l'interface
        System.out.println(this + " : " + voice);
    }
}
