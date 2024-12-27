package conecta4;


import conecta4.juego.Player_21484373_RamirezMatias;
import conecta4.juego.Tableroc4_21484373_RamirezMatias;
import conecta4.juego.interfaces.Gameinterfaz_21484373_RamirezMatias;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>CLASE GAME (TDA)</h1>
 * Clase principal que coordina la lógica del juego Conecta 4.
 * Gestiona jugadores, tablero, turnos y estados del juego.
 */
public class Game_21484373_RamirezMatias implements Gameinterfaz_21484373_RamirezMatias {

    private boolean estaJugando;
    private List<String> historial;
    private int turnoActual;
    private Player_21484373_RamirezMatias player1;
    private Player_21484373_RamirezMatias player2;
    private Tableroc4_21484373_RamirezMatias tablero;

    /**
     * <h1>CONSTRUCTOR</h1>
     * Constructor principal de la clase Game.
     * Inicializa los jugadores, el tablero y las configuraciones iniciales.
     */
    public Game_21484373_RamirezMatias() {
        Scanner scanner = new Scanner(System.in);

        // Crear juego
        System.out.println(" ***** CREAR NUEVO JUEGO *****\n");
        this.estaJugando = true;

        System.out.println("******* Creando Jugador 1 *******");
        this.player1 = new Player_21484373_RamirezMatias(1, 0, 0, 0, 21);
        System.out.println(player1.toString());

        System.out.println("******* Creando Jugador 2 *******");
        this.player2 = new Player_21484373_RamirezMatias(2, 0, 0, 0, 21);
        System.out.println(player2.toString());

        // Definir número de fichas
        int fichas;
        do {
            System.out.print("Defina El Número De Fichas (4-21): ");
            fichas = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea sobrante
            if (fichas < 4 || fichas > 21) {
                System.out.println("Número de fichas no permitido. Por favor, elija un número entre 4 y 21.");
            }
        } while (fichas < 4 || fichas > 21);

        player1.setFichas(fichas);
        player2.setFichas(fichas);

        // Inicializar tablero y configuraciones
        this.historial = new ArrayList<>();
        this.tablero = new Tableroc4_21484373_RamirezMatias(6, 7);
        System.out.println("******* TABLERO NUEVO *****");
        System.out.println(tablero.toString());
        this.turnoActual = 0;
        System.out.println("* JUEGO CREADO EXITOSAMENTE *");

        System.out.println("Presiona cualquier tecla para comenzar a jugar....");
        scanner.nextLine(); // Esperar entrada del usuario
    }

    /**
     * <h1>ESTA JUGANDO?</h1>
     * Constructor alternativo.
     *
     * @param estaJugando Indica si el juego está en curso pero este siempre que inicie no estara en curso.
     */
    public Game_21484373_RamirezMatias(boolean estaJugando) {
        this.setEstaJugando(estaJugando);
    }

    /**
     * <h1>OBTENER PLAYER 1</h1>
     * Obtiene el primer jugador.
     *
     * @return Instancia de Player correspondiente al jugador 1.
     */
    public Player_21484373_RamirezMatias getPlayer1() {
        return player1;
    }

    /**
     * <h1>OBTENER PLAYER 2</h1>
     * Obtiene el segundo jugador.
     *
     * @return Instancia de Player correspondiente al jugador 2.
     */
    public Player_21484373_RamirezMatias getPlayer2() {
        return player2;
    }

    /**
     * <h1>AGREGAR AL HISTORIAL</h1>
     * Agrega un movimiento al historial del juego.
     *
     * @param columna Columna donde se colocó la ficha.
     * @param color   Color de la ficha colocada.
     */

    public void addHistorial(int columna, String color) {
        String text = "Se Coloca La Ficha " + color + " En Columna " + columna;
        historial.add(text);
    }

    /**
     * <h1>MOSTRAR HISTORIAL</h1>
     * muestra el historial de jugadas por consola
     *
     */
    @Override
    public void historial(){
        System.out.println("***** HISTORIAL DE JUGADAS *****");
        for (String jugada : historial) {
            System.out.println(jugada);
        }
    }

    /**
     * <h1>ES EMPATE?</h1>
     * Verifica si el juego ha terminado en empate.
     *
     * @return true si el juego está empatado, false en caso contrario.
     */
    @Override
    public boolean esEmpate() {
        return !tablero.canPlay() || (player1.getFichas() == 0 && player2.getFichas() == 0);
    }

    /**
     * <h1>ACTUALIZA SEGUN GANE PIERDA O EMPATE</h1>
     * Actualiza las estadísticas de los jugadores según el resultado del juego.
     *
     * @param ganador Caracter que indica el ganador ('R', 'A' o '0' para empate).
     */
    @Override
    public void actualizarStats(char ganador) {
        if (ganador == player1.getPieza()) {
            System.out.println("!! Player 1 ha Ganado !!");
            player1.sumarVictoria();
            player2.sumarDerrota();
        } else if (ganador == player2.getPieza()) {
            System.out.println("!! Player 2 ha Ganado !!");
            player2.sumarVictoria();
            player1.sumarDerrota();
        } else {
            System.out.println("Es un Empate");
            player1.sumarEmpate();
            player2.sumarEmpate();
        }
    }

    /**
     * <h1>INDICA QUIEN TIENE QUE JUGAR</h1>
     * Determina cuál jugador tiene el turno actual.
     *
     * @return 1 si es el turno del jugador 1, 2 si es el turno del jugador 2.
     */
    @Override
    public int jugadorActual() {
        return (getTurnoActual() % 2 == 0) ? 1 : 2;
    }

    /**
     * <h1>MUESTRA EL TABLERO</h1>
     * Muestra el estado actual del tablero.
     */
    @Override
    public void mostrarTablero() {
        System.out.println(" ***** ESTADO DEL TABLERO ACTUAL ***** ");
        System.out.println(tablero.toString());
    }

    /**
     * <h1>TERMINA EL JUEGO</h1>
     * Finaliza el juego, actualiza las estadísticas y muestra el historial de movimientos.
     *
     * @param ganador Caracter que indica el ganador ('R', 'A' o '0' para empate).
     */
    @Override
    public void endGame(char ganador) {
        actualizarStats(ganador);
        if (ganador != '0') {
            if(ganador == player1.getPieza()){
                System.out.println("¡Felicidades! El ganador es: " + player1.getNombre());
            }else{
                System.out.println("¡Felicidades! El ganador es: " + player2.getNombre());
            }
        } else {
            System.out.println("El juego ha terminado en empate.");
        }

        historial();
    }



    /**
     * <h1>PONE UNA PIEZA CON TODO LO QUE CONYEVA</h1>
     * Realiza un movimiento para el jugador actual y verifica las condiciones de victoria o empate.
     */
    @Override
    public void realizarMovimiento() {
        Scanner scann = new Scanner(System.in);
        int idBuscado = jugadorActual();

        if (idBuscado == player1.getId()) {
            if (player1.getFichas() > 0) {
                System.out.println("Turno de " + player1.getNombre() + " te quedan " + player1.getFichas() + " piezas");
                System.out.println(tablero.toString());
                System.out.print("Ingresa La columna En la que ira la ficha (1-7): ");
                int column = scann.nextInt();
                while(column<1 || column>7){
                    System.out.println("Entrada invalida ingrese nuevamente la columna");
                    System.out.print("Ingresa La columna En la que ira la ficha (1-7): ");
                    column = scann.nextInt();
                }
                tablero.ponerPieza(column, player1.getPieza());
                player1.restarFicha();
                addHistorial(column, player1.getColor());
            } else {
                System.out.println("Al jugador no le quedan fichas.");
            }
        } else {
            if (player2.getFichas() > 0) {
                System.out.println("Turno de " + player2.getNombre() + " te quedan " + player2.getFichas() + " piezas");
                System.out.println(tablero.toString());
                System.out.print("Ingresa La columna En la que ira la ficha (1-7): ");
                int column = scann.nextInt();
                tablero.ponerPieza(column, player2.getPieza());
                player2.restarFicha();
                addHistorial(column, player2.getColor());
            } else {
                System.out.println("Al jugador no le quedan fichas.");
            }
        }

        char car = tablero.quienGana();
        if (car != '0' || esEmpate()) {
            endGame(car);
        } else {
            setTurnoActual(getTurnoActual() + 1);
        }
    }

    /**
     * <h1>RESETEA PARA JUGAR DENUEVO</h1>
     * Reinicia el tablero y las fichas de los jugadores para comenzar un nuevo juego.
     */
    public void nuevoJuego() {
        tablero.resetearTablero();
        player1.resetearFichas();
        player2.resetearFichas();
        historial = new ArrayList<>();
        turnoActual = 0;
    }

    // Métodos de acceso y modificación
    public boolean isEstaJugando() {
        return estaJugando;
    }

    public void setEstaJugando(boolean estaJugando) {
        this.estaJugando = estaJugando;
    }

    public int getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }

    public Tableroc4_21484373_RamirezMatias getTablero() {
        return tablero;
    }
}
