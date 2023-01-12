package fr.epsi.jdbc.dal;

import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FournisseurXMLDAO implements FournisseurDAO {
    @Override
    public List<Fournisseur> extraire() throws SQLException {
        System.out.println("Extraire XML");
        return new ArrayList<>();
    }

    @Override
    public void insert(Fournisseur fournisseur) throws SQLException {
        System.out.println("Insert XML");
    }

    @Override
    public int update(String ancienNom, String nouveauNom) throws SQLException {
        System.out.println("Update XML");
        return 0;
    }

    @Override
    public boolean delete(Fournisseur fournisseur) throws SQLException {
        System.out.println("Delete XML");
        return false;
    }

    @Override
    public List<Fournisseur> extraireSecuriser() throws SQLException {
        return new ArrayList<>();
    }

    @Override
    public void insertSecuriser(Fournisseur fournisseur) throws SQLException {

    }

    @Override
    public int updateSecuriser(String ancienNom, String nouveauNom) throws SQLException {
        return 0;
    }

    @Override
    public boolean deleteSecuriser(Fournisseur fournisseur) throws SQLException {
        return false;
    }
}
