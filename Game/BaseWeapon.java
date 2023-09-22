package Game;

public class BaseWeapon extends BaseEntity {

    private int damage;

    public BaseWeapon(String name, String icon) {
        super(name, icon);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
