package conecta4.juego.interfaces;

/**
 * Interfaz que define las operaciones básicas de un juego.
 *
 * Esta interfaz establece un contrato para cualquier clase que implemente un juego,
 * proporcionando un conjunto de métodos que deben ser implementados.
 */
public interface Gameinterfaz_21484373_RamirezMatias {

    /**
     * Muestra el historial de movimientos realizados en el juego.
     */
    void historial();

    /**
     * Verifica si el juego ha terminado en empate.
     *
     * @return true si el juego ha terminado en empate, false en caso contrario.
     */
    boolean esEmpate();

    /**
     * Actualiza las estadísticas de los jugadores.
     *
     * @param ganador El carácter que representa al jugador ganador ('R' o 'A').
     */
    void actualizarStats(char ganador);

    /**
     * Obtiene el identificador del jugador actual.
     *
     * @return El identificador del jugador actual (1 o 2).
     */
    int jugadorActual();

    /**
     * Muestra el estado actual del tablero de juego.
     */
    void mostrarTablero();

    /**
     * Finaliza el juego y muestra el resultado.
     *
     * @param ganador El carácter que representa al jugador ganador ('R' o 'A'),
     *                '0' en caso de empate.
     */
    void endGame(char ganador);

    /**
     * Realiza un movimiento en el juego.
     */
    void realizarMovimiento();
}
