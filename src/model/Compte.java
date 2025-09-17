package model;
import java.util.ArrayList;
import java.util.List;

abstract class Compte {

    protected int code;
    protected double solde;
    protected List<String> listeOperations;

    public Compte(int code, double soldeInitial) {
        this.code = code;
        this.solde = soldeInitial;
        this.listeOperations = new ArrayList<>();
        listeOperations.add("Création du compte avec solde initial : " + soldeInitial + " DH");
    }
    public abstract void retirer(double montant);
    public abstract double calculerInteret(double solde);
    public abstract void afficherDetails();
}

