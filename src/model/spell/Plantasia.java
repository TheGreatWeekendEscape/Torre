package model.spell;

import model.entity.Entity;
import util.Console;

public class Plantasia extends Spell {
    public Plantasia() {
        super();
    }

    @Override
    void init() {
        super.name = Console.SPELL_COLOR + "Plantasia" + Console.RESET;
        super.damage = 0;
        super.defense = 0;
        super.hits = 0;
        super.heal = 0;
        super.type = Type.PLANT;
    }

    @Override
    public void cast(Entity target) {
        for (Spell spell : super.caster.getSpells()) {
            spell.addDamage(1);
        }
        Console.print(super.caster.getName() + " se siente mas fuerte", Console.DEFAULT_COLOR);
    }

    @Override
    public String getSummary() {
        return Console.DEFAULT_COLOR + " [" + Console.STATUS_COLOR + Console.STS_CHAR + Console.DEFAULT_COLOR + "] " +
                type.getDisplayName();
    }

    @Override
    public String getDesc() {
        return "Durante el resto del combate todos tus hechizos ganan 1 de danio";
    }
}
