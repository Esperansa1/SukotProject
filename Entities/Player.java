package Entities;

import Game.BoardManager;
import Game.Fightable;
import Game.PlayerHandler;

import java.util.LinkedList;
import java.util.Queue;

public class Player extends BaseEntity {

    private final String[] icons = {
            "😀", "😁", "😂", "🤣", "😃", "😄", "😅", "😆", "😇", "😉",
            "😊", "😋", "😍", "😘", "😗", "😙", "😚", "☺️", "🙂", "🤗",
            "🤔", "😐", "😑", "😶", "🙄", "😏", "😣", "😥", "😮", "🤐",
            "😯", "😪", "😫", "😴", "😌", "😛", "😜", "😝", "🤤", "😒",
            "😓", "😔", "😕", "🙃", "🤑", "😲", "😷", "🤒", "🤕", "🤢",
            "🤮", "🤧", "😇", "🥴", "🥵", "🥶", "🥺", "🥳", "🤩", "🤯",
            "🧐", "🤨", "🤫", "🤬", "🤭"
    };

    private Queue<BaseWeapon> weaponQueue = new LinkedList<>() ;


    public Player(String name) {
        super(name, true);
        setIcon(getRandomIcon());
    }
    public Player(String name, String icon) {
        super(name, icon, true);
    }

    @Override
    public String toString() {
        return "Player "+ super.getName() + " Icon: " + getIcon();
    }

    private String getRandomIcon(){
        int randomIndex = (int) (Math.random() * icons.length);
        return icons[randomIndex];
    }

    public void addWeapon(BaseWeapon weapon){
        weaponQueue.add(weapon);
    }

    public BaseWeapon getWeapon(){
        if(weaponQueue.isEmpty()) return null;
        return weaponQueue.element();
    }

    public void attemptMove(BoardManager boardManager, PlayerHandler playerHandler, char wantedMovement){
        int x = 0;
        int y = 0;
        switch (Character.toUpperCase(wantedMovement)) {
            case 'U' -> y = -1;
            case 'L' -> x = -1;
            case 'D' -> y = 1;
            case 'R' -> x = 1;
        };
        Position currentPosition = getPosition();
        Position newPosition = new Position(currentPosition.getX() + x, currentPosition.getY() + y);
        attemptMove(boardManager, playerHandler, newPosition);

    }


    private void attemptMove(BoardManager boardManager,PlayerHandler playerHandler, Position newPosition){
        if(!boardManager.isInBoard(newPosition)) return;
        boardManager.getEntity(newPosition).interact(this, boardManager, playerHandler);
    }

    @Override
    public void interact(Player other, BoardManager boardManager, PlayerHandler playerHandler) {
        System.out.println("Interaction between players");
        BaseWeapon myWeapon = getWeapon();
        BaseWeapon otherWeapon= other.getWeapon();
        if(myWeapon == null && otherWeapon == null) return;
        else if(otherWeapon == null)
            thisPlayerWins(other, boardManager, playerHandler);
        else if(myWeapon == null)
            thisPlayerLose(other, boardManager, playerHandler);
        else if(myWeapon.interact(otherWeapon))
            thisPlayerWins(other, boardManager, playerHandler);
        else
            thisPlayerLose(other, boardManager, playerHandler);

    }

    private void thisPlayerWins(Player other, BoardManager boardManager, PlayerHandler playerHandler){
        weaponQueue.remove();
        if(other.getWeapon()!= null)
            addWeapon(other.getWeapon());

        playerHandler.removePlayer(other);
        boardManager.deleteEntity(other.getPosition());
        setPosition(other.getPosition());
    }

    private void thisPlayerLose(Player other, BoardManager boardManager, PlayerHandler playerHandler){
        other.weaponQueue.remove();
        if(getWeapon() != null)
            other.addWeapon(getWeapon());
        playerHandler.removePlayer(this);
        boardManager.deleteEntity(getPosition());
        other.setPosition(getPosition());

    }


}
