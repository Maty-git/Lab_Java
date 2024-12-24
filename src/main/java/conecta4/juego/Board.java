package conecta4.juego;

public interface Board {
    boolean canPlay();

    void ponerPieza(int columna, char carac);

    char vertical();
    char horizontal();
    char diagonal();
    char quienGana();
}
