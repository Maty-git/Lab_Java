package conecta4.juego;
import java.util.ArrayList;
import java.util.List;
public class Board {
    private List<List<Character>> board;

    public Board(int rows, int cols) {
        board = new ArrayList<>(rows);

        for (int i = 0; i < rows; i++) {
            List<Character> row = new ArrayList<>(cols);
            for (int j = 0; j < cols; j++) {
                row.add('_');
            }
            board.add(row);
        }
    }
}
