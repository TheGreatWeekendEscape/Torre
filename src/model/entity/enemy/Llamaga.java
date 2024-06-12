package model.entity.enemy;

import model.spell.AtaqueBasico;
import model.spell.DefensaBasica;
import model.spell.Escupitajo;

import java.util.ArrayList;

public class Llamaga extends Enemy {


    @Override
    void init() {
        super.displayName ="una llamaga";
        super.name = "Llamaga";
        super.dificulty = 1;
        super.maxHp = generateHp(11);
        super.hp = maxHp;
        generateRepresentation();
        generateSpells();
    }

    @Override
    void generateSpells() {
        super.spells = new ArrayList<>();
        addSpell(new Escupitajo());
        addSpell(new DefensaBasica());
    }

    @Override
    void generateRepresentation () {
        super.representation = new String[5];
        super.representation[0] = "  \\  / ";
        super.representation[1] = "   ()";
        super.representation[2] = " *-()";
        super.representation[3] = "    ||___";
        super.representation[4] = "    || ||";
    }
}

