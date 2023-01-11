package fr.epsi.jdbc.ihm;

import fr.epsi.jdbc.dal.FournisseurDaoJdbc;
import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FournisseurDaoJdbc dao = new FournisseurDaoJdbc();
        try {
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
        }


    }
}
