package fr.epsi.jdbc.dal;

import fr.epsi.jdbc.entites.Utilisateur;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class UtilisateurJDBCDAO implements UtilisateurDAO {
    private static final String SELECT_QUERY = "SELECT * FROM fournisseur";
    private static final String INSERT_QUERY = "INSERT INTO utilisateur (nom, identifiant, mdp) VALUES ('%s', '%s', '%s')";
    private static final String UPDATE_QUERY = "UPDATE fournisseur SET NOM = '%s' WHERE NOM = '%s'";
    private static final String DELETE_QUERY = "DELETE FROM fournisseur WHERE nom='%s'";
    private static final String  DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.password");
    }
    @Override
    public List<Utilisateur> extraire() throws SQLException {
        return new ArrayList<>();
    }

    @Override
    public void insert(Utilisateur utilisateur) throws SQLException {

    }

    @Override
    public Utilisateur authentifier(String identifiant, String mdp) {
        return null;
    }
}
