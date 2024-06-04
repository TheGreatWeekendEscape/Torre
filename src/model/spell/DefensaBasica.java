package model.spell;

import model.entity.Entity;

public class DefensaBasica extends Spell{

    public DefensaBasica (Entity caster) {
        super(caster);
    }

    @Override
    void init() {
        super.name = "Defensa basica";
        super.desc = "Gana 3 de armadura";
        super.damage = 0;
        super.defense = 3;
        super.hits = 0;
        super.type = Type.NOTYPE;

    }

    @Override
    void cast() {
        super.caster.gainArmor(this.defense);
    }
}
