package Entities;

import Game.BoardManager;
import Game.Interactable;

import java.util.PriorityQueue;
import java.util.Queue;

public class Player extends BaseEntity implements Interactable {

    private final String[] icons = {
            "😀", "😁", "😂", "🤣", "😃", "😄", "😅", "😆", "😇", "😉",
            "😊", "😋", "😍", "😘", "😗", "😙", "😚", "☺️", "🙂", "🤗",
            "🤔", "😐", "😑", "😶", "🙄", "😏", "😣", "😥", "😮", "🤐",
            "😯", "😪", "😫", "😴", "😌", "😛", "😜", "😝", "🤤", "😒",
            "😓", "😔", "😕", "🙃", "🤑", "😲", "😷", "🤒", "🤕", "🤢",
            "🤮", "🤧", "😇", "🥴", "🥵", "🥶", "🥺", "🥳", "🤩", "🤯",
            "🧐", "🤨", "🤫", "🤬", "🤭"
    };

    private Queue<BaseWeapon> weaponQueue = new PriorityQueue<>();


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

    public boolean attemptMoveRight(BoardManager boardManager)
    {
        Position currentPosition = getPosition();
        Position newPosition = new Position(currentPosition.getX()+1, currentPosition.getY());
        return attemptMove(boardManager, newPosition);
    }

    public boolean attemptMoveLeft(BoardManager boardManager)
    {
        Position currentPosition = getPosition();
        Position newPosition = new Position(currentPosition.getX()-1, currentPosition.getY());
        return attemptMove(boardManager, newPosition);
    }
    public boolean attemptMoveDown(BoardManager boardManager)
    {
        Position currentPosition = getPosition();
        Position newPosition = new Position(currentPosition.getX(), currentPosition.getY() + 1);
        return attemptMove(boardManager, newPosition);
    }
    public boolean attemptMoveUp(BoardManager boardManager)
    {
        Position currentPosition = getPosition();
        Position newPosition = new Position(currentPosition.getX(), currentPosition.getY() - 1);
        return attemptMove(boardManager, newPosition);
    }

    private boolean attemptMove(BoardManager boardManager, Position newPosition){
        boolean isPossible = boardManager.isMovePossible(newPosition);
        if(isPossible){
            setPosition(newPosition);
//            System.out.println("Moved position to "+ newPosition);
            return true;
        }
        return false;
    }

    @Override
    public void interact(BaseWeapon weapon) {
        addWeapon(weapon);
    }

    @Override
    public void interact(Player player) {

    }


}
