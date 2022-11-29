package grupo.modelo;
public class Reseña  {
    private String comentario;
    private String Usuario;
    private float valoracion;
    public Videojuego juego;

    public Reseña(String comentario, String Usuario, float valoracion, Videojuego juego) {
        this.comentario = comentario;
        this.Usuario = Usuario;
        this.valoracion = valoracion;
        this.juego = juego;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public Videojuego getJuego() {
        return juego;
    }

    public void setJuego(Videojuego juego) {
        this.juego = juego;
    }
    
          
}

