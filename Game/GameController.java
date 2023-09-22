package Game;

import java.util.Scanner;

public class GameController {

    PlayerHandler playerHandler;

    private static final Scanner reader = new Scanner(System.in);

    public GameController() {
        int playerAmount = askForPlayerAmount();
        playerHandler = new PlayerHandler(playerAmount);

    }

    public int askForPlayerAmount(){
        System.out.println("How many players do you want in the game?");
        return reader.nextInt();
    }

    public String askForPlayerName(){
        System.out.println("How many players do you want in the game?");
        return reader.next();
    }

    public void setupPlayers() {
        for (int i = 0; i < playerHandler.getPlayerAmount(); i++) {
            String playerName = askForPlayerName();
            playerHandler.addPlayer(new Player(playerName));
        }
    }
}
