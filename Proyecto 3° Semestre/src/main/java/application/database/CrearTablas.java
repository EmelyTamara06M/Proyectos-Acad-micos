package application.database;

import java.sql.Connection;
import java.sql.Statement;

public class CrearTablas {

    public static void crear() {
        try {
            Connection con = ConexionDB.getConexion();
            Statement st = con.createStatement();

            // TABLA CLIENTES
            st.execute(
                "CREATE TABLE IF NOT EXISTS clientes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "telefono TEXT, " +
                "direccion TEXT" +
                ")"
            );

            // TABLA PEDIDOS
            st.execute(
                "CREATE TABLE IF NOT EXISTS pedidos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "cliente_id INTEGER" +
                ")"
            );

            // TABLA DETALLE PEDIDO (SIN arreglo_id)
           st.execute(
            "CREATE TABLE IF NOT EXISTS detalle_pedido (" +
             "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "pedido_id INTEGER NOT NULL, " +
            "nombre TEXT NOT NULL, " +
              "precio REAL NOT NULL, " +
              "cantidad INTEGER NOT NULL, " +
             "imagen TEXT" +
    ")"
);

            System.out.println("✔ Tablas creadas correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
