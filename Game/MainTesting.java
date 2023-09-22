package Game;

public class MainTesting {

    public static void main(String[] args) {

        PlayerHandler playerHandler = new PlayerHandler(4);

        playerHandler.addPlayer(new Player("Esperansa"));
        playerHandler.addPlayer(new Player("Eli"));
        playerHandler.addPlayer(new Player("Trilili"));
        playerHandler.addPlayer(new Player("Roi"));

        for (int i = 0; i < playerHandler.getPlayerAmount(); i++) {
            System.out.println(playerHandler.getNextPlayer());
        }

    }

}
