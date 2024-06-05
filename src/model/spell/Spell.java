package model.spell;

import model.entity.Entity;

public abstract class Spell {

    protected String name;
    protected String desc;
    protected int damage;
    protected int defense;
    protected int hits;
    protected Type type;
    protected Entity caster;

    public Spell(Entity caster) {
        this.caster = caster;
        init();
    }

    public String getName() {
        return this.name;
    }
    public String getDesc() { return this.desc; }
    public int getTotalDamage() {
        return this.damage * this.hits;
    }

    abstract void init();
    public abstract void cast(Entity target);
    public abstract String getSummary();

}
