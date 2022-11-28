
package grupo.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorCsvCatalogo {
    public static LCDE<Videojuego> cargarListaVideojuegos(){
        LCDE<Videojuego> videojuegos = new LCDE<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\grupo\\ListaVideojuegos\\Catalogo.txt"));){
            br.readLine(); 
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split("/");
                String capturas= datos[6];
                String[] arregloCapturas = capturas.substring(1,capturas.length()-1).split(",");
                videojuegos.addLast(new Videojuego(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],agregarALista(arregloCapturas)));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return videojuegos;
    }
    
    public static LCDE<String> agregarALista(String[] arreglo){
        LCDE<String> lista = new LCDE<>();
        for (String s: arreglo){
            lista.addLast(s);
        }
        return lista;
    }
}
