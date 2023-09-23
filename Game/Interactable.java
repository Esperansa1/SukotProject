package Game;

import Entities.BaseWeapon;
import Entities.Player;

public interface Interactable {

    public void interact(BaseWeapon baseWeapon);
    public void interact(Player player);

}
