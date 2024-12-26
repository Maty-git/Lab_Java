package conecta4.juego.interfaces;

public interface Gameinterfaz {
    void historial();

    boolean esEmpate();

    void actualizarStats(char ganador);

    int jugadorActual();

    void mostrarTablero();

    void endGame(char ganador);

    void realizarMovimiento();
}
