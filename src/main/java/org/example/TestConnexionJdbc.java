package org.example;

import java.sql.*;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

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
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if(null != connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }



        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD) ;
             Statement st = cnx.createStatement()) {
            int nb = st.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ('toto')");
            System.out.printf("Nb de lignes affectées: %d %n", nb);

            // Récupération des fournisseurs
            try(ResultSet rs = st.executeQuery("SELECT * FROM  fournisseur")){
                while(rs.next()) {
                    System.out.printf("Fournisseur : id = %d, nom = %s %n",
                            rs.getInt("ID"),
                            rs.getString("NOM")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } ;






    }
}
