package model.entity.enemy;

import model.entity.Entity;
import model.spell.Spell;

import java.util.Arrays;
import java.util.Random;

public abstract class Enemy extends Entity {

    protected String displayName;
    protected int dificulty;
    Random rand = new Random();

    public Enemy () {
        init();
        super.gold = generateGold();
        super.armor = 0;
    }

    int generateGold() {
        return rand.nextInt(15) * dificulty;
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
    abstract void generateSpells();
    abstract void generateRepresentation();
    abstract void init();

}
