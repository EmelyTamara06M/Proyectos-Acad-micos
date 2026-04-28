package application.controllers;

import application.Main;
import application.models.Arreglo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class CatalogoController {

    @FXML
    private FlowPane contenedor;

    @FXML
    private VBox menuLateral;

    private boolean menuVisible = false;

    @FXML
    public void initialize() {
        contenedor.getChildren().clear();

        agregarFlor("Romance Eterno", 16.0, "/images/flor1.jpeg");
        agregarFlor("Pasión Infinita", 25.0, "/images/flor2.jpeg");
        agregarFlor("Sueño Lavanda", 25.0, "/images/flor3.jpeg");
        agregarFlor("Promesa Única", 4.50, "/images/flor4.jpeg");
        agregarFlor("Dulce Armonía", 12.0, "/images/flor5.jpeg");
        agregarFlor("Sol Eterno", 18.0, "/images/flor6.jpeg");
        agregarFlor("Corazón Radiante", 6.0, "/images/flor7.jpeg");
        agregarFlor("Luz de Vida", 16.0, "/images/flor8.jpeg");
        agregarFlor("Amor Dual", 25.0, "/images/flor9.jpeg");
        agregarFlor("Cielo Perpetuo", 20.0, "/images/flor10.jpeg");
    }

    // ---------------- MENÚ LATERAL ----------------

    @FXML
    private void toggleMenu() {
        menuVisible = !menuVisible;
        menuLateral.setVisible(menuVisible);
        menuLateral.setManaged(menuVisible);
    }

    @FXML
    private void volverInicio() {
        Main.cambiarEscena("/fxml/inicio.fxml");
    }

    @FXML
    private void irCatalogo() {
        System.out.println("Ya estás en el catálogo");
    }

    @FXML
    private void conocerEmpresa() {
        Main.cambiarEscena("/fxml/conocerEmpresa.fxml");
    }

    @FXML
    private void realizarPedido() {
        if (Main.arreglosSeleccionados.isEmpty()) {
            System.out.println("No se ha seleccionado ningún arreglo");
            return;
        }
        Main.cambiarEscena("/fxml/RealizarPedido.fxml");
    }

    @FXML
    private void salir() {
        System.exit(0);
    }

    // ---------------- AGREGAR FLORES ----------------

    private void agregarFlor(String nombre, double precio, String rutaImagen) {

        VBox tarjeta = new VBox(10);
        tarjeta.setPrefWidth(220);

        String estiloNormal =
                "-fx-background-color: white;" +
                "-fx-padding: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-effect: dropshadow(gaussian, #ccc, 8, 0, 0, 4);";

        String estiloSeleccionado =
                "-fx-background-color: #ffe6ef;" +
                "-fx-padding: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: #ff66a3;" +
                "-fx-border-radius: 15;" +
                "-fx-border-width: 2;" +
                "-fx-effect: dropshadow(gaussian, #ff99bb, 12, 0, 0, 6);";

        tarjeta.setStyle(estiloNormal);

        ImageView imagen = new ImageView(
                new Image(getClass().getResourceAsStream(rutaImagen))
        );
        imagen.setFitWidth(190);
        imagen.setPreserveRatio(true);

        Label lblNombre = new Label(nombre);
        lblNombre.setStyle("-fx-font-weight: bold; -fx-font-size: 15px;");

        Label lblPrecio = new Label("$ " + String.format("%.2f", precio));

        tarjeta.getChildren().addAll(imagen, lblNombre, lblPrecio);

        // Selección múltiple
        tarjeta.setOnMouseClicked(e -> {

            boolean yaSeleccionado = tarjeta.getStyle().equals(estiloSeleccionado);

            if (yaSeleccionado) {
                tarjeta.setStyle(estiloNormal);
                Main.arreglosSeleccionados.removeIf(
                        a -> a.getNombre().equals(nombre)
                );
                System.out.println("Quitado: " + nombre);
            } else {
                tarjeta.setStyle(estiloSeleccionado);
                Main.arreglosSeleccionados.add(
                        new Arreglo(nombre, precio, rutaImagen)
                );
                System.out.println("Agregado: " + nombre);
            }
        });

        contenedor.getChildren().add(tarjeta);
    }
}
