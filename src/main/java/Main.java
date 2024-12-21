import conecta4.Game;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String opcion = "";
        boolean estaJugando = true;
        boolean juegoCreado = false;

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
                   if (!juegoCreado) {
                       game = new Game();
                       juegoCreado = true;
                   } else {
                       System.out.println("ya existe un juego en curso");
                   }
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
                   estaJugando = false;
                   break;
               default:
                   System.out.println("Entrada Invalida");
                   break;
           }
       }

        while(estaJugando){
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

                    int column = scann.nextInt();
                    game.getTablero().ponerPieza(column,game.getPlayer1().getPieza());
                    System.out.println(game.getTablero().toString());
                    break;
                case "4":
                    //ver stats
                    break;
                case "5":
                    estaJugando = false;
                    break;
                default:
                    System.out.println("Entrada Invalida");
                    break;
            }
        }


    }
}