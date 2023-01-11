package fr.epsi.jdbc.dal;

import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface FournisseurDao {
    List<Fournisseur> extraire() throws SQLException;
    void insert(Fournisseur fournisseur) throws SQLException;
    int update(String ancienNom, String nouveauNom) throws SQLException;
    boolean delete(Fournisseur fournisseur) throws SQLException;
}