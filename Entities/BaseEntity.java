package Entities;

import Game.BoardManager;
import Weapons.MagicRing;

public abstract class BaseEntity {

    private String name;
    private String icon;
    private Position position;

    public boolean isWalkable() {
        return isWalkable;
    }

    private boolean isWalkable;

    public BaseEntity(String name, boolean isWalkable) {
        this.name = name;
        this.isWalkable = isWalkable;
    }

    public BaseEntity(String name, String icon, boolean isWalkable) {
        this.name = name;
        this.icon = icon;
        this.isWalkable = isWalkable;

    }

    public BaseEntity(Position position, String name, String icon, boolean isWalkable) {
        this.name = name;
        this.icon = icon;
        this.position = position;
        this.isWalkable = isWalkable;

    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract void interact(Player player, BoardManager boardManager);
}
