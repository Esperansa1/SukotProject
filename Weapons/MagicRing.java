package Weapons;

import Entities.BaseWeapon;
import Entities.Player;
import Game.BoardManager;
import Game.Fightable;

public class MagicRing extends BaseWeapon implements Fightable {

    public static final String NAME = "Magic Ring";
    private static final String ICON = "\uD83D\uDC8D";

    public MagicRing() {
        super(NAME, ICON);
    }

    @Override
    public boolean interact(Fightable opponent) {
        return opponent.stronger(this);
    }
    @Override
    public boolean stronger(Fireball weapon) {
        return true;
    }

    @Override
    public boolean stronger(Sword weapon) {
        return false;
    }

    @Override
    public boolean stronger(MagicRing weapon) {
        return Math.random() > 0.5;
    }

    @Override
    public void interact(Player player, BoardManager boardManager) {
        player.setPosition(getPosition());
        // Order matters here because deleteEntity is working based off the position of the entity!

        player.addWeapon(this);
        boardManager.deleteEntity(getPosition());

    }
}
