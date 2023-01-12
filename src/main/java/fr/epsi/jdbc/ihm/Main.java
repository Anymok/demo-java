package fr.epsi.jdbc.ihm;

import fr.epsi.jdbc.dal.DAOFactory;
import fr.epsi.jdbc.dal.FournisseurDAO;
import fr.epsi.jdbc.entites.Fournisseur;
import fr.epsi.jdbc.error.StoreModeNotFoundException;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
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
        }


    }
}
