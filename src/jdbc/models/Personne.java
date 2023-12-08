package jdbc.models;

import java.io.Serializable;

public class Personne implements Serializable {
    private String nom;
    private String prenom;
    private Role role;

    public Personne() {
    }

    public Personne(String nom, String prenom, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
