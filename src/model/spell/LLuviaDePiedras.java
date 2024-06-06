package model.spell;

import model.entity.Entity;
import util.Console;

public class LLuviaDePiedras extends Spell{
    public LLuviaDePiedras (Entity caster) {
        super(caster);
    }

    @Override
    void init() {
        super.name = "LLuvia de piedras";
        super.desc = "Causa 1x6 de daño";
        super.damage = 1;
        super.defense = 0;
        super.hits = 6;
        super.type = Type.NOTYPE;
    }

    @Override
    public void cast(Entity target) {
        int damage = target.getHit(getTotalDamage());
        Console.printDamage(super.caster.getName() + " inflige a " + target.getName() + " ", damage);
    }

    @Override
    public String getSummary() {
        return Console.DAMAGE_COLOR + "[" + super.damage + "x" + super.hits + Console.DMG_CHAR + "]" + Console.RESET;
    }
}
