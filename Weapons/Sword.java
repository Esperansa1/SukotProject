package Weapons;

import Entities.BaseWeapon;
import Entities.Player;
import Game.BoardManager;
import Game.Fightable;

public class Sword extends BaseWeapon implements Fightable {
    public static final String NAME = "Sword";
    private static final String ICON = "⚔";


    public Sword() {
        super(NAME, ICON);
    }

    @Override
    public boolean interact(Fightable opponent) {
        return opponent.stronger(this);
    }

    public boolean stronger(Fireball weapon) {
        return false;
    }

    public boolean stronger(Sword weapon) {
        return Math.random() > 0.5;
    }

    public boolean stronger(MagicRing weapon) {
        return true;
    }

    @Override
    public void interact(Player player, BoardManager boardManager) {
        player.setPosition(getPosition());
        player.addWeapon(this);
        System.out.println("Weapon " + this.getName() + " has been added to player " + player.getName());

    }
}
