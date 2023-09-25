package Weapons;

import Entities.BaseEntity;
import Entities.BaseWeapon;
import Entities.Player;
import Game.BoardManager;
import Game.Fightable;

public class Fireball extends BaseWeapon implements Fightable {

    public static final String NAME = "Fireball";
    private static final String ICON = "\uD83D\uDD25";

    public Fireball() {
        super(NAME, ICON);
    }


    @Override
    public boolean interact(Fightable opponent) {
        return opponent.stronger(this);
    }

    @Override
    public boolean stronger(Fireball weapon) {
        return Math.random() > 0.5; // Same weapon so random winner
    }

    public boolean stronger(Sword weapon) {
        return true;
    }

    public boolean stronger(MagicRing weapon) {
        return false;
    }

    @Override
    public void interact(Player player, BoardManager boardManager) {
        player.setPosition(getPosition());
        player.addWeapon(this);
        System.out.println("Weapon " + this.getName() + " has been added to player " + player.getName());

    }
}
