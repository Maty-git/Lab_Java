package conecta4.juego;
import java.util.ArrayList;
import java.util.List;

public class Tableroc4 implements Board {
    private List<List<Character>> tablero;


    public Tableroc4(int filas, int columnas) {
        tablero = new ArrayList<>(filas);

        for (int i = 0; i < filas; i++) {
            List<Character> row = new ArrayList<>(columnas);
            for (int j = 0; j < columnas; j++) {
                row.add('_');
            }
            tablero.add(row);
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (List<Character> row : tablero) {
            sb.append("[");
            for (Character cell : row) {
                sb.append(cell).append(",");
            }
            sb.deleteCharAt(sb.length() - 1); // Eliminar la coma extra
            sb.append("]\n");
        }
        return sb.toString();
    }

    @Override
    public boolean canPlay() {
        char c = '_';
        for(List<Character> fila : tablero){
            for(char caracterFila: fila){
                if(caracterFila == c){
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public void ponerPieza(int columna, char carac) {
        columna = columna -1;
        for(int i = tablero.size() -1 ; i > -1 ; i--){
            List<Character> fila = tablero.get(i);
            if(fila.get(columna).equals('_')){
                fila.set(columna, carac);
            }
        }
        System.out.println("No Se Puede Jugar En Esta Columna");
    }

    @Override
    public void vertical() {

    }

    @Override
    public void horizontal() {

    }

    @Override
    public void diagonal() {

    }

    @Override
    public void quienGana() {

    }

}