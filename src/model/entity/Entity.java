package model.entity;

import model.spell.Spell;

import java.util.ArrayList;
import java.util.Arrays;
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
}
