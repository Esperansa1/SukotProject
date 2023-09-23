package Game;

import java.util.ArrayList;

public class BoardManager {

    private static final int BOARD_SIZE = 10;
    private BaseEntity[][] board;

    public BoardManager() {
        this.board = new BaseEntity[BOARD_SIZE][BOARD_SIZE];
    }

    public BaseEntity[][] getBoard() {
        return board;
    }

    public void updateBoard(ArrayList<BaseEntity> entities){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new BaseEntity(new Position(i,j), "EMPTY", "---");
            }
        }

        for (int i = 0; i < entities.size(); i++) {
            BaseEntity currentEntity = entities.get(i);
            int x = currentEntity.getPosition().getX();
            int y = currentEntity.getPosition().getY();
            board[y][x] = currentEntity;
        }




    }


}
