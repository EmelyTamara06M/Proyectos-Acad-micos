package application.controllers;

import java.sql.SQLException;

import application.Main;
import application.database.PedidoDAO;
import application.models.Arreglo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class RealizarPedidoController {

    @FXML
    private VBox contenedorPedidos;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextArea txtDetalle;

    @FXML
    public void initialize() {
        cargarPedidos();
    }

    //  MOSTRAR ARREGLOS SELECCIONADOS
    private void cargarPedidos() {

        contenedorPedidos.getChildren().clear();

        if (Main.arreglosSeleccionados.isEmpty()) {
            Label lbl = new Label("No se ha seleccionado ningún arreglo.");
            lbl.setStyle("-fx-font-size: 16px; -fx-text-fill: #666;");
            contenedorPedidos.getChildren().add(lbl);
            return;
        }

        for (Arreglo arreglo : Main.arreglosSeleccionados) {

            HBox fila = new HBox(15);
            fila.setStyle(
                    "-fx-background-color: white;" +
                    "-fx-padding: 10;" +
                    "-fx-background-radius: 12;" +
                    "-fx-effect: dropshadow(gaussian, #ccc, 6, 0, 0, 3);"
            );

            // Imagen
            ImageView imagen;
            try {
                imagen = new ImageView(
                        new Image(getClass().getResourceAsStream(arreglo.getRutaImagen()))
                );
            } catch (Exception e) {
                imagen = new ImageView();
            }

            imagen.setFitWidth(90);
            imagen.setPreserveRatio(true);

            //  Información
            VBox info = new VBox(5);
            Label nombre = new Label(arreglo.getNombre());
            nombre.setStyle("-fx-font-weight: bold;");
            Label precio = new Label("$" + arreglo.getPrecio());

            info.getChildren().addAll(nombre, precio);

            //  Botón quitar
            Button btnQuitar = new Button("✖");
            btnQuitar.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: #ff3385;" +
                    "-fx-font-size: 18px;" +
                    "-fx-font-weight: bold;"
            );

            btnQuitar.setOnAction(e -> {
                Main.arreglosSeleccionados.remove(arreglo);
                cargarPedidos();
            });

            HBox.setHgrow(info, Priority.ALWAYS);
            fila.getChildren().addAll(imagen, info, btnQuitar);
            contenedorPedidos.getChildren().add(fila);
        }
    }

    //  CONFIRMAR PEDIDO (CON NOTIFICACIÓN ESTILIZADA)
    @FXML
    private void confirmarPedido() {

        try {
            int clienteId = PedidoDAO.guardarCliente(
                    txtNombre.getText(),
                    txtTelefono.getText(),
                    txtDireccion.getText()
            );

            int pedidoId = PedidoDAO.guardarPedido(clienteId);

            PedidoDAO.guardarDetalle(pedidoId, Main.arreglosSeleccionados);

            //  ALERTA ESTILIZADA
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pedido realizado");
            alert.setHeaderText("¡Gracias por tu compra! 🌷");
            alert.setContentText("Tu pedido ha sido enviado correctamente.");

            alert.getDialogPane().getStylesheets().add(
                    getClass().getResource("/styles/styles.css").toExternalForm()
            );
            alert.getDialogPane().getStyleClass().add("dialogo-flores");

            alert.showAndWait();

            // Limpiar y volver a inicio
            Main.arreglosSeleccionados.clear();
            Main.cambiarEscena("/fxml/inicio.fxml");

        } catch (SQLException e) {
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error de base de datos");
            alert.setContentText("No se pudo registrar el pedido.");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error inesperado");
            alert.setContentText("Ocurrió un problema en la aplicación.");
            alert.showAndWait();
        }
    }

    //  VOLVER AL CATÁLOGO
    @FXML
    private void volverCatalogo() {
        Main.cambiarEscena("/fxml/catalogo.fxml");
    }
}
