package Entities;

import Game.BoardManager;

import java.util.LinkedList;
import java.util.PriorityQueue;
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

    public boolean attemptMove(BoardManager boardManager, char wantedMovement){
        int x = 0;
        int y = 0;
        switch (wantedMovement) {
            case 'U' -> y = -1;
            case 'L' -> x = -1;
            case 'D' -> y = 1;
            case 'R' -> x = 1;
        };
        Position currentPosition = getPosition();
        Position newPosition = new Position(currentPosition.getX() + x, currentPosition.getY() + y);
        return attemptMove(boardManager, newPosition);

    }


    private boolean attemptMove(BoardManager boardManager, Position newPosition){
        if(!boardManager.isInBoard(newPosition)) return false;
        boardManager.getEntity(newPosition).interact(this, boardManager);
        return false;
    }

    @Override
    public void interact(Player player, BoardManager boardManager) {

        System.out.println("Player Interactions");
    }
}
