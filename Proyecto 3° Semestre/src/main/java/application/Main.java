package application;

import java.util.ArrayList;
import java.util.List;

import application.database.CrearTablas;
import application.models.Arreglo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stagePrincipal;

    public static final double ANCHO = 900;
    public static final double ALTO = 600;

    public static List<Arreglo> arreglosSeleccionados = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {

        //  Crear base de datos y tablas si no existen
        CrearTablas.crear();

        stagePrincipal = stage;

        FXMLLoader loader = new FXMLLoader(
                Main.class.getResource("/fxml/inicio.fxml")
        );

        Scene scene = new Scene(loader.load(), ANCHO, ALTO);
        stage.setTitle("Flores Eternas");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void cambiarEscena(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Main.class.getResource(fxml)
            );
            Scene scene = new Scene(loader.load(), ANCHO, ALTO);
            stagePrincipal.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // SOLO lanzar JavaFX
        launch(args);
    }
}
