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
        for(int i = 5 ; i > -1 ; i--){
            List<Character> fila = tablero.get(i);
            if(fila.get(columna).equals('_')){
                fila.set(columna, carac);
                i = -1;
                break;
            }
        }
        System.out.println("No Se Puede Jugar En Esta Columna");
    }

    @Override
    public char vertical() {
        char car;
        for(int i = 5 ; i>=3 ; i--){
            List<Character> fila = tablero.get(i);
            List<Character> fila2 = tablero.get(i-1);
            List<Character> fila3 = tablero.get(i-2);
            List<Character> fila4 = tablero.get(i-3);
            for(int j = 6; j>-1; j--){
                car = fila.get(j);
                if(car != '_' && fila2.get(j) == car && fila3.get(j) == car && fila4.get(j) == car){
                    return car;
                }
            }
        }
        car = '0';
        return car;
    }


    @Override
    public char horizontal() {
        char car, car2,car3,car4;
        for(int i = 5; i>= 3; i--){
            List<Character> fila = tablero.get(i);
            for(int j = 6; j>=3; j--){
                car = fila.get(j);
                car2 = fila.get(j-1);
                car3 = fila.get(j-2);
                car4 = fila.get(j-3);
                if((car == car2 && car2 == car3 && car3 == car4) && car != '_'){
                    return car;
                }
            }
        }
        car = '0';
        return car;
    }

    @Override
    public char diagonal() {
        char car,car2,car3,car4;

        for(int i = 0; i <= 2; i++ ){
            List<Character> fila = tablero.get(i);
            List<Character> fila2 = tablero.get(i+1);
            List<Character> fila3 = tablero.get(i+2);
            List<Character> fila4 = tablero.get(i+3);
            for(int j = 0; j <= 3; j++){
                car = fila.get(j);
                car2 = fila2.get(j+1);
                car3 = fila3.get(j+2);
                car4 = fila4.get(j+3);
                if((car == car2 && car2 == car3 && car3 == car4) && car != '_'){
                    return car;
                }
            }
        }
        for(int i = 0; i <=2; i++){
            List<Character> fila = tablero.get(i);
            List<Character> fila2 = tablero.get(i+1);
            List<Character> fila3 = tablero.get(i+2);
            List<Character> fila4 = tablero.get(i+3);
            for (int j = 6; j>=3 ; j--){
                car = fila.get(j);
                car2 = fila2.get(j-1);
                car3 = fila3.get(j-2);
                car4 = fila4.get(j-3);
                if((car == car2 && car2 == car3 && car3 == car4) && car != '_'){
                    return car;
                }
            }
        }
        car = '0';
        return car;
    }

    @Override
    public char quienGana() {
        // Verificar ganador vertical
        char ganadorV = vertical();
        if (ganadorV != '0') {
            return ganadorV;
        }

        // Verificar ganador horizontal
        char ganadorH = horizontal();
        if (ganadorH != '0') {
            return ganadorH;
        }

        // Verificar ganador diagonal
        char ganadorD = diagonal();
        if (ganadorD != '0') {
            return ganadorD;
        }
        // Si no hay ganador, devolver '0'
        return '0';
    }


}