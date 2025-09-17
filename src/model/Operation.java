package model;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation {
    protected UUID numero;
    protected LocalDateTime date;
    protected double montant;

    public Operation(double montant) {
        this.numero = UUID.randomUUID();
        this.date = LocalDateTime.now();
        this.montant = montant;
    }
    public abstract void afficherDetails();
}






