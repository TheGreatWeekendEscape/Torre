package model.spell;

import model.entity.Entity;
import util.Console;

public class Ascua extends Spell {

    @Override
    void init() {
        super.name = Console.SPELL_COLOR + "Ascua" + Console.RESET;
        super.damage = 10;
        super.defense = 0;
        super.hits = 1;
        super.heal = 0;
        super.type = Type.FIRE;
    }

    @Override
    public void cast(Entity target) {
        int damage = target.getHit(getTotalDamage(target));
        Console.printDamage(super.caster.getName() + " inflige a " + target.getName() + " ", damage);
    }

    @Override
    public String getSummary() {
        return Console.DEFAULT_COLOR + " [" + Console.DAMAGE_COLOR + super.damage + Console.DMG_CHAR + Console.DEFAULT_COLOR + "] " +
                type.getDisplayName();
    }

    @Override
    public String getDesc() {
        return "Inflige " + super.damage + " de daño";
    }
}
