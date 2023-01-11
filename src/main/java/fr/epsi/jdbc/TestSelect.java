package fr.epsi.jdbc;

import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSelect {
    private static final String  DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.password");
    }

    public static void main(String[] args) {

        List<Fournisseur> ListeDeFournisseurs = new ArrayList<>();

        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD) ;
             Statement st = cnx.createStatement()) {

            // Récupération des fournisseurs
            try(ResultSet rs = st.executeQuery("SELECT * FROM  fournisseur")){
                while(rs.next()) {
                 int id = rs.getInt("ID");
                 String nom = rs.getString("NOM");

                 Fournisseur fournisseur = new Fournisseur(id, nom);
                 ListeDeFournisseurs.add(fournisseur);
                }

                for (Fournisseur item: ListeDeFournisseurs)
                {
                    System.out.println(item.toString());
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } ;
    }
}


