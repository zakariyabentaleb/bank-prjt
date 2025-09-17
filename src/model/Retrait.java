package model;

public class Retrait extends Operation {
    private String destination ;

    public Retrait(double montant, String destination) {
        super(montant);
        this.destination = destination;
    }
    @Override
    public void afficherDetails() {
        System.out.println("Versement #" + numero.toString());
        System.out.println("Date : " + date.toString());
        System.out.println("Montant : " + montant + " DH");
        System.out.println("Destination : " + destination);
    }

}