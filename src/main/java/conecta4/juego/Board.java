package conecta4.juego;

public interface Board {
    public boolean canPlay();

    public void ponerPieza(int columna, char carac);

    public void vertical();
    public void horizontal();
    public void diagonal();
    public void quienGana();
}
