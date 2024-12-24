package conecta4;

import conecta4.juego.Player;
import conecta4.juego.Tableroc4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private boolean estaJugando;
    private List<String> historial;
    private int turnoActual;
    private Player player1;
    private Player player2;
    private Tableroc4 tablero;

    public Game() {
        Scanner scanner = new Scanner(System.in);
        //crear juego;
        this.estaJugando = true;
        System.out.println("******* Creando Jugador 1 *******");
        this.player1 = new Player(1, 0, 0, 0, 21);
        System.out.println("******* Creando Jugador 2 *******");
        this.player2 = new Player(2, 0, 0, 0, 21);
        System.out.println("Defina El Numero De Fichas (4-21): ");
        int fichas = scanner.nextInt();
        player1.setFichas(fichas);
        player2.setFichas(fichas);
        System.out.println(player1.toString());
        System.out.println(player2.toString());
        System.out.println("Juego Creado Exitosamente");
        this.historial = new ArrayList<>();
        this.tablero = new Tableroc4(6, 7);
        System.out.println("*******Tablero Nuevo*****");
        System.out.println(tablero.toString());
        this.turnoActual = 0;
    }

    public Game(boolean estaJugando){
        this.setEstaJugando(estaJugando);
    }


    public Tableroc4 getTablero() {
        return tablero;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public List<String> getHistorial() {
        return historial;
    }

    public void addHistorial(int columna, String color) {
        String text = "Se Coloca La Ficha " + color + " En Columna " + columna;
        historial.add(text);
    }

    public boolean esEmpate() {
        return !tablero.canPlay() || (player1.getFichas() == 0 && player2.getFichas() == 0);
    }

    public void actualizarStats(char ganador) {
        if (ganador == player1.getPieza()) {
            System.out.println("!! Player 1 a Ganado !!");
            player1.sumarVictoria();
            player2.sumarDerrota();
        } else if (ganador == player2.getPieza()) {
            System.out.println("!! Player 2 a Ganado !!");
            player2.sumarVictoria();
            player1.sumarDerrota();
        } else {
            System.out.println("Es un Empate");
            player1.sumarEmpate();
            player2.sumarEmpate();
        }
    }

    public int jugadorActual() {
        return (getTurnoActual() % 2 == 0) ? 1 : 2;
    }

    public void mostrarTablero() {
        System.out.println("Estado Del Tablero Actual:");
        System.out.println(tablero.toString());
    }

    public void endGame(char ganador){
        actualizarStats(ganador);
        System.out.println(getHistorial());
    }

    public void realizarMovimiento(){
        Scanner scann = new Scanner(System.in);

        //primero deve de ver quien juega
        int idBuscado = jugadorActual();

        if(idBuscado == player1.getId()){
            if(player1.getFichas() >0){
                System.out.println("Ingresa La columna En la que ira la ficha:");
                int column = scann.nextInt();
                tablero.ponerPieza(column,player1.getPieza());
                player1.restarFicha();
                addHistorial(column,player1.getColor());
            }else {
                System.out.println("A el jugador no le quedan fichas");
            }
        }else {
            if(player2.getFichas() > 0){
                System.out.println("Ingresa La columna En la que ira la ficha:");
                int column = scann.nextInt();
                tablero.ponerPieza(column,player2.getPieza());
                player2.restarFicha();
                addHistorial(column,player2.getColor());
            }else {
                System.out.println("A el jugador no le quedan fichas");
            }
        }
        char car = tablero.quienGana();
        if(car != '0' || esEmpate()){
            endGame(car);
        }else {
            setTurnoActual(getTurnoActual() + 1 );
        }

    }

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

}
