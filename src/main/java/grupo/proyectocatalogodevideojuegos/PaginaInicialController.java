package grupo.proyectocatalogodevideojuegos;

import grupo.modelo.LCDE;
import grupo.modelo.LectorCsvCatalogo;
import grupo.modelo.Videojuego;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class PaginaInicialController implements Initializable {

    @FXML
    private TilePane panel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LCDE<Videojuego> videojuegos = LectorCsvCatalogo.cargarListaVideojuegos();
        for(Videojuego v : videojuegos){
            System.out.println(v.getPortada());
        }
        mostrarVideojuegos(videojuegos);
        
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
            titleLabel.setMaxWidth(150);
            vbox.getChildren().add(titleLabel);
        }catch(IOException e){
            e.printStackTrace();
        }
        

        /*Label yearLabel = new Label("" + book.getYear());
        yearLabel.setTextFill(Color.web("#0000FF"));
        yearLabel.setStyle("-fx-font-weight: bold");
        vbox.getChildren().add(yearLabel);

        yearLabel.setOnMouseClicked(event -> {
            currentYear = yearLabel.getText();
            showBooksOfYear(yearLabel.getText());
        });*/

        return vbox;
    }
    
     /*private void displayBooks(List<Book> books) {
        booksDisplayed = books;
        updateBookCont();
        for (Book book : books) {
            Pane bookView = createBookView(book);
            gallery.getChildren().addAll(bookView);
        }
    }

    private Pane createBookView(Book book) {
        System.out.println("Adding: " + book.getTitle());

        VBox vbox = new VBox();
        final Image image = new Image("file:./covers/" + book.getISBN() + ".jpg", 150, 0, true, false);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);

        vbox.getChildren().add(imageView);

        Label titleLabel = new Label(book.getTitle());
        titleLabel.setMaxWidth(150);
        vbox.getChildren().add(titleLabel);

        Label yearLabel = new Label("" + book.getYear());
        yearLabel.setTextFill(Color.web("#0000FF"));
        yearLabel.setStyle("-fx-font-weight: bold");
        vbox.getChildren().add(yearLabel);

        yearLabel.setOnMouseClicked(event -> {
            currentYear = yearLabel.getText();
            showBooksOfYear(yearLabel.getText());
        });

        return vbox;
    }*/
}
