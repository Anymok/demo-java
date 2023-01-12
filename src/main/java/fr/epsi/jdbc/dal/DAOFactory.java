package fr.epsi.jdbc.dal;

import fr.epsi.jdbc.error.StoreModeNotFoundException;

import java.util.ResourceBundle;

public class DAOFactory {

    private static final String STORE_MODE;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("app-config");
        STORE_MODE = bundle.getString("store.mode");
    }

    // Empêcher l'initialisation de cette classe
    private DAOFactory() {}

    public static FournisseurDAO getFournisseurDAO() throws StoreModeNotFoundException {


        FournisseurDAO dao;
        switch ( STORE_MODE ) {
            case "JDBC":
                dao = new FournisseurJDBCDAO();
                break;
            case "XML":
                dao = new FournisseurXMLDAO();
                break;
            default:
                throw new StoreModeNotFoundException(STORE_MODE);
        }
        return dao;
    }

    public static UtilisateurDAO getUtilisateurDAO() throws StoreModeNotFoundException {

        UtilisateurDAO dao;
        switch ( STORE_MODE ) {
            case "JDBC":
                dao = new UtilisateurJDBCDAO();
                break;
            case "XML":
                // TODO à implémenter
            default:
                throw new StoreModeNotFoundException(STORE_MODE);
        }
        return dao;
    }
}
