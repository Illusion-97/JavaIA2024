package objects;

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
        System.out.println(switch (getAgeRange()) {
            case JEUNE -> "HawHaw";
            case ADULTE -> "WafWaf";
            case SENIOR -> "Wouf";
        });
    }
}
