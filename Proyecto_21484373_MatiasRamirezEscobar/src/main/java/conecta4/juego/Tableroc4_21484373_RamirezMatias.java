package conecta4.juego;

import conecta4.juego.interfaces.Board_21484373_RamirezMatias;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>CLASE TABLERO</h1>
 * Clase que representa el tablero del juego Conecta 4.
 * Implementa las funcionalidades de un tablero donde se pueden colocar piezas
 * y verificar condiciones de victoria.
 */
public class Tableroc4_21484373_RamirezMatias implements Board_21484373_RamirezMatias {
    private List<List<Character>> tablero;

    /**
     * <h1>CONSTRUCTOR</h1>
     * Constructor que inicializa el tablero con las dimensiones especificadas.
     *
     * @param filas    Número de filas del tablero.
     * @param columnas Número de columnas del tablero.
     */
    public Tableroc4_21484373_RamirezMatias(int filas, int columnas) {
        tablero = new ArrayList<>(filas);

        for (int i = 0; i < filas; i++) {
            List<Character> row = new ArrayList<>(columnas);
            for (int j = 0; j < columnas; j++) {
                row.add('_'); // Inicializa cada celda como vacía ('_').
            }
            tablero.add(row);
        }
    }

    /**
     * <h1>TABLERO COMO STRING</h1>
     * Representa el estado actual del tablero en formato de cadena.
     *
     * @return Una representación del tablero en formato String.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Character> row : tablero) {
            sb.append("[ ");
            for (Character cell : row) {
                sb.append(cell).append(" | ");
            }
            sb.deleteCharAt(sb.length() - 2); // Elimina el último separador.
            sb.append("]\n");
        }
        return sb.toString();
    }

    /**
     * <h1>SE PUEDE JUGAR</h1>
     * Verifica si hay posiciones disponibles para jugar.
     *
     * @return true si hay posiciones vacías ('_'), false en caso contrario.
     */
    @Override
    public boolean canPlay() {
        char c = '_';
        for (List<Character> fila : tablero) {
            for (char caracterFila : fila) {
                if (caracterFila == c) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * <h1>COLOCAR PIEZA</h1>
     * Coloca una pieza en la columna especificada.
     *
     * @param columna indice de la columna donde se quiere colocar la pieza (1 a n).
     * @param carac  Caracter que representa la pieza del jugador.
     */
    @Override
    public void ponerPieza(int columna, char carac) {
        boolean logrado = false;
        columna = columna - 1; // Ajustar índice a base 0.
        for (int i = 5; i > -1; i--) {
            List<Character> fila = tablero.get(i);
            if (fila.get(columna).equals('_')) {
                fila.set(columna, carac);
                logrado = true;
                break;
            }
        }
        if (!logrado) {
            System.out.println("No se puede jugar en esta columna.");
        }
    }

    /**
     * <h1>GANADOR VERTICAL</h1>
     * Verifica si hay un ganador vertical.
     *
     * @return Caracter del jugador ganador o '0' si no hay ganador.
     */
    @Override
    public char vertical() {
        char car;
        for (int i = 5; i >= 3; i--) {
            List<Character> fila = tablero.get(i);
            List<Character> fila2 = tablero.get(i - 1);
            List<Character> fila3 = tablero.get(i - 2);
            List<Character> fila4 = tablero.get(i - 3);
            for (int j = 6; j > -1; j--) {
                car = fila.get(j);
                if (car != '_' && fila2.get(j) == car && fila3.get(j) == car && fila4.get(j) == car) {
                    return car;
                }
            }
        }
        return '0';
    }

    /**
     * <h1>GANADOR HORIZONTAL</h1>
     * Verifica si hay un ganador horizontal.
     *
     * @return Caracter del jugador ganador o '0' si no hay ganador.
     */
    @Override
    public char horizontal() {
        char car, car2, car3, car4;
        for (int i = 5; i >= 3; i--) {
            List<Character> fila = tablero.get(i);
            for (int j = 6; j >= 3; j--) {
                car = fila.get(j);
                car2 = fila.get(j - 1);
                car3 = fila.get(j - 2);
                car4 = fila.get(j - 3);
                if ((car == car2 && car2 == car3 && car3 == car4) && car != '_') {
                    return car;
                }
            }
        }
        return '0';
    }

    /**
     * <h1>GANADOR VERTICAL</h1>
     * Verifica si hay un ganador diagonal (ascendente o descendente).
     *
     * @return Caracter del jugador ganador o '0' si no hay ganador.
     */
    @Override
    public char diagonal() {
        char car, car2, car3, car4;

        // Diagonal ascendente
        for (int i = 0; i <= 2; i++) {
            List<Character> fila = tablero.get(i);
            List<Character> fila2 = tablero.get(i + 1);
            List<Character> fila3 = tablero.get(i + 2);
            List<Character> fila4 = tablero.get(i + 3);
            for (int j = 0; j <= 3; j++) {
                car = fila.get(j);
                car2 = fila2.get(j + 1);
                car3 = fila3.get(j + 2);
                car4 = fila4.get(j + 3);
                if ((car == car2 && car2 == car3 && car3 == car4) && car != '_') {
                    return car;
                }
            }
        }

        // Diagonal descendente
        for (int i = 0; i <= 2; i++) {
            List<Character> fila = tablero.get(i);
            List<Character> fila2 = tablero.get(i + 1);
            List<Character> fila3 = tablero.get(i + 2);
            List<Character> fila4 = tablero.get(i + 3);
            for (int j = 6; j >= 3; j--) {
                car = fila.get(j);
                car2 = fila2.get(j - 1);
                car3 = fila3.get(j - 2);
                car4 = fila4.get(j - 3);
                if ((car == car2 && car2 == car3 && car3 == car4) && car != '_') {
                    return car;
                }
            }
        }
        return '0';
    }

    /**
     * <h1>GANADOR</h1>
     * Determina el ganador del juego verificando todas las direcciones posibles.
     *
     * @return Caracter del jugador ganador o '0' si no hay ganador.
     */
    @Override
    public char quienGana() {
        char ganadorV = vertical();
        if (ganadorV != '0') {
            return ganadorV;
        }

        char ganadorH = horizontal();
        if (ganadorH != '0') {
            return ganadorH;
        }

        return diagonal();
    }

    /**
     * <h1>RESET TABLERO</h1>
     * Reinicia el tablero, dejándolo vacío con todas las posiciones en '_'.
     */
    public void resetearTablero() {
        for (List<Character> fila : tablero) {
            fila.replaceAll(ignored -> '_');
        }
        System.out.println("El tablero ha sido reiniciado.");
    }
}
