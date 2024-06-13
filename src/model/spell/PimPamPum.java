package model.spell;

import model.entity.Entity;
import util.Console;

public class PimPamPum extends Spell {

    @Override
    void init() {
        super.name = Console.SPELL_COLOR + "Pim Pam Pum" + Console.RESET;
        super.damage = 4;
        super.defense = 0;
        super.hits = 3;
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
