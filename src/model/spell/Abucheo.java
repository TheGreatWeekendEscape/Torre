package model.spell;

import model.entity.Entity;
import util.Console;

public class Abucheo extends Spell {

    @Override
    void init() {
        super.name = Console.SPELL_COLOR + "Abucheo" + Console.RESET;
        super.damage = 0;
        super.defense = 0;
        super.hits = 0;
        super.heal = 0;
        super.type = Type.PLANT;
    }

    @Override
    public void cast(Entity target) {
        for (Spell spell : target.getSpells()) {
            spell.addDamage(-1);
        }
        Console.print(target.getName() + " se siente mas debil", Console.DEFAULT_COLOR);
    }

    @Override
    public String getSummary() {
        return Console.DEFAULT_COLOR + " [" + Console.STATUS_COLOR + Console.STS_CHAR + Console.DEFAULT_COLOR + "] " +
                type.getDisplayName();
    }

    @Override
    public String getDesc() {
        return "Durante el resto del combate los hechizos de tu rival pierden uno de danio";
    }
}
