package conecta4.juego;

import java.util.Scanner;

public class MenuInicio {
    // Crear variable de tipo Scanner para poder recoger informacion por terminal
    Scanner scanner = new Scanner(System.in);

    //construir un menu de inicio
    public MenuInicio() {
    }
    //metodo para ejecutar el menu
    public int ejecutarMenuInicio(){

        //Presentacion de un menu de conecta 4

        System.out.println("********** BIENVENIDO A CONECTA 4 ***************\n");
        System.out.println("SELECCIONE UNA OPCION:\n");
        System.out.println("1- Crear Un Nuevo Juego.\n");
        System.out.println("2- Ver Estado Actual.\n");
        System.out.println("3- Realizar Jugada.\n");
        System.out.println("4- Ver Estadisticas Generales.\n");
        System.out.println("5- Salir Del Juego.\n");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion){
            case 1:
                //crear nuevo juego
                opcion = this.crearJuego();
                return opcion;
            case 2:
                //ver estado actual
                return 1;
            case 3:
                //hacer jugada
                return 1;
            case 4:
                //estadisticas
                return 1;
            case 5:
                System.out.println("Gracias Por Jugar Vuelve Pronto....");
                return 1;
            default:
                System.out.println("Opcion Ingresada Invalida");
                return 0;
        }
    }

    public int crearJuego(){
        System.out.println("******* Creando Jugador 1 *******");
        Player player1 = new Player(1,0,0,0,21);
        System.out.println("Ingrese El Nombre Del Jugador 1: ");
        String nombre1 = scanner.nextLine();
        player1.setNombre(nombre1);
        System.out.println("Ingrese El Color Para El Jugador 1: ");
        String color1 = scanner.nextLine();
        player1.setColor(color1);

        System.out.println("******* Creando Jugador 2 *******");
        Player player2 = new Player(2,0,0,0,21);
        System.out.println("Ingrese El Nombre Del Jugador 2: ");
        String nombre2 = scanner.nextLine();
        player2.setNombre(nombre2);
        System.out.println("Ingrese El Color Para El Jugador 2: ");
        String color2 = scanner.nextLine();
        player2.setColor(color2);



        return 1;
    }
}

