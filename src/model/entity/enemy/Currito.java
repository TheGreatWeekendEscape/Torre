package model.entity.enemy;

import model.spell.*;

import java.util.ArrayList;

public class Currito extends Enemy {

    @Override
    void init() {
        super.displayName = "un cuervo";
        super.name = "Currito";
        super.dificulty = 1;
        super.maxHp = generateHp(25, 2);
        super.hp = maxHp;
        super.type = Type.WIND;
        generateRepresentation();
        generateSpells();
    }

    @Override
    void generateSpells() {
        super.spells = new ArrayList<>();
        super.addSpell(new PimPamPum());
        super.addSpell(new LluviaDeAire());
        super.addSpell(new VivaGym());
    }

    @Override
    void generateRepresentation () {
        super.representation = new String[5];
        super.representation[0] = "  /";
        super.representation[1] = " <o)";
        super.representation[2] = "(\\\\_//";
        super.representation[3] = " (_\\_)";
        super.representation[4] = "  _|_";
    }
}
