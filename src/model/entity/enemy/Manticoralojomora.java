package model.entity.enemy;

import model.spell.AtaqueBasico;
import model.spell.DefensaBasica;

import java.util.ArrayList;

public class Manticoralojomora extends Enemy {


    @Override
    void init() {
        super.displayName ="una manticoralojomora";
        super.name = "Manticoralojomora";
        super.dificulty = 1;
        super.maxHp = generateHp(11);
        super.hp = maxHp;
        generateRepresentation();
        generateSpells();
    }

    @Override
    void generateSpells() {
        super.spells = new ArrayList<>();
        super.spells.add(new AtaqueBasico(this));
        super.spells.add(new DefensaBasica(this));
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

