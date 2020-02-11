package tablerobasquet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Declarationan and initialization
        Equipo team1 = new Equipo();
        Equipo team2 = new Equipo();
        String opcion ="";
        String jugador = "a";
        int team = 0;

        Scanner sc = new Scanner(System.in);

        //Execution
        do {          
            while (!opcion.equalsIgnoreCase("D") && !opcion.equalsIgnoreCase("T") && !opcion.equalsIgnoreCase("E") && !opcion.equalsIgnoreCase("F") && !opcion.equalsIgnoreCase("S")) {
                System.out.println(" Ingrese 'D' para suma un doble \n Ingrese 'T' para suma un triple \n Ingrese 'F' para sumar faltas \n Ingrese 'E' para ver las estadísticas \n Ingrese 'S' para salir");
                opcion = sc.nextLine();
                opcion = opcion.toUpperCase();
            }

            //If user select "S" the execution stops
            if (opcion.equalsIgnoreCase("S")) {
                return;
            }

            //If it's necesary the name of the player (and the team) are required.
            if (opcion.equals("D") || opcion.equals("T") || opcion.equals("F")) {
                System.out.println("Ingrese el nombre del jugador:");
                jugador = sc.nextLine();
                System.out.println("seleccione equipo 1 o equipo 2");
                team = sc.nextInt();
            }
            {
                if (team == 1) {
                    switch (opcion) {
                        case "D":
                            team1.meterPuntos(jugador, 2);
                            break;
                        case "T":
                            team1.meterPuntos(jugador, 3);
                            break;
                        case "F":
                            team1.sumarFaltas(jugador);
                            break;
                        case "E":
                            team1.VerEstadisticas(team1,1);
                            team2.VerEstadisticas(team2,2);
                            break;
                    }
                } else {

                    switch (opcion.toUpperCase()) {
                         case "D":
                            team1.meterPuntos(jugador, 2);
                            break;
                        case "T":
                            team1.meterPuntos(jugador, 3);
                            break;
                        case "F":
                            team1.sumarFaltas(jugador);
                            break;
                        case "E":
                            team1.VerEstadisticas(team1,1);
                            team2.VerEstadisticas(team2,2);
                            break;

                    }
                }
            }

            //If it's necessary the execution starts again.
            System.out.println("Si desea continuar la ejecución ingrese 'Y'");
            opcion = sc.nextLine();
            opcion = sc.nextLine();//Arreglar error (Queda dato en buffer?)

        } while (opcion.equalsIgnoreCase("y"));
    }

}
