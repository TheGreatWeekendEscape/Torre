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

    void setTarget(Entity target) {
        this.target = target;
    }

    public String getName() {
        return this.name;
    }
    public String getDesc() { return this.desc; }

    abstract void init();
    abstract void cast();

}
