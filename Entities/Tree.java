package Entities;

import Game.BoardManager;

public class Tree extends BaseEntity {

    public static final String NAME = "Tree";
    private static final String ICON = "\uD83C\uDF33";


    public Tree() {
        super(NAME, ICON, false);
    }


    @Override
    public void interact(Player player, BoardManager boardManager) {
        System.out.println("THIS IS A TREE YA ZALAME");
        System.out.println("Tree");
    }
}
