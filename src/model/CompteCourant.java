package model;

public  class  CompteCourant extends  Compte {

    private double decouvert;

    public CompteCourant(String code, double soldeInitial, double decouvert) {
        super(code, soldeInitial);
        this.decouvert = decouvert;
    }

    @Override
    public void retirer(double montant) {
        if (solde + decouvert >= montant) {
            solde -= montant;
            listeOperations.add("Retrait de " + montant + " DH");
        } else {
            System.out.println(" Solde insuffisant ");
        }
    }

    @Override
    public double calculerInteret(double solde) {
        return 0;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Compte courant #" + code + ", Solde : " + solde + " DH, Découvert : " + decouvert + " DH");
    }
}
