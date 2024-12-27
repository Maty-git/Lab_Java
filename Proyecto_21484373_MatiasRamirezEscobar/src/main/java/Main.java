import conecta4.Game_21484373_RamirezMatias;

import java.util.Scanner;

/**
 * <h1>CLASE MAIN (TDA)</h1>
 * Clase principal para ejecutar el juego Conecta 4.
 * Proporciona un menú interactivo para jugar Conecta 4,
 * hacer jugadas y visualizar estadísticas.
 */
public class Main {

    /**
     * <h1>EJECUTA EL PROGRAMA</h1>
     * Método principal que ejecuta el programa.
     * Presenta un menú interactivo para que el usuario cree y juegue partidas de Conecta 4.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        String opcion = "";
        Game_21484373_RamirezMatias game = null;

        // Menú inicial para crear un nuevo juego
        while (!opcion.equals("1")) {
            Scanner scann = new Scanner(System.in);
            System.out.println("********** BIENVENIDO A CONECTA 4 ***************\n");
            System.out.println("SELECCIONE UNA OPCIÓN:");
            System.out.println("1- Crear Un Nuevo Juego.");
            System.out.println("2- Salir Del Juego.\n");
            System.out.print("Ingrese su opción: ");
            opcion = scann.nextLine();

            switch(opcion){
                case "1":
                    // Crear un nuevo juego
                    game = new Game_21484373_RamirezMatias();
                    break;
                case "2":
                    // Salir del juego
                    game = new Game_21484373_RamirezMatias(false);
                    game.setEstaJugando(false);
                    opcion = "1";
                    break;
                default:
                    // Entrada inválida
                    System.out.println("Entrada Inválida");
                    break;
            }
        }

        // Menú principal del juego
        while(game.isEstaJugando()){
            Scanner scann = new Scanner(System.in);
            System.out.println("SELECCIONE UNA OPCION:\n");
            System.out.println("1- Crear Un Nuevo Juego.");
            System.out.println("2- Ver Estado Actual.");
            System.out.println("3- Realizar Jugadas.");
            System.out.println("4- Ver Estadisticas Generales.");
            System.out.println("5- Salir Del Juego.\n");
            System.out.print("Ingrese su opción: ");
            opcion = scann.nextLine();

            switch (opcion) {
                case "1":
                    // Crear un nuevo juego si no hay uno en curso
                    if (game.getTablero().quienGana() == '0' && !game.esEmpate()) {
                        System.out.println("Ya existe un juego en curso. Finalice el juego para poder volver a jugar (ganar o empatar).");
                    } else {
                        game.nuevoJuego();
                        System.out.println("Se reseteo el tablero y se devolvieron las fichas: !! A jugar !!");
                    }
                    break;
                case "2":
                    // Mostrar el estado actual del tablero
                    game.mostrarTablero();
                    break;
                case "3":
                    // Realizar jugadas hasta que haya un ganador o empate
                    if (game.getTablero().quienGana() != '0' || game.esEmpate()){
                        System.out.println("Ya existe un resultado para esta partida, cree un nuevo juego para poder continuar");
                    }else{
                        do {
                            game.realizarMovimiento();
                        } while (game.getTablero().quienGana() == '0' && !game.esEmpate());
                    }
                    break;
                case "4":
                    // Ver estadísticas generales
                    String stats = "***** Estadisticas Actuales *****\n" +
                            "Player 1: \n" +
                            game.getPlayer1().getNombre() + " Color: " + game.getPlayer1().getColor() + " " + game.getPlayer1().getStats() + "\n" +
                            "Player 2: \n" +
                            game.getPlayer2().getNombre() + " Color: " + game.getPlayer2().getColor() + " " + game.getPlayer2().getStats();
                    System.out.println(stats);
                    break;
                case "5":
                    // Confirmar salida del juego
                    System.out.println("¿Estás seguro de querer salir del juego? (Y/N)");
                    opcion = scann.nextLine();
                    if (opcion.equalsIgnoreCase("y")) {
                        game.setEstaJugando(false);
                    }
                    break;
                default:
                    System.out.println("Entrada Inválida");
                    break;
            }
        }
    }
}
