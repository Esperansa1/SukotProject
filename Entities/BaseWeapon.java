package Entities;

import Weapons.Fireball;
import Weapons.MagicRing;
import Weapons.Sword;

public abstract class BaseWeapon extends BaseEntity {

    private int damage;

    public BaseWeapon(String name, String icon) {
        super(name, icon, true);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }



}
