package Game;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {

    private final int TREE_AMOUNT = 3;

    private PlayerHandler playerHandler;

    private ArrayList<BaseEntity> entities;
    private BoardManager boardManager;

    private static final Scanner reader = new Scanner(System.in);

    public GameController() {

        // Initializations
        int playerAmount = askForPlayerAmount();
        playerHandler = new PlayerHandler(playerAmount);
        setupPlayers();


        entities = new ArrayList<>();
        boardManager = new BoardManager();
        GameConsole.clearConsole();


        GenerateBoardEntities.spawnEntities(entities, playerHandler);
        boardManager.updateBoard(entities);
        GameConsole.printGameState(boardManager.getBoard());



    }

    public int askForPlayerAmount(){
        System.out.println("How many players do you want in the game?");
        return reader.nextInt();
    }

    public String askForPlayerName(){
        System.out.println("Enter player name:");
        return reader.next();
    }

    public void setupPlayers() {

        for (int i = 0; i < playerHandler.getPlayerAmount(); i++) {
            String playerName = askForPlayerName();
            playerHandler.addPlayer(new Player(playerName));
        }
    }
}
