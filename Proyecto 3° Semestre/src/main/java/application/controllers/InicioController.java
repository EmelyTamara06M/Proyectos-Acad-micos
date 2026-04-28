package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioController {

    public void irCatalogo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/catalogo.fxml")
            );
            Parent root = loader.load();

            Scene scene = new Scene(root, 1000, 650);

            // 🔑 vuelve a aplicar el CSS correctamente
            scene.getStylesheets().add(
                    getClass().getResource("/styles/styles.css").toExternalForm()
            );

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource())
                    .getScene().getWindow();

            stage.setScene(scene);
            stage.centerOnScreen();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
