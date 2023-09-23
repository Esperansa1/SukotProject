package Game;


import Entities.Player;

public class GameController {

    private PlayerHandler playerHandler;
    private BoardManager boardManager;

    final int TREE_AMOUNT = 3;
    final int WEAPON_AMOUNT = 6;

    public GameController() {

        // Initializations
        playerHandler = new PlayerHandler();
        playerHandler.initialize();

        int entitiesAmount = playerHandler.getPlayerAmount() + TREE_AMOUNT + WEAPON_AMOUNT;
        boardManager = new BoardManager(entitiesAmount);
        boardManager.spawnEntities(playerHandler, TREE_AMOUNT, WEAPON_AMOUNT);

        stepGame();
    }

    private void stepGame(){

        updateAndPrintGameState();

        Player currentPlayer = playerHandler.getCurrentPlayer();
        char wantedMovement = GameConsole.askForPlayerMovement();

        switch (Character.toUpperCase(wantedMovement)) {
            case 'L' -> currentPlayer.attemptMoveLeft(boardManager);
            case 'R' -> currentPlayer.attemptMoveRight(boardManager);
            case 'U' -> currentPlayer.attemptMoveUp(boardManager);
            case 'D' -> currentPlayer.attemptMoveDown(boardManager);
        }
        updateAndPrintGameState();

    }



    private void updateAndPrintGameState()
    {
        boardManager.updateBoard();
        GameConsole.printGameState(boardManager.getBoard());
    }
}
