package model.spell;

import model.entity.Entity;

public abstract class Spell implements Cloneable{

    protected String name;
    protected int damage;
    protected int defense;
    protected int hits;
    protected Type type;
    protected Entity caster;

    public Spell() {
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

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Entity getCaster() {
        return caster;
    }

    public void setCaster(Entity caster) {
        this.caster = caster;
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

    public abstract String getDesc();

}
