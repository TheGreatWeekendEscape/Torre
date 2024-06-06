package model.potion;

import model.entity.Entity;

public abstract class Potion {

    protected String name;
    protected String desc;
    protected int quality;

    public abstract void drink(Entity caster, Entity target);

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
