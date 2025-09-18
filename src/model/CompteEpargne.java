package model;

import java.util.ArrayList;

public class CompteEpargne extends Compte{

    private double tauxInteret ;

    public CompteEpargne (String code, double soldeInitial , double tauxInteret) {
        super(code, soldeInitial);
        this.tauxInteret=tauxInteret;
    }

    @Override
    public  void retirer(double montant){
        if (solde >= montant){
            solde -= montant ;
        }
        else {
            System.out.println(" Solde insuffisant ");
        }
    };

    @Override
    public  double calculerInteret(double solde){
        return solde * tauxInteret ;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Compte epagne #" + code + ", Solde : " + solde + " DH, Taux Interet  : " + tauxInteret + " DH");
    }
}
