package model;
import java.util.ArrayList;
import java.util.List;

 public abstract class Compte {

    protected String code;
    protected double solde;
    protected List<String> listeOperations;

    public Compte(String code, double soldeInitial) {
        this.code = code;
        this.solde = soldeInitial;
        this.listeOperations = new ArrayList<>();
        listeOperations.add("Création du compte avec solde initial : " + soldeInitial + " DH");
    }
    public abstract void retirer(double montant);
    public abstract double calculerInteret(double solde);
    public abstract void afficherDetails();

     public double getSolde() {
         return solde;
     }

     public void setSolde(double solde) {
         this.solde = solde;
     }

     public List<String> getListeOperations() {
         return listeOperations;
     }

     public String getCode() {
         return code;
     }
}

