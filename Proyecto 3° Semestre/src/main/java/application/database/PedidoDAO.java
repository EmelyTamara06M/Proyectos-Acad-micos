package application.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import application.models.Arreglo;

public class PedidoDAO {

    // GUARDAR CLIENTE
    public static int guardarCliente(String nombre, String telefono, String direccion) throws SQLException {

        String sql = "INSERT INTO clientes (nombre, telefono, direccion) VALUES (?, ?, ?)";
        Connection con = ConexionDB.getConexion();
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, nombre);
        ps.setString(2, telefono);
        ps.setString(3, direccion);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    //  GUARDAR PEDIDO
    public static int guardarPedido(int clienteId) throws SQLException {

        String sql = "INSERT INTO pedidos (cliente_id) VALUES (?)";
        Connection con = ConexionDB.getConexion();
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, clienteId);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    //  GUARDAR DETALLE DEL PEDIDO
    public static void guardarDetalle(int pedidoId, List<Arreglo> arreglos) throws SQLException {

        String sql = "INSERT INTO detalle_pedido (pedido_id, nombre, precio, cantidad) VALUES (?, ?, ?, ?)";

        Connection con = ConexionDB.getConexion();
        PreparedStatement ps = con.prepareStatement(sql);

        for (Arreglo a : arreglos) {
            ps.setInt(1, pedidoId);          // ID del pedido
            ps.setString(2, a.getNombre());  // Nombre del arreglo
            ps.setDouble(3, a.getPrecio());  // Precio (double)
            ps.setInt(4, a.getCantidad());   // Cantidad

            ps.executeUpdate();
        }
    }
}
