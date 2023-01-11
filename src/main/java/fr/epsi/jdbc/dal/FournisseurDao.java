package fr.epsi.jdbc.dal;

import fr.epsi.jdbc.entites.Fournisseur;

import java.util.List;

public interface FournisseurDao {
    List<Fournisseur> extraire();
    void insert(Fournisseur fournisseur);
    int update(String ancienNom, String nouveauNom);
    boolean delete(Fournisseur fournisseur);
}