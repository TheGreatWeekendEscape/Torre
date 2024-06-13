package model.entity;

import model.spell.Spell;
import model.spell.Type;
import util.Console;

import java.util.ArrayList;
import java.util.Random;

public abstract class Entity {

    protected String name;
    protected int hp;
    protected int maxHp;
    protected int armor;
    protected ArrayList<Spell> spells;
    protected int gold;
    protected int keys;
    protected String[] representation;
    protected Type type;

    public int fullHeal() {
        return gainHp(maxHp);
    }

    public int gainHp(int amount) {
        int missingHealth = maxHp - hp;
        if (amount <= missingHealth) {
            this.hp += amount;
            return amount;
        } else {
            this.hp = maxHp;
            return missingHealth;
        }
    }

    //Este metodo resta vida plana, sin armadura
    public void loseHp(int amount) {
        this.hp -= amount;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    //Este metodo es un golpe de hechizo con posible armadura y devuelve el daño final
    public int getHit (int amount) {
        int finalArmor = armor - amount;
        int finalDamage = finalArmor * -1;
        if (finalArmor >= 0) {
            loseArmor(amount);
            return 0;
        } else {
            armor = 0;
            loseHp(finalDamage);
            return finalDamage;
        }
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

    public boolean hasSpell(Spell spell) {
        for (Spell s : spells) {
            if (spell.getName().equalsIgnoreCase(s.getName())) {
                return true;
            }
        }
        return false;
    }

    public void resetArmor() {
        this.armor = 0;
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

    public int getKeys() {
        return keys;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public int getHealingForFountain() {
        return this.maxHp / 2;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public abstract void addSpell(Spell s);
}
