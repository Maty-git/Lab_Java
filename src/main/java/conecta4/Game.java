package conecta4;

import conecta4.juego.Player;
import conecta4.juego.Tableroc4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {


    private List<String> historial;
    private int turnoActual;
    private Player player1;
    private Player player2;
    private Tableroc4 tablero;

    public Game(){
        Scanner scanner = new Scanner(System.in);
        //crear juego;
        System.out.println("******* Creando Jugador 1 *******");
        this.player1 = new Player(1,0,0,0,21);
        System.out.println("******* Creando Jugador 2 *******");
        this.player2 = new Player(2, 0,0,0,21);
        System.out.println("Defina El Numero De Fichas: ");
        int fichas = scanner.nextInt();
        player1.setFichas(fichas);
        player2.setFichas(fichas);
        System.out.println(player1.toString());
        System.out.println(player2.toString());
        System.out.println("Juego Creado Exitosamente");
        this.historial = new ArrayList<>();
        this.tablero = new Tableroc4(6,7);
        System.out.println("*******Tablero Nuevo*****");
        System.out.println(tablero.toString());
        this.turnoActual = 1;
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

    public void addHistorial(int columna, String color){
        String text = "Se Coloca La Ficha " +  color + " En Columna " + columna;
        historial.add(text);
    }

    public boolean esEmpate(){

        if(!tablero.canPlay() && player1.getPieza() == 0 && player2.getPieza() == 0){
            return true;
        }else{
            return false;
        }
    }

    public void actualizarStats(char ganador){
        if(ganador == player1.getPieza()){

        }
    }
}
