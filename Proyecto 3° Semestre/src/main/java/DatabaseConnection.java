
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:flores_eternas.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Ejecuta esto una vez al iniciar la app para crear la tabla
    public static void crearTablaPedidos() {
        String sql = "CREATE TABLE IF NOT EXISTS pedidos ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + "nombre_flor TEXT, "
                   + "cantidad INTEGER, "
                   + "total REAL, "
                   + "fecha DATETIME DEFAULT CURRENT_TIMESTAMP"
                   + ");";
        try (Connection conn = getConnection(); 
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Base de datos lista para recibir pedidos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}