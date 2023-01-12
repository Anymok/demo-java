package fr.epsi.jdbc.dal;

import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurJDBCDAO implements FournisseurDAO {

    private static final String SELECT_QUERY = "SELECT * FROM fournisseur";
    private static final String INSERT_QUERY = "INSERT INTO fournisseur (NOM) VALUES ('%s')";
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
    public List<Fournisseur> extraire() throws SQLException {
        List<Fournisseur> ListeDeFournisseurs = new ArrayList<>();

        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD) ;
             Statement st = cnx.createStatement()) {

            try(ResultSet rs = st.executeQuery(SELECT_QUERY)){
                while(rs.next()) {
                    Fournisseur fournisseur = new Fournisseur(rs.getInt("ID"), rs.getString("NOM"));
                    ListeDeFournisseurs.add(fournisseur);
                }
            }
        }
        return ListeDeFournisseurs;
    }

    @Override
    public void insert(Fournisseur fournisseur) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = connection.createStatement()){

            int nb = st.executeUpdate( String.format( INSERT_QUERY, fournisseur.getName() ));

        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) throws SQLException {
        int nb = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = connection.createStatement()){

            nb = st.executeUpdate(String.format(UPDATE_QUERY, nouveauNom, ancienNom));

        }
        return nb;
    }

    @Override
    public boolean delete(Fournisseur fournisseur) throws SQLException {
        int nb = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
             Statement st = connection.createStatement()){

            nb = st.executeUpdate(String.format( DELETE_QUERY, fournisseur.getName() ) );

        }
        return nb == 0 ? false : true;
    }
}
