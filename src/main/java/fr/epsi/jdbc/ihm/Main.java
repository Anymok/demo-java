package fr.epsi.jdbc.ihm;

import fr.epsi.jdbc.dal.DAOFactory;
import fr.epsi.jdbc.dal.FournisseurDAO;
import fr.epsi.jdbc.dal.UtilisateurDAO;
import fr.epsi.jdbc.entites.Fournisseur;
import fr.epsi.jdbc.entites.Utilisateur;
import fr.epsi.jdbc.error.StoreModeNotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        fournisseurTest();
        authentificationSecuriser();


      /*  try {
            FournisseurDAO dao = DAOFactory.getFournisseurDAO();
            dao.insert(new Fournisseur("test"));
            dao.update("test", "kayak");
            dao.delete(new Fournisseur("kayak"));
            List<Fournisseur> fournisseurs = null;
            fournisseurs = dao.extraire();
            for (Fournisseur item : fournisseurs) {
                System.out.println(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (StoreModeNotFoundException e) {
            System.out.println(e.getMessage());
        }*/



    }

    public static void fournisseurTest() {
        try {
            FournisseurDAO dao = DAOFactory.getFournisseurDAO();
            dao.insertSecuriser(new Fournisseur("test"));
            dao.updateSecuriser("test", "kayak");
            dao.deleteSecuriser(new Fournisseur("kayak"));
            List<Fournisseur> fournisseurs = null;
            fournisseurs = dao.extraireSecuriser();
            for (Fournisseur item : fournisseurs) {
                System.out.println(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (StoreModeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void authentification() {

        // Scanner permet de récup de la saisie utilisateur
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****************************************************");
        System.out.println("***************** Bienvenue à toi! ******************");
        System.out.println("*****************************************************");
        System.out.println("* Merci de vous identifier");
        Utilisateur user = null;
        UtilisateurDAO dao = null;
        try {
            dao = DAOFactory.getUtilisateurDAO();

            do {
                System.out.print("* Identifiant : ");
                String login = scanner.nextLine();
                System.out.print("* Mot de passe : ");
                String pwd = scanner.nextLine();
                user = dao.authentifier(login, pwd);
                if(user != null) {
                    System.out.printf("* Bienvenue à toi %s !", user.getNom());
                }
                else {
                    System.out.println("* Erreur d'authentification, merci de recommencer");
                }
            } while ( user == null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (StoreModeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void authentificationSecuriser() {

        // Scanner permet de récup de la saisie utilisateur
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****************************************************");
        System.out.println("***************** Bienvenue à toi! ******************");
        System.out.println("*****************************************************");
        System.out.println("* Merci de vous identifier");
        Utilisateur user = null;
        UtilisateurDAO dao = null;
        try {
            dao = DAOFactory.getUtilisateurDAO();

            do {
                System.out.print("* Identifiant : ");
                String login = scanner.nextLine();
                System.out.print("* Mot de passe : ");
                String pwd = scanner.nextLine();
                user = dao.authentifierSecuriser(login, pwd);
                if(user != null) {
                    System.out.printf("* Bienvenue à toi %s !", user.getNom());
                }
                else {
                    System.out.println("* Erreur d'authentification, merci de recommencer");
                }
            } while ( user == null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (StoreModeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
