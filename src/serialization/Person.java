package serialization;

import java.io.Serializable;

// Toute classe java est un POJO (Plain Old Java Object)
//JavaBean est un pojo avec une structure particulière
/*
* les attributs sont en visibilité private
* Le constructeur vide DOIT être présent si un autre l'est également, sinon le constructeur par défaut suffit
* Les accesseurs (Getter/Setter) doivent être présents pour les attributs
* Il est impératif d'implémenter l'interface Serializable
* */
public class Person implements Serializable {
    private String nom;
    private int tel;

    public Person(String nom, int tel) {
        this.nom = nom;
        this.tel = tel;
    }

    public Person() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return String.format("%s : %10d", nom, tel);
    }
}
