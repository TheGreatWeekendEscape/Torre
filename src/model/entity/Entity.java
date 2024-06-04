package model.entity;

import model.spell.Spell;

import java.util.ArrayList;
import java.util.Random;

public abstract class Entity {

    protected String name;
    protected int hp;
    protected int maxHp;
    protected int armor;
    protected ArrayList<Spell> spells;
    protected int gold;
    protected String[] representation;

    public void gainHp(int amount) {
        this.hp += amount;
        if (this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }
    }

    public void loseHp(int amount) {
        this.hp -= amount;
    }

    public void gainArmor(int amount) {
        this.armor += amount;
    }

    public void loseArmor (int amount) {
        this.armor -= amount;
        if (this.armor < 0) {
            this.armor = 0;
        }
    }

    public int getHpPercentage() {
        return (hp * 10) / maxHp;
    }

    public String getName() {
        return this.name;
    }

    public String[] getRepresentation() {
        return this.representation;
    }

    public Spell getRandSpell() {
        Random rand = new Random();
        return spells.get(rand.nextInt(spells.size()));
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setRepresentation(String[] representation) {
        this.representation = representation;
    }
}
