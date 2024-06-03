package model.entity.enemy;

import model.spell.Spell;

import java.util.ArrayList;

public class Blob extends Enemy {

    @Override
    void init() {
        super.nombre = "";
        super.dificulty = 1;
        super.maxHp = generateHp(15);
        super.hp = maxHp;
        super.gold = generateGold();
        super.representation = generateRepresentation();
        super.spells = generateSpells();
    }

    @Override
    ArrayList<Spell> generateSpells() {
        return null;
    }

    @Override
    String [] generateRepresentation () {
        String [] representation = new String[5];
        String s0 = "/     \\";
        String s1 = "| () () |";
        String s2 = "\\  ^  /";
        String s3 = "\\\\\\\\\\";
        String s4 = "\\\\\\\\\\";
        representation[0] = s0;
        representation[1] = s1;
        representation[2] = s2;
        representation[3] = s3;
        representation[4] = s4;
        return representation;
    }
}
