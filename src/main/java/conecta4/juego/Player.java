package conecta4.juego;

import java.util.Scanner;

public class Player {
    private int id;
    private String nombre;
    private String color;
    private int victoria;
    private int derrota;
    private int empate;
    private int fichas;
    private char pieza;

    public Player(int nId, int nVictoria, int nDerrota, int nEmpate, int nFichas) {
        Scanner scanner = new Scanner(System.in);
        this.id = nId;
        System.out.println("Ingrese El Nombre Del Jugador "+ nId + " :");
        this.nombre = scanner.nextLine();
        System.out.println("Ingrese El Color Del Jugador "+ nId + " :");
        this.color = scanner.nextLine();
        this.victoria = nVictoria;
        this.derrota = nDerrota;
        this.empate = nEmpate;
        this.fichas = nFichas;
        this.pieza = color.charAt(0);


    }

    @Override
    public String toString() {
        return " El Player " + id +
                " " + nombre + " Fue Creado Exitosamente";
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public char getPieza() {
        return pieza;
    }

    public void sumarVictoria(){
        this.victoria = this.victoria + 1;
    }
    public void sumarDerrota(){
        this.derrota = this.derrota +1;
    }
    public void sumarEmpate(){
        this.empate = this.empate +1;
    }

    public int getId() {
        return id;
    }

    public void restarFicha(){
        this.fichas = this.fichas -1;
    }

    public int getFichas() {
        return fichas;
    }
}