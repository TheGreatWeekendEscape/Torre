package model.entity.enemy;

import model.entity.Entity;
import model.spell.Spell;

import java.util.ArrayList;
import java.util.Random;

public abstract class Enemy extends Entity {

    protected int dificulty;
    Random rand = new Random();

    public Enemy () {
        init();
    }

    int generateGold() {
        return rand.nextInt(15) * dificulty;
    }

    int generateHp(int baseHp) {
        return rand.nextInt(baseHp - 3, baseHp + 3); //Comprobar que funciona
    }

    abstract ArrayList<Spell> generateSpells();
    abstract String [] generateRepresentation();
    abstract void init();

}
