package fr.epsi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.password");
    }

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
             Statement st = connection.createStatement()){

            try {
                int nb = st.executeUpdate("DELETE FROM fournisseur WHERE nom='La Maison des Peintures'");
                System.out.printf("Nombre de ligne affectées : %d %n", nb);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}