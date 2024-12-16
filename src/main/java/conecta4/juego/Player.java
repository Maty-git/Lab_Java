package conecta4.juego;

public class Player {
    private int id;
    private String nombre;
    private String color;
    private int victoria;
    private int derrota;
    private int empate;
    private int fichas;

    public Player(int nId, int nVictoria, int nDerrota, int nEmpate, int nFichas) {
        this.id = nId;
        this.victoria = nVictoria;
        this.derrota = nDerrota;
        this.empate = nEmpate;
        this.fichas = nFichas;

    }

    public void setNombre(String nNombre) {
        this.nombre = nNombre;
    }

    public void setColor(String nColor) {
        this.color = nColor;
    }

}