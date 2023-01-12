package fr.epsi.jdbc.dal;

import fr.epsi.jdbc.entites.Fournisseur;
import fr.epsi.jdbc.entites.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;


public class UtilisateurJDBCDAO implements UtilisateurDAO {
    private static final String SELECT_QUERY = "SELECT * FROM utilisateur";
    private static final String INSERT_QUERY = "INSERT INTO utilisateur (nom, identifiant, mdp) VALUES ('%s', '%s', '%s')";
    private static final String SELECT_PAR_ID_QUERY = "SELECT * FROM utilisateur WHERE id=%d";
    private static final String LOGIN_QUERY = "SELECT * FROM utilisateur WHERE identifiant='%s' AND mdp='%s'";
    private static final String LOGIN_SERCURE_QUERY = "SELECT * FROM utilisateur WHERE identifiant=? AND mdp=?";
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
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
        Statement st = connection.createStatement()){
            ResultSet rs = st.executeQuery(String.format(SELECT_QUERY));
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String login = rs.getString("identifiant");
                String pwd = rs.getString("mdp");
                Utilisateur utilisateur = new Utilisateur(id, nom, login, pwd);
                utilisateurs.add(utilisateur);
            }
        }
        return utilisateurs;
    }

    @Override
    public void insert(Utilisateur utilisateur) throws SQLException {

    }

    @Override
    public Utilisateur authentifier(String identifiant, String mdp) throws SQLException {
        Utilisateur utilisateur = null;
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            Statement st = connection.createStatement())
        {
            ResultSet rs = st.executeQuery(String.format(LOGIN_QUERY, identifiant, mdp));
            if (rs.next()) {
               int id = rs.getInt("id");
               String nom = rs.getString("nom");
               String login = rs.getString("identifiant");
               String pwd = rs.getString("mdp");

               utilisateur = new Utilisateur(id, nom, login, pwd);
            }
        }
        return utilisateur;
    }

    @Override
    public Utilisateur authentifierSecuriser(String identifiant, String mdp) throws SQLException {
        Utilisateur utilisateur = null;
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            PreparedStatement st = connection.prepareStatement(LOGIN_SERCURE_QUERY))
        {
            st.setString(1, identifiant);
            st.setString(2, mdp);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String nom = rs.getString("nom");
                    String login = rs.getString("identifiant");
                    String pwd = rs.getString("mdp");

                    utilisateur = new Utilisateur(id, nom, login, pwd);
                }
            }
        }
        return utilisateur;
    }
}
