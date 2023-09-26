package Game;

import Weapons.Fireball;
import Weapons.MagicRing;
import Weapons.Sword;

public interface Fightable {

    boolean interact(Fightable opponent);

    boolean stronger(Fireball weapon);
    boolean stronger(Sword weapon);
    boolean stronger(MagicRing weapon);
}
