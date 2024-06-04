package model.entity.enemy;

import model.entity.Entity;

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

    public String getDisplayName() {
        return this.displayName;
    }
    abstract void generateSpells();
    abstract void generateRepresentation();
    abstract void init();
}
