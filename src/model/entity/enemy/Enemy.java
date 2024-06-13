package model.entity.enemy;

import model.entity.Entity;
import model.spell.Spell;
import model.spell.Type;

import java.util.Arrays;
import java.util.Random;

public abstract class Enemy extends Entity {

    private int spellDropChance; // %
    private int keyChance; // %
    private Spell spellDrop;
    protected String displayName;
    protected int dificulty;
    Random rand = new Random();

    public Enemy () {
        super.armor = 0;
        spellDropChance = 1; //%
        keyChance = 15; //%
        init();
        prepareDrops();
    }

    private void prepareDrops() {
        keyChance = 15;
        super.gold = rand.nextInt(15) * dificulty;
        int i = rand.nextInt(100);

        if (i > keyChance) {
            super.keys = 0;
        } else {
            super.keys = 1;
        }
        if (i < spellDropChance) { //Any number works here its 1% chance
            spellDrop = getRandSpell();
        } else {
            spellDrop = null;
        }
    }

    int generateHp(int baseHp) {
        return rand.nextInt(baseHp - 3, baseHp + 3); //Comprobar que funciona
    }

    @Override
    public void addSpell(Spell s) {
        s.setCaster(this);
        super.spells.add(s);
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Spell getSpellDrop() {
        return spellDrop;
    }

    public int getSpellDropChance() {
        return spellDropChance;
    }

    public void setSpellDropChance(int spellDropChance) {
        this.spellDropChance = spellDropChance;
    }

    public int getKeyChance() {
        return keyChance;
    }

    public void setKeyChance(int keyChance) {
        this.keyChance = keyChance;
    }

    abstract void generateSpells();
    abstract void generateRepresentation();
    abstract void init();

}
