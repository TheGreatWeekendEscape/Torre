package model.spell;

import model.entity.Entity;

public abstract class Spell implements Cloneable{

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

    public void addDamage(int amount) {
        this.damage += amount;
    }

    public void addArmor(int amount) {
        this.defense += amount;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getTotalDamage() {
        return this.damage * this.hits;
    }

    public Spell clone() {
        try {
            return (Spell) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    abstract void init();

    public abstract void cast(Entity target);

    public abstract String getSummary();

}
