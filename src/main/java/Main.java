import conecta4.Game;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String opcion = "";


        Game game = null;
        while(!opcion.equals("1") || opcion.equals("5")){
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

                    break;
                case "3":
                    //jugar
                    break;
                case "4":
                    //ver stats
                    break;
                case "5":
                    if(game == null){
                        game = new Game(false);
                    }
                    game.setEstaJugando(false);
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
                    System.out.println("ya existe un juego en curso");

                    break;
                case "2":
                    //mostrar estado

                    break;
                case "3":
                    //jugar


                    System.out.println(game.getTablero().toString());
                    if(game.getTablero().quienGana() != 0){
                        System.out.println(game.getTablero().quienGana());
                    }
                    break;
                case "4":
                    //ver stats
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