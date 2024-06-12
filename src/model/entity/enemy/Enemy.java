package model.entity.enemy;

import model.entity.Entity;
import model.spell.Spell;

import java.util.Arrays;
import java.util.Random;

public abstract class Enemy extends Entity {

    private Spell spellDrop;
    private int keyChance; // %
    protected String displayName;
    protected int dificulty;
    Random rand = new Random();

    public Enemy () {
        super.armor = 0;
        init();
        prepareDrops();
    }

    private void prepareDrops() {
        keyChance = 85;
        super.gold = rand.nextInt(15) * dificulty;
        int i = rand.nextInt(100);

        if (i < keyChance) {
            super.keys = 0;
        } else {
            super.keys = 1;
        }
        if (i == 39) { //Any number works here its 1% chance
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

    abstract void generateSpells();
    abstract void generateRepresentation();
    abstract void init();

}
