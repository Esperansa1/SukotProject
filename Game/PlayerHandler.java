package Game;

import Entities.Player;

public class PlayerHandler {


    private Player[] players;
    private int currentPlayerIndex;

    public PlayerHandler() { }

    public void initialize(){
        int playerAmount = GameConsole.askForPlayerAmount();
        initializePlayersArray(playerAmount);
    }

    public int getEmptyPlayerPosition(){
        for (int i = 0; i < players.length; i++) {
            if(players[i] == null){
                return i;
            }
        }
        return -1;
    }

    public void addPlayer(Player player) {
        int emptyPosition = getEmptyPlayerPosition();
        if(emptyPosition != -1) {
            players[emptyPosition] = player;
        }
        else System.out.println("Array is full");
    }

    public void addPlayer(String name, String icon) {
        Player player = new Player(name, icon);
        addPlayer(player);
    }

    public Player getNextPlayer(){ // Might change to linked list to make more efficient (O(1))
        if(this.players.length == 0) return null;
        if(currentPlayerIndex == this.players.length - 1) {
            currentPlayerIndex = 0;
            return players[currentPlayerIndex]; // returns the first player in the array
        } // Reset the circle
        currentPlayerIndex++;
        return this.players[currentPlayerIndex];
    }

    public Player getCurrentPlayer(){
        return this.players[currentPlayerIndex];
    }

    public void removePlayer(Player unwantedPlayer) {

        if(this.players.length == 0) return;
        Player[] playerCopy = new Player[this.players.length - 1];

        int k = 0;
        for (Player player : players) {
            if (!player.equals(unwantedPlayer)) {
                playerCopy[k] = player;
                k++;
            }
        }
        players = playerCopy;
        if(currentPlayerIndex >= 0)
            currentPlayerIndex--;
    }

    public int getPlayerAmount(){
        return this.players.length;
    }


    public void initializePlayersArray(int playerAmount) {
        players = new Player[playerAmount];
        for (int i = 0; i < playerAmount; i++) {
            String playerName = GameConsole.askForPlayerName();
            Player newPlayer = new Player(playerName);
            addPlayer(newPlayer);
            GameConsole.printPlayerDetails(newPlayer);
        }
    }

    public boolean isGameOver(){
        return getPlayerAmount() <= 1;
    }

}
