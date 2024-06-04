package model.spell;

import model.entity.Entity;

public class AtaqueBasico extends Spell {

    public AtaqueBasico (Entity caster) {
        super(caster);
    }

    @Override
    void init() {
        super.name = "Ataque basico";
        super.desc = "Causa 3 de daño";
        super.damage = 3;
        super.defense = 0;
        super.hits = 1;
        super.type = Type.NOTYPE;
    }

    @Override
    void cast() {
        super.target.loseHp(super.damage);
    }
}
