package Game;


import Entities.Player;
import Entities.Position;

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
        updateAndPrintGameState();
        stepGame();
    }

    private void stepGame(){
        moveCurrentPlayer();
        playerHandler.getNextPlayer();

        if(playerHandler.isGameOver()){
            GameConsole.printGameOverMessage(playerHandler.getCurrentPlayer());
        }else{
            updateAndPrintGameState();
        }
    }

    private void moveCurrentPlayer(){
        Player currentPlayer = playerHandler.getCurrentPlayer();

        Position previousPosition = currentPlayer.getPosition();
        do {
            char wantedMovement = GameConsole.askForPlayerMovement();
            currentPlayer.attemptMove(boardManager, playerHandler, wantedMovement);
            if(currentPlayer.getPosition().equals(previousPosition)){
                GameConsole.printInvalidMovementMessage();
            }
        }while(currentPlayer.getPosition().equals(previousPosition));
    }



    private void updateAndPrintGameState()
    {
        boardManager.updateBoard();
        GameConsole.printGameState(boardManager.getBoard());
        stepGame();
    }





}
