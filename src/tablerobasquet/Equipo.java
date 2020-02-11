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
        ArrayList<Integer> indexEncontrados = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        
        //Store all the indexes of the players who matches with String jugador
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugador.equalsIgnoreCase(jugadores.get(i).getNombre())) {
                indexEncontrados.add(jugadores.indexOf(jugadores.get(i)) + 1);
            }
        }
        //If there is more than one player with the same name ask to which one add a stat.
        if (indexEncontrados.size() > 1) {
            System.out.println("Nombre repetido, seleccione a que jugador desea sumarle la estadística" + indexEncontrados);
            String opcion = sc.nextLine();
            index = (Integer.parseInt(opcion) - 1);
        //If there is not players with this name.
        }else if(indexEncontrados.size() == 0) {
            index = 999; 
        }
        //If there is only one player with this name.
        else{
            index = indexEncontrados.get(0);
        }
        return index;
    }

    //Receive the index of the player and add points.
    public void meterPuntos(String jugador, int puntos) {
        int index = buscarJugador(jugador);
        if (index == 999)
        {            
            System.out.println("No se ha encontrado ese jugador");
        }
        else
        {
            jugadores.get(index).setPuntos(jugadores.get(index).getPuntos() + puntos);
        } 
        
        
    }

    ///Receive the index of the player and add a foul.
    public void sumarFaltas(String jugador) {
        int index = buscarJugador(jugador);
        jugadores.get(index).setFaltas(jugadores.get(index).getFaltas() + 1);
    }

    //See stats method.
    public void VerEstadisticas(Equipo equipo, int numeroEquipo) {

        int i = 0;
        int puntosTotales = 0;
        while (i < 5) {
            System.out.println("Los puntos del jugador " + jugadores.get(i).getNombre() + " del equipo " + numeroEquipo + " son:" + jugadores.get(i).getPuntos() + ", faltas: " + jugadores.get(i).getFaltas());
            puntosTotales += jugadores.get(i).getPuntos();
            i++;
        }
        System.out.println("Los puntos del equipo " + numeroEquipo + " son: " + puntosTotales);

    }
}
