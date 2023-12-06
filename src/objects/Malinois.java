package objects;

import java.util.Random;

public class Malinois extends Animal implements Chien {
    public Malinois() {
    }

    public Malinois(String name) {
        super(name);
    }

    public Malinois(String name, int age, Animal parent, Animal otherParent) {
        super(name, age, parent, otherParent);
    }

    @Override
    public void bark() {
        // sout selon son AgeRange : Jeune -> HawHaw / Adulte : WafWaf / Senior : Wouf
        // optimisation : écrire le minimum possible de System.out.println();
        bark(switch (getAgeRange()) {
            case JEUNE -> "HawHaw";
            case ADULTE -> "WafWaf";
            case SENIOR -> "Wouf";
        });
    }

    @Override
    public void fight(Chien adversaire) {
        System.out.println(this +
                (getVainqueur(adversaire, "l'honneur de son maître") == this
                        ? " saute sur son maître !"
                        : " part se cacher !"));

    }
}
