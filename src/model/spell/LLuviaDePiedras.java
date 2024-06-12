package model.spell;

import model.entity.Entity;
import util.Console;

public class LLuviaDePiedras extends Spell{
    public LLuviaDePiedras () {
        super();
    }

    @Override
    void init() {
        super.name = Console.SPELL_COLOR + "Lluvia de piedras" + Console.RESET;

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

    @Override
    public String getDesc() {
        return "Inflige " + super.damage + "x" + super.hits + " de danio";
    }
}
