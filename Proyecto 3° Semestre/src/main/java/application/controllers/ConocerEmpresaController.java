package application.controllers;

import application.Main;
import javafx.fxml.FXML;

public class ConocerEmpresaController {

    @FXML
    private void volverCatalogo() {
        Main.cambiarEscena("/fxml/catalogo.fxml");
    }
}
