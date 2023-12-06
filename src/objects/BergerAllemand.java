package objects;


import java.util.Random;

public class BergerAllemand extends Animal implements Chien {
    private int pride = 10;

    public BergerAllemand() { // S'il n'est pas précisé, super() est implicite

    }

    public BergerAllemand(String name) {
        super(name); // Animal(String name)
    }

    public BergerAllemand(String name, int age, Animal parent, Animal otherParent) {
        super(name, age, parent, otherParent);
    }

    public void displayPride() {
        System.out.println(name + " démontre sa fierté !");
        bark();
    }

    @Override // Réécrire un comportement existant
    public void bark() {
        bark("WOUF! ".repeat(pride));
    }

    @Override
    public void fight(Chien adversaire) {
        if (getVainqueur(adversaire, "sa fierté") == this) {
            pride++;
            displayPride();
        }
    }
}
