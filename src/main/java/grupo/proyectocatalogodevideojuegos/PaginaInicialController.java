package grupo.proyectocatalogodevideojuegos;

import grupo.modelo.LCDE;
import grupo.modelo.LectorCsvCatalogo;
import grupo.modelo.Videojuego;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PaginaInicialController implements Initializable {

    @FXML
    private TilePane panel;
    public static Videojuego ultimoVideojuegoElegido;
    @FXML
    private RadioButton botonTitulo;
    @FXML
    private RadioButton botonFecha;
    LCDE<Videojuego> videojuegos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.videojuegos = LectorCsvCatalogo.cargarListaVideojuegos();
        mostrarVideojuegos(videojuegos);
        setActions();
    }    
    
    private void mostrarVideojuegos(LCDE<Videojuego> videojuegos){
        for (Videojuego v : videojuegos) {
            VBox bookView = crearElementosVideojuego(v);
            panel.getChildren().addAll(bookView);
        }
    }
    
    private VBox crearElementosVideojuego(Videojuego videojuego){
        System.out.println("Adding: " + videojuego.getTitulo());

        VBox vbox = new VBox();
        try{
            Image image = new Image(new FileInputStream("src\\main\\resources\\grupo\\ListaVideojuegos\\imagenes\\Portada\\" + videojuego.getPortada()), 150, 0, true, false);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(150);

            vbox.getChildren().add(imageView);

            Label titleLabel = new Label(videojuego.getTitulo());
            titleLabel.setPadding(new Insets(8, 0, 0, 0));
            titleLabel.setTextFill(Color.web("#F5F5F5"));
            titleLabel.setFont(Font.font("SansSerif", 13));
            titleLabel.setMaxWidth(150);
            vbox.getChildren().add(titleLabel);
        
            imageView.setOnMouseClicked(event -> {
                try {
                    ultimoVideojuegoElegido = videojuego;
                    App.setRoot("infoVideojuego");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vbox;
    }
    
    private void setActions() {
        botonTitulo.setOnAction(eh->{
            condicion();
        });
        botonFecha.setOnAction(eh->{
            condicion();
        });
    }
    
    private void condicion(){
        if(botonTitulo.isSelected() && botonFecha.isSelected()){
                
            }else if(botonTitulo.isSelected()){
                ordenarPorTitulo();
            }else if(botonFecha.isSelected()){
                
            }
    }
    
    private void ordenarPorTitulo(){
        LCDE<Videojuego> tmp = new LCDE<>();
        PriorityQueue<Videojuego> colaVideojuegos = new PriorityQueue<>((v1,v2)->{
            return v1.getTitulo().compareTo(v2.getTitulo());
        });
        for(Videojuego v : this.videojuegos){
            colaVideojuegos.offer(v);
        }
        while(!colaVideojuegos.isEmpty()){
            tmp.addLast(colaVideojuegos.remove());
        }
        panel.getChildren().clear();
        this.videojuegos = tmp;
        mostrarVideojuegos(this.videojuegos);
    }
    
    private void ordenarPorfecha(){
        LCDE<Videojuego> tmp = new LCDE<>();
        PriorityQueue<Videojuego> colaVideojuegos = new PriorityQueue<>((v1,v2)->{
            return v1.getTitulo().compareTo(v2.getTitulo());
        });
        for(Videojuego v : this.videojuegos){
            colaVideojuegos.offer(v);
        }
        while(!colaVideojuegos.isEmpty()){
            tmp.addLast(colaVideojuegos.remove());
        }
        panel.getChildren().clear();
        this.videojuegos = tmp;
        mostrarVideojuegos(this.videojuegos);
    }
    
}
