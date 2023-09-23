package Weapons;

import Entities.BaseWeapon;
import Game.Fightable;

public class Sword extends BaseWeapon implements Fightable {
    private static final String NAME = "Sword";
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
}
