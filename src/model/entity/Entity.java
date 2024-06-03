package model.entity;

import model.spell.Spell;

import java.util.ArrayList;

public abstract class Entity {

    protected String nombre;
    protected int hp;
    protected int maxHp;
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




}
