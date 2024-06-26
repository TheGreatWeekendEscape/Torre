package model.entity.enemy;

import model.spell.*;

import java.util.ArrayList;

public class Blob extends Enemy {

    @Override
    void init() {
        super.displayName = "un blob";
        super.name = "Blob";
        super.dificulty = 1;
        super.maxHp = generateHp(14, 3);
        super.hp = maxHp;
        super.type = Type.WIND;
        generateRepresentation();
        generateSpells();
    }

    @Override
    void generateSpells() {
        super.spells = new ArrayList<>();
        super.addSpell(new LluviaDeAire());
        super.addSpell(new AtaqueBasico());
        super.addSpell(new Abucheo());
        super.addSpell(new Muro());
    }

    @Override
    void generateRepresentation () {
        super.representation = new String[5];
        super.representation[0] = "/     \\";
        super.representation[1] = "|() ()|";
        super.representation[2] = "\\  ^  /";
        super.representation[3] = "  \\\\\\\\\\";
        super.representation[4] = "  \\\\\\\\\\";
    }
}
