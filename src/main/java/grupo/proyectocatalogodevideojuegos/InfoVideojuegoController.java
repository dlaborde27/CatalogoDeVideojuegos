/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo.proyectocatalogodevideojuegos;

import grupo.modelo.LCDE;
import grupo.modelo.Videojuego;
import static grupo.proyectocatalogodevideojuegos.PaginaInicialController.ultimoVideojuegoElegido;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

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
    Videojuego videojuego = PaginaInicialController.ultimoVideojuegoElegido;
    @FXML
    private ImageView portada;
    @FXML
    private Button atras;
    @FXML
    private TilePane panelCapturas;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            titulo.setText(videojuego.getTitulo());
            descripcion.setText(videojuego.getDescripcion());
            genero.setText(videojuego.getGeneros());
            portada.setImage(new Image(new FileInputStream("src\\main\\resources\\grupo\\ListaVideojuegos\\imagenes\\Portada\\" + videojuego.getPortada()), 300, 0, true, false));
            portada.setFitWidth(300);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        mostrarVideojuegos(videojuego.getCapturasDePantalla());
        
        atras.setOnMouseClicked(event -> {
                try {
                    App.setRoot("paginaInicial");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        
    }
    
    private void mostrarVideojuegos(LCDE<String> caps){
        for (String c : caps) {
            VBox boxCaptura = crearElementosVideojuego(c);
            panelCapturas.getChildren().addAll(boxCaptura);
        }
    }

    private VBox crearElementosVideojuego(String c) {
        VBox vbox = new VBox();
        try {
            Image image = new Image(new FileInputStream("src\\main\\resources\\grupo\\ListaVideojuegos\\imagenes\\Screenshot\\" + c), 150, 0, true, false);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(300);
            imageView.setFitHeight(200);
            vbox.getChildren().add(imageView);
            vbox.setPadding(new Insets(0, 8, 0, 0));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return vbox;
    }
    
    
}
