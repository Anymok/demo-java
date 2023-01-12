package fr.epsi.jdbc.dal;

import fr.epsi.jdbc.entites.Utilisateur;

import java.sql.SQLException;
import java.util.List;

public interface UtilisateurDAO {

    List<Utilisateur> extraire() throws SQLException;
    void insert(Utilisateur utilisateur) throws SQLException;
    Utilisateur authentifier(String identifiant, String mdp);

}
