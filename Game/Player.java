package Game;

import java.util.PriorityQueue;
import java.util.Queue;

public class Player extends BaseEntity implements Interactable{

    private final String[] icons = {
            "😀", "😁", "😂", "🤣", "😃", "😄", "😅", "😆", "😇", "😉",
            "😊", "😋", "😍", "😘", "😗", "😙", "😚", "☺️", "🙂", "🤗",
            "🤔", "😐", "😑", "😶", "🙄", "😏", "😣", "😥", "😮", "🤐",
            "😯", "😪", "😫", "😴", "😌", "😛", "😜", "😝", "🤤", "😒",
            "😓", "😔", "😕", "🙃", "🤑", "😲", "😷", "🤒", "🤕", "🤢",
            "🤮", "🤧", "😇", "🥴", "🥵", "🥶", "🥺", "🥳", "🤩", "🤯",
            "🧐", "🤨", "🤫", "🤬", "🤭"
    };

    Queue<BaseWeapon> weaponQueue = new PriorityQueue<>();


    public Player(String name) {
        super(name);
        setIcon(getRandomIcon());
    }
    public Player(String name, String icon) {
        super(name, icon);
    }

    @Override
    public String toString() {
        return "Game.Player "+ super.getName() + " Icon: " + getIcon();
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


    @Override
    public void interact(BaseWeapon weapon) {
        addWeapon(weapon);
    }

    @Override
    public void interact(Player player) {

    }


}
