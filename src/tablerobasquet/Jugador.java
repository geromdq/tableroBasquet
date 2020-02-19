package tablerobasquet;

public class Jugador {

    // Attributes
    private String nombre;
    private int puntos;
    private int faltas;
    
    public Jugador(String nombre, int puntos, int faltas)
    {
        this.nombre = nombre;
        this.puntos = puntos;
        this.faltas = faltas;
    }

    //Getters Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getFaltas() {
        return faltas;
    }

    //Constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    
   
    
    
}
