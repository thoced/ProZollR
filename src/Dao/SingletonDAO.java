package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonDAO {

    private static Connection connection;

    private static String pathDB = null;

    public static String getPathDB() {
        return pathDB;
    }

    public static void setPathDB(String pathDB) {
        SingletonDAO.pathDB = pathDB;
    }

    public static Connection getInstanceConnection()
    {
        if (connection == null)
        {
            connectionToDb();
        }
        return connection;
    }

    private static void connectionToDb() {
        try {
            // Chargement du driver SQLite
            Class.forName("org.sqlite.JDBC");

            if(pathDB == null || pathDB.isEmpty() || pathDB.isBlank())
            {
                pathDB = "defaultDB.db";
            }

            // Établissement de la connexion à la base de données
            String url = "jdbc:sqlite:" + pathDB;
            connection = DriverManager.getConnection(url);

            if (connection != null) {
                System.out.println("Connexion à la base de données SQLite établie.");
                // Vous pouvez maintenant effectuer des opérations sur la base de données
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Erreur : Driver SQLite introuvable. Assurez-vous d'inclure le JAR de SQLite JDBC.");
        } catch (SQLException e) {
            System.err.println("Erreur : Impossible de se connecter à la base de données : " + e.getMessage());
        }
    }
}
