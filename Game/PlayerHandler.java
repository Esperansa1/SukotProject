package Game;

public class PlayerHandler {

    private Player[] players;
    private int currentPlayerIndex;

    public PlayerHandler(int playerAmount) {
        this.players = new Player[playerAmount];
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
            System.out.println("Added player successfully: " + player.getName());
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


    public int getPlayerAmount(){
        return this.players.length;
    }

}
