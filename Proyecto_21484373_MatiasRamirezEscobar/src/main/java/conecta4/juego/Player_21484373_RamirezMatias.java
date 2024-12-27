package conecta4.juego;

import java.util.Scanner;

/**
 * <h1>CLASE PLAYER</h1>
 * Clase que representa un jugador en el juego Conecta 4.
 * Contiene información sobre el nombre, color, estadísticas y fichas del jugador.
 */
public class Player_21484373_RamirezMatias {
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
     * <h1>CONSTRUCTOR</h1>
     * Constructor que inicializa un jugador con un ID, estadísticas iniciales y fichas asignadas.
     * Se solicita el nombre del jugador y se asigna un color basado en el ID.
     *
     * @param nId       ID del jugador (1 o 2).
     * @param nVictoria Número inicial de victorias.
     * @param nDerrota  Número inicial de derrotas.
     * @param nEmpate   Número inicial de empates.
     * @param nFichas   Número inicial de fichas asignadas al jugador.
     */
    public Player_21484373_RamirezMatias(int nId, int nVictoria, int nDerrota, int nEmpate, int nFichas) {
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
     * <h1>SETTER DE FICHAS</h1>
     * Establece el número de fichas del jugador.
     *
     * @param fichas Número de fichas a asignar.
     */
    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    /**
     * <h1>GETTER PIEZA</h1>
     * Obtiene el carácter que representa la pieza del jugador.
     *
     * @return El carácter asociado al color del jugador.
     */
    public char getPieza() {
        return pieza;
    }

    /**
     * <h1>SUMA UNA VICTORIA</h1>
     * Incrementa en 1 el contador de victorias del jugador.
     */
    public void sumarVictoria() {
        this.victoria = this.victoria + 1;
    }

    /**
     * <h1>SUMA UNA DERROTA</h1>
     * Incrementa en 1 el contador de derrotas del jugador.
     */
    public void sumarDerrota() {
        this.derrota = this.derrota + 1;
    }

    /**
     * <h1>SUMA A EMPATE</h1>
     * Incrementa en 1 el contador de empates del jugador.
     */
    public void sumarEmpate() {
        this.empate = this.empate + 1;
    }

    /**
     * <h1>GETTER ID</h1>
     * Obtiene el ID del jugador.
     *
     * @return El ID del jugador.
     */
    public int getId() {
        return id;
    }

    /**
     * <h1>RESTA UNA FICHA POR TURNO</h1>
     * Reduce en 1 el número de fichas disponibles para el jugador.
     */
    public void restarFicha() {
        this.fichas = this.fichas - 1;
    }

    /**
     * <h1>GETTER FICHA</h1>
     * Obtiene el número de fichas restantes del jugador.
     *
     * @return Número de fichas restantes.
     */
    public int getFichas() {
        return fichas;
    }

    /**
     * GETTER DE NOMBRE
     * Obtiene el nombre del jugador.
     *
     * @return Nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <h1>GETTER DE COLOR</h1>
     * Obtiene el color asignado al jugador.
     *
     * @return El color del jugador.
     */
    public String getColor() {
        return color;
    }

    /**
     * <h1>TRANSFORMA LAS STATS EN UN STRING</h1>
     * Obtiene las estadísticas del jugador en formato de texto.
     *
     * @return Una cadena que incluye victorias, derrotas, empates y fichas restantes.
     */
    public String getStats() {
        return "Victorias: " + victoria + " Derrotas: " + derrota + " Empates: " + empate + " Fichas restantes: " + fichas;
    }

    /**
     * <h1>resetea las fichas</h1>
     * Restaura el número de fichas del jugador a su valor original.
     */
    public void resetearFichas() {
        this.fichas = this.fichasOriginales;
    }
}
