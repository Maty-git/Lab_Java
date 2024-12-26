package conecta4.juego;

import java.util.Scanner;

/**
 * Clase que representa un jugador en el juego Conecta 4.
 * Contiene información sobre el nombre, color, estadísticas y fichas del jugador.
 */
public class Player {
    private int fichasOriginales;
    private int id;
    private String nombre;
    private String color;
    private int victoria;
    private int derrota;
    private int empate;
    private int fichas;
    private char pieza;

    /**
     * Constructor que inicializa un jugador con un ID, estadísticas iniciales y fichas asignadas.
     * Se solicita el nombre del jugador y se asigna un color basado en el ID.
     *
     * @param nId       ID del jugador (1 o 2).
     * @param nVictoria Número inicial de victorias.
     * @param nDerrota  Número inicial de derrotas.
     * @param nEmpate   Número inicial de empates.
     * @param nFichas   Número inicial de fichas asignadas al jugador.
     */
    public Player(int nId, int nVictoria, int nDerrota, int nEmpate, int nFichas) {
        Scanner scanner = new Scanner(System.in);
        this.id = nId;
        System.out.print("Ingrese El Nombre Del Jugador " + nId + " : ");
        this.nombre = scanner.nextLine();
        if (nId == 1) {
            this.color = "Rojo";
        } else {
            this.color = "Amarillo";
        }
        System.out.println("Color Asignado: " + color);
        this.victoria = nVictoria;
        this.derrota = nDerrota;
        this.empate = nEmpate;
        this.fichas = nFichas;
        this.fichasOriginales = nFichas;
        this.pieza = color.charAt(0); // Usa la primera letra del color como representación de la pieza.
    }

    /**
     * Representación textual del jugador.
     *
     * @return Un mensaje indicando que el jugador fue creado exitosamente.
     */
    @Override
    public String toString() {
        return "El Player " + id + " " + nombre + " Fue Creado Exitosamente";
    }

    /**
     * Establece el número de fichas del jugador.
     *
     * @param fichas Número de fichas a asignar.
     */
    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    /**
     * Obtiene el carácter que representa la pieza del jugador.
     *
     * @return El carácter asociado al color del jugador.
     */
    public char getPieza() {
        return pieza;
    }

    /**
     * Incrementa en 1 el contador de victorias del jugador.
     */
    public void sumarVictoria() {
        this.victoria = this.victoria + 1;
    }

    /**
     * Incrementa en 1 el contador de derrotas del jugador.
     */
    public void sumarDerrota() {
        this.derrota = this.derrota + 1;
    }

    /**
     * Incrementa en 1 el contador de empates del jugador.
     */
    public void sumarEmpate() {
        this.empate = this.empate + 1;
    }

    /**
     * Obtiene el ID del jugador.
     *
     * @return El ID del jugador.
     */
    public int getId() {
        return id;
    }

    /**
     * Reduce en 1 el número de fichas disponibles para el jugador.
     */
    public void restarFicha() {
        this.fichas = this.fichas - 1;
    }

    /**
     * Obtiene el número de fichas restantes del jugador.
     *
     * @return Número de fichas restantes.
     */
    public int getFichas() {
        return fichas;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return Nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el color asignado al jugador.
     *
     * @return El color del jugador.
     */
    public String getColor() {
        return color;
    }

    /**
     * Obtiene las estadísticas del jugador en formato de texto.
     *
     * @return Una cadena que incluye victorias, derrotas, empates y fichas restantes.
     */
    public String getStats() {
        return "Victorias: " + victoria + " Derrotas: " + derrota + " Empates: " + empate + " Fichas restantes: " + fichas;
    }

    /**
     * Restaura el número de fichas del jugador a su valor original.
     */
    public void resetearFichas() {
        this.fichas = this.fichasOriginales;
    }
}
