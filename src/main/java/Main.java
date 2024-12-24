import conecta4.Game;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String opcion = "";


        Game game = null;
        while(!opcion.equals("1")){
            Scanner scann = new Scanner(System.in);
            System.out.println("********** BIENVENIDO A CONECTA 4 ***************\n");
            System.out.println("SELECCIONE UNA OPCION:\n");
            System.out.println("1- Crear Un Nuevo Juego.\n");
            System.out.println("2- Ver Estado Actual.\n");
            System.out.println("3- Realizar Jugada.\n");
            System.out.println("4- Ver Estadisticas Generales.\n");
            System.out.println("5- Salir Del Juego.\n");
            opcion = scann.nextLine();
            switch (opcion){
                case "1":
                    game = new Game();
                    break;
                case "2":
                    //mostrar estado
                    System.out.println("NO SE PUEDE MOSTRAR EL ESTADO DEL JUEGO PORQUE AUN NO A SIDO CREADO \n PRESIONE LA OPCION 1 PARA CREAR UN NUEVO JUEGO");
                    break;
                case "3":
                    //jugar
                    System.out.println("NO SE PUEDE JUGAR, EL JUEGO AUN NO A SIDO CREADO \n PRESIONE LA OPCION 1 PARA CREAR UN NUEVO JUEGO");
                    break;
                case "4":
                    //ver stats
                    System.out.println("NO SE PUEDEN VER LAS ESTADISTICAS, EL JUEGO AUN NO SE A CREADO \n PRESIONE LA OPCION 1 PARA CREAR UN NUEVO JUEGO");
                    break;
                case "5":
                    game = new Game(false);
                    game.setEstaJugando(false);
                    opcion = "1";
                    break;
                default:
                    System.out.println("Entrada Invalida");
                    break;
            }
        }

        while(game.isEstaJugando()){
            Scanner scann = new Scanner(System.in);
            System.out.println("********** BIENVENIDO A CONECTA 4 ***************\n");
            System.out.println("SELECCIONE UNA OPCION:\n");
            System.out.println("1- Crear Un Nuevo Juego.\n");
            System.out.println("2- Ver Estado Actual.\n");
            System.out.println("3- Realizar Jugada.\n");
            System.out.println("4- Ver Estadisticas Generales.\n");
            System.out.println("5- Salir Del Juego.\n");
            opcion = scann.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("ya existe un juego en curso finalice el juego para poder volver a jugar");
                    break;
                case "2":
                    //mostrar estado
                    System.out.println("***** TABLERO ACTUAL *****");
                    game.mostrarTablero();
                    break;
                case "3":
                    //jugar
                    game.realizarMovimiento();
                    break;
                case "4":
                    //ver stats
                    String stats =
                            "***** Estadisticas Actuales *****\n" +
                            "Player 1: \n" +
                            game.getPlayer1().getNombre() + " Color: " + game.getPlayer1().getColor() + " " + game.getPlayer1().getStats() + "\n" +
                            "Player 2: \n" +
                            game.getPlayer2().getNombre() + "Color: " + game.getPlayer2().getColor() + " " + game.getPlayer2().getStats();
                    System.out.println(stats);
                    break;
                case "5":
                    game.setEstaJugando(false);
                    break;
                default:
                    System.out.println("Entrada Invalida");
                    break;
            }
        }


    }
}