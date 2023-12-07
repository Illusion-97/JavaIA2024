package objects;

import java.util.Random;
// une classe notée 'final' ne peut pas être héritée
public final class Malinois extends Animal implements Chien, MauvaisPerdant {
    public Malinois() {
    }

    public Malinois(String name) {
        super(name);
    }

    public Malinois(String name, int age, Animal parent, Animal otherParent) {
        super(name, age, parent, otherParent);
    }

    @Override
    public Malinois getChild(Animal otherParent) {
        return new Malinois("", 0, this, otherParent);
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
                        : perdre()));

    }
}

/* impossible puisque Malinois est final
class Malouf extends Malinois {

}*/
