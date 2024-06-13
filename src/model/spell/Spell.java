package model.spell;

import model.entity.Entity;
import util.Console;

public abstract class Spell implements Cloneable{

    protected String name;
    protected int damage;
    protected int defense;
    protected int heal;
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

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getTotalDamage(Entity target) {
        int damage = this.damage * this.hits;
        if (this.type.isGoodVs(target.getType())) {
            damage *= 1.5;
            Console.printDefault(this.name + Console.DEFAULT_COLOR + " es muy efectivo contra " + target.getName());
        }
        if (this.type.isBadVs(target.getType())) {
            damage *= 0.5;
            Console.printDefault(this.name + Console.DEFAULT_COLOR + " no es muy efectivo contra " + target.getName());
        }
        return damage;
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
