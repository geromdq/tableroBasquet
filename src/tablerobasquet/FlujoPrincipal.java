package tablerobasquet;

import java.util.*;

public class FlujoPrincipal {

    //Declarationan and initialization
    Equipo team1 = new Equipo();
    Equipo team2 = new Equipo();
    String opcion = "";
    String jugador = "a";
    int team = 0;

    Scanner sc = new Scanner(System.in);

    public void comprobarOpcion() {

        switch (opcion) {
            //If user select "S" the execution stops
            case "S":
                System.exit(0);
                break;
            //If it's necesary the name of the player (and the team) are required.
            case "D":
            case "T":
            case "F":
                System.out.println("Ingrese el nombre del jugador:");
                jugador = sc.nextLine();
                System.out.println("seleccione equipo 1 o equipo 2");
                team = sc.nextInt();
                ejecutarOpcion();
                break;
            case "E":
                ejecutarOpcion();
                break;
            //If user selects an invalid option the program requests again until he receives a valid option.    
            default:
                while (!opcion.equalsIgnoreCase("D") && !opcion.equalsIgnoreCase("T") && !opcion.equalsIgnoreCase("E") && !opcion.equalsIgnoreCase("F") && !opcion.equalsIgnoreCase("S")) {
                    System.out.println(" Ingrese 'D' para suma un doble \n Ingrese 'T' para suma un triple \n Ingrese 'F' para sumar faltas \n Ingrese 'E' para ver las estadísticas \n Ingrese 'S' para salir");
                    opcion = sc.nextLine();
                    opcion = sc.nextLine();
                    opcion = opcion.toUpperCase();
                }
                comprobarOpcion();
                break;
            // ejecutarOpcion();
        }

    }

    public void ejecutarOpcion() {

        if (team == 1) {
            switch (opcion) {
                case "D":
                    team1.meterPuntos(jugador, 2);
                    opcion = "";
                    break;
                case "T":
                    team1.meterPuntos(jugador, 3);
                    opcion = "";
                    break;
                case "F":
                    team1.sumarFaltas(jugador);
                    opcion = "";
                    break;
                case "E":
                    team1.VerEstadisticas(team1, 1);
                    team2.VerEstadisticas(team2, 2);
                    opcion = "";
                    break;
            }
            comprobarOpcion();
        } else {
            switch (opcion.toUpperCase()) {
                case "D":
                    team2.meterPuntos(jugador, 2);
                    opcion = "";
                    break;
                case "T":
                    team2.meterPuntos(jugador, 3);
                    opcion = "";
                    break;
                case "F":
                    team2.sumarFaltas(jugador);
                    opcion = "";
                    break;
                case "E":
                    team1.VerEstadisticas(team1, 1);
                    team2.VerEstadisticas(team2, 2);
                    opcion = "";
                    break;
            }
        }
        comprobarOpcion();
    }

}
