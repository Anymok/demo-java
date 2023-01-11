package fr.epsi.jdbc.dal;

import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc implements FournisseurDao{
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
    public List<Fournisseur> extraire() {
        List<Fournisseur> ListeDeFournisseurs = new ArrayList<>();

        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD) ;
             Statement st = cnx.createStatement()) {

            try(ResultSet rs = st.executeQuery("SELECT * FROM  fournisseur")){
                while(rs.next()) {
                    Fournisseur fournisseur = new Fournisseur(rs.getInt("ID"), rs.getString("NOM"));
                    ListeDeFournisseurs.add(fournisseur);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } ;
        return ListeDeFournisseurs;
    }

    @Override
    public void insert(Fournisseur fournisseur) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = connection.createStatement()){
            try {
                int nb = st.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ("+ fournisseur.getName() +")");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) {
        int nb = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = connection.createStatement()){
            try {
                nb = st.executeUpdate("UPDATE fournisseur SET NOM = "+ ancienNom +" WHERE NOM="+ nouveauNom +"");
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return nb;
    }

    @Override
    public boolean delete(Fournisseur fournisseur) {
        int nb = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
             Statement st = connection.createStatement()){
            try {
                nb = st.executeUpdate("DELETE FROM fournisseur WHERE nom="+ fournisseur.getName() );
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return nb == 0 ? false : true;
    }
}
