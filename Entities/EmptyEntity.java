package Entities;

import Game.BoardManager;

public class EmptyEntity extends BaseEntity {

    public static final String NAME = "Empty";
    private static final String ICON = "---";


    public EmptyEntity(Position position) {
        super(position, NAME, ICON, true);
    }


    @Override
    public void interact(Player player, BoardManager boardManager) {
        System.out.println("Empty entity");
        player.setPosition(getPosition());
        return;
    }
}
