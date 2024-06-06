package model.spell;

import model.entity.Entity;
import util.Console;

public class Escupitajo extends Spell {

    public Escupitajo (Entity caster) {
        super(caster);
    }

    @Override
    void init() {
        super.name = Console.SPELL_COLOR + "Escupitajo" + Console.RESET;
        super.damage = 5;
        super.defense = 0;
        super.hits = 1;
        super.type = Type.WATER;
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

    @Override
    public String getDesc() {
        return "Inflige " + super.damage + " de daño";
    }
}
