package application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL =
            "jdbc:sqlite:database/flores_eternas.db";

    private static Connection conexion;

    public static Connection getConexion() throws SQLException {

        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection(URL);
        }
        return conexion;
    }
}
