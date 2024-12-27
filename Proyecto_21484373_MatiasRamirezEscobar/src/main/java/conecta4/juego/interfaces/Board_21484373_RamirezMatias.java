package conecta4.juego.interfaces;

/**
 * Interfaz que define las operaciones básicas de un tablero en el juego Conecta 4.
 * Proporciona métodos para verificar jugadas, colocar piezas y determinar el estado del juego.
 */
public interface Board_21484373_RamirezMatias {

    /**
     * Verifica si aún se pueden realizar jugadas en el tablero.
     *
     * @return true si hay posiciones disponibles para jugar, false en caso contrario.
     */
    boolean canPlay();

    /**
     * Coloca una pieza en una columna específica del tablero.
     *
     * @param columna indice de la columna donde se colocara la pieza (1 a n).
     * @param carac   Caracter que representa la pieza del jugador.
     */
    void ponerPieza(int columna, char carac);

    /**
     * Verifica si hay un ganador en dirección vertical.
     *
     * @return Caracter del jugador ganador ('R', 'A') o '0' si no hay ganador.
     */
    char vertical();

    /**
     * Verifica si hay un ganador en dirección horizontal.
     *
     * @return Caracter del jugador ganador ('R', 'A') o '0' si no hay ganador.
     */
    char horizontal();

    /**
     * Verifica si hay un ganador en dirección diagonal.
     *
     * @return Caracter del jugador ganador ('R', 'A') o '0' si no hay ganador.
     */
    char diagonal();

    /**
     * Determina el ganador del juego verificando todas las direcciones (vertical, horizontal y diagonal).
     *
     * @return Caracter del jugador ganador ('R', 'A') o '0' si no hay ganador.
     */
    char quienGana();
}
