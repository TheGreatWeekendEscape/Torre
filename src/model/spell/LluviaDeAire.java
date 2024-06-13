package model.spell;

import model.entity.Entity;
import util.Console;

public class LluviaDeAire extends Spell {

    @Override
    void init() {
        super.name = Console.SPELL_COLOR + "Lluvia de aire" + Console.RESET;
        super.damage = 1;
        super.defense = 0;
        super.hits = 10;
        super.heal = 0;
        super.type = Type.WIND;
    }

    @Override
    public void cast(Entity target) {
        int damage = target.getHit(getTotalDamage(target));
        Console.printDamage(super.caster.getName() + " inflige a " + target.getName() + " ", damage);
    }

    @Override
    public String getSummary() {
        return Console.DEFAULT_COLOR + " [" + Console.DAMAGE_COLOR + super.damage + "x" + super.hits + Console.DMG_CHAR + Console.DEFAULT_COLOR + "] " +
                type.getDisplayName();
    }

    @Override
    public String getDesc() {
        return "Inflige " + super.damage + "x" + super.hits + " de daño";
    }
}
