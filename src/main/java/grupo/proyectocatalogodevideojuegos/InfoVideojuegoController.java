/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo.proyectocatalogodevideojuegos;

import grupo.modelo.Videojuego;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class InfoVideojuegoController implements Initializable {

    @FXML
    private Label titulo;
    @FXML
    private ScrollPane capturas;
    @FXML
    private Label genero;
    @FXML
    private Label descripcion;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Videojuego videojuego = PaginaInicialController.ultimoVideojuegoElegido;
        titulo.setText(videojuego.getTitulo());
        descripcion.setText(videojuego.getDescripcion());
        genero.setText(videojuego.getGeneros());
    }    
    
}
