package tablerobasquet;

import java.util.*;

public class Equipo {

    //Attributes
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private int puntosEquipo = 0;

    //Constructor
    public Equipo() {
        setearNombres();
    }

    //Getters Setters
    public ArrayList getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getPuntosEquipo() {
        return puntosEquipo;
    }

    public void setPuntosEquipo(int puntosEquipo) {
        this.puntosEquipo = puntosEquipo;
    }

    //Methods    
    //Set names method (called by constructor).
    public void setearNombres() {
        String nombre;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            do {
                System.out.println("Indique el nombre del jugador número " + (i + 1));
                nombre = sc.nextLine();
                jugadores.add(new Jugador(nombre));
            } while (nombre.isEmpty());
        }
    }

    //Search index player method.
    public int buscarJugador(String jugador) {
        int index = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugador.equalsIgnoreCase(jugadores.get(i).getNombre())) {
                index = jugadores.indexOf(jugadores.get(i));
            }
        }
        return index;
    }

    //Add points method.
    public void meterPuntos(String jugador, int puntos) {
        int index = buscarJugador(jugador);
        jugadores.get(index).setPuntos(jugadores.get(index).getPuntos() + puntos);
    }

    //Add fouls method.  
    public void sumarFaltas(String jugador) {
        int index = buscarJugador(jugador);
        jugadores.get(index).setFaltas(jugadores.get(index).getFaltas() + 1);
    }

    //See stats method.
    public void VerEstadisticas(Equipo equipo, int numeroEquipo) {

        int i = 0;
        int puntosTotales = 0;
        while (i < 5) {
            System.out.println("Los puntos del jugador " + (i + 1) + " del equipo " + numeroEquipo + " son:" + jugadores.get(i).getPuntos() + ", faltas: " + jugadores.get(i).getFaltas());
            puntosTotales += jugadores.get(i).getPuntos();
            i++;
        }
        System.out.println("Los puntos del equipo " + numeroEquipo + " son: " + puntosTotales);

    }
}
