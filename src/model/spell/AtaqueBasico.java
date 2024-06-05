package model.spell;

import model.entity.Entity;
import util.Console;

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
    public void cast(Entity target) {
        int damage = target.getHit(getTotalDamage());
        Console.printDamage(super.caster.getName() + " inflige a " + target.getName() + " ", damage);
    }

    @Override
    public String getSummary() {
        return Console.DAMAGE_COLOR + "[" + super.damage + Console.DMG_CHAR + "]" + Console.RESET;
    }
}