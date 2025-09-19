package controllers;

import java.util.ArrayList;
import java.util.Scanner;
import model.Compte;
import model.CompteEpargne;
import model.CompteCourant;

public class CompteController {

    public static void run() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Compte> comptes = new ArrayList<>();
        int choixMenu;

        do {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1. Créer un nouveau compte");
            System.out.println("2. Gérer un compte existant");
            System.out.println("3. Lister tous les comptes");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choixMenu = sc.nextInt();

            switch (choixMenu) {
                case 1:
                    // Création d’un nouveau compte
                    System.out.println("=== Création d'un compte ===");
                    System.out.print("Code du compte (ex: CPT-0001) : ");
                    String code = sc.next();

                    System.out.print("Solde initial : ");
                    double soldeInitial = sc.nextDouble();

                    System.out.println("Type de compte : 1) Epargne  2) Courant");
                    int type = sc.nextInt();

                    Compte compte = null;
                    if (type == 1) {
                        System.out.print("Taux d’intérêt (ex: 0.05 pour 5%) : ");
                        double taux = sc.nextDouble();
                        compte = new CompteEpargne(code, soldeInitial, taux);
                    } else if (type == 2) {
                        System.out.print("Découvert autorisé : ");
                        double decouvert = sc.nextDouble();
                        compte = new CompteCourant(code, soldeInitial, decouvert);
                    } else {
                        System.out.println("Type invalide !");
                        break;
                    }

                    comptes.add(compte);
                    System.out.println("Compte créé avec succès !");
                    break;

                case 2:
                    if (comptes.isEmpty()) {
                        System.out.println("Aucun compte existant !");
                        break;
                    }

                    // Sélection du compte
                    System.out.println("=== Liste des comptes ===");
                    for (int i = 0; i < comptes.size(); i++) {
                        System.out.println((i + 1) + ". " + comptes.get(i).getCode());
                    }
                    System.out.print("Sélectionnez un compte : ");
                    int index = sc.nextInt() - 1;
                    if (index < 0 || index >= comptes.size()) {
                        System.out.println("Compte invalide !");
                        break;
                    }

                    Compte compteSelectionne = comptes.get(index);
                    gererCompte(compteSelectionne, sc,comptes);
                    break;
                case 3:
                    // Nouvelle option : lister tous les comptes
                    if (comptes.isEmpty()) {
                        System.out.println("Aucun compte à afficher !");
                    } else {
                        System.out.println("=== Tous les comptes ===");
                        for (Compte c : comptes) {
                            System.out.println("- Code : " + c.getCode() + ", Solde : " + c.getSolde() +
                                    (c instanceof CompteEpargne ? ", Type : Epargne" : ", Type : Courant"));
                        }
                    }
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }

        } while (choixMenu != 0);

        sc.close();
    }

    // Méthode pour gérer un compte existant
    private static void gererCompte(Compte compte, Scanner sc, ArrayList<Compte> comptes) {
        int choix;
        do {
            System.out.println("\n===== Menu du compte " + compte.getCode() + " =====");
            System.out.println("1. Afficher les détails du compte");
            System.out.println("2. Faire un versement");
            System.out.println("3. Faire un retrait");
            System.out.println("4. Calculer les intérêts (si épargne)");
            System.out.println("5. Voir l’historique des opérations");
            System.out.println("6. Faire une Operation avec un autre Compte");
            System.out.println("0. Retour au menu principal");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    compte.afficherDetails();
                    break;
                case 2:
                    System.out.print("Montant à verser : ");
                    double montantVersement = sc.nextDouble();
                    compte.setSolde(compte.getSolde() + montantVersement);
                    compte.getListeOperations().add("Versement de " + montantVersement + " DH");
                    System.out.println("Versement effectué !");
                    break;
                case 3:
                    System.out.print("Montant à retirer : ");
                    double montantRetrait = sc.nextDouble();
                    compte.retirer(montantRetrait);
                    compte.getListeOperations().add("Retrait de " + montantRetrait + " DH");
                    break;
                case 4:
                    if (compte instanceof CompteEpargne) {
                        double interet = ((CompteEpargne) compte).calculerInteret(compte.getSolde());
                        System.out.println("Intérêt calculé : " + interet + " DH");
                    } else {
                        System.out.println("Ce compte ne génère pas d’intérêts !");
                    }
                    break;
                case 5:
                    System.out.println("=== Historique des opérations ===");
                    for (String op : compte.getListeOperations()) {
                        System.out.println("- " + op);
                    }
                    break;
                case 6:
                    System.out.println("=== Opérations ===");
                    System.out.println("1. Versement");
                    System.out.println("2. Retrait");
                    System.out.print("Votre choix : ");
                    int choixOp = sc.nextInt();

                    // Choisir le compte par son code
                    System.out.print("Entrer le code du compte : ");
                    String codeCompte = sc.next();

                    // Chercher le compte
                    Compte compteSelectionne = null;
                    for (Compte c : comptes) {
                        if (c.getCode().equals(codeCompte)) {
                            compteSelectionne = c;
                            break;
                        }
                    }

                    if (compteSelectionne == null) {
                        System.out.println("Compte introuvable !");
                        break;
                    }

                    // Saisir le montant
                    System.out.print("Montant : ");
                    double montant = sc.nextDouble();

                    if (choixOp == 1) {
                        // Versement
                        compteSelectionne.setSolde(compteSelectionne.getSolde() + montant);
                        System.out.println("Versement de " + montant + " effectué. Nouveau solde = " + compteSelectionne.getSolde());
                    } else if (choixOp == 2) {
                        // Retrait
                        if (montant > compteSelectionne.getSolde()) {
                            System.out.println("Solde insuffisant !");
                        } else {
                            compteSelectionne.setSolde(compteSelectionne.getSolde() - montant);
                            System.out.println("Retrait de " + montant + " effectué. Nouveau solde = " + compteSelectionne.getSolde());
                        }
                    } else {
                        System.out.println("Choix invalide !");
                    }
                    break;


                case 0:
                    System.out.println("Retour au menu principal");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }
}
