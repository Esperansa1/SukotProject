package Weapons;

import Entities.BaseWeapon;
import Game.Fightable;

public class MagicRing extends BaseWeapon implements Fightable {

    private static final String NAME = "Magic Ring";
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
}
