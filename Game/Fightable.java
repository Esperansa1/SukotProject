package Game;

import Entities.BaseWeapon;
import Weapons.Fireball;
import Weapons.MagicRing;
import Weapons.Sword;

public interface Fightable {

    public boolean interact(Fightable opponent);

    public boolean stronger(Fireball weapon);
    public boolean stronger(Sword weapon);
    public boolean stronger(MagicRing weapon);
}
