package Game;

public class Board {

    private static final int BOARD_SIZE = 10;

    public enum Entities {EMPTY, PLAYER, TREE, WEAPON}
    private Entities[][] board;

    public Board() {
        this.board = new Entities[BOARD_SIZE][BOARD_SIZE];
    }

    public Entities getEntity(int x, int y) {
        return board[x][y];
    }

    public Entities[][] getBoard() {
        return board;
    }
}
