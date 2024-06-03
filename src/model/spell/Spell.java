package model.spell;

import model.entity.Entity;

public abstract class Spell {

    protected String name;
    protected String desc;
    protected int damage;
    protected int defense;
    protected int hits;
    protected Type type;
    protected Entity target;
    protected Entity caster;

    public Spell(Entity caster) {
        this.caster = caster;
        init();
    }



    abstract void init();
    abstract void cast();
}
