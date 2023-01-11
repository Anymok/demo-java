package fr.epsi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

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

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = connection.createStatement()){
            try {
                int nb = st.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ('La Maison de la Peinture')");
                System.out.printf("Nb de lignes affectées: %d %n", nb);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
