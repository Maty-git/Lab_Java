package conecta4.juego;

public class Pieza {
    private char pieza;

    public Pieza(String color){
        this.pieza = color.charAt(0);
    }

    public char getPieza() {
        return pieza;
    }

    public void setPieza(char pieza) {
        this.pieza = pieza;
    }
}
