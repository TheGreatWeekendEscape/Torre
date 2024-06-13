package model.potion;


import model.entity.Entity;
import model.entity.Player;
import model.entity.enemy.Enemy;

public abstract class Potion {

    protected String name;
    protected String desc;
    protected int quality;

    public abstract void drink(Player caster, Enemy target);

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getQuality() {
        return quality;
    }
}
