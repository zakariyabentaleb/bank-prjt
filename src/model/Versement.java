package model;

public class Versement extends Operation {
      private String source ;

    public Versement(double montant, String source) {
        super(montant);
        this.source = source;
    }
    @Override
    public void afficherDetails() {
        System.out.println("Versement #" + numero.toString());
        System.out.println("Date : " + date.toString());
        System.out.println("Montant : " + montant + "DH");
        System.out.println("Source : " + source);
    }
}
