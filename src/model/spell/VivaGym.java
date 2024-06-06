package model.spell;

import model.entity.Entity;
import util.Console;

public class VivaGym  extends Spell {
    public VivaGym (Entity caster) {
        super(caster);
    }

    @Override
    void init() {
        super.name = Console.SPELL_COLOR + "VivaGym" + Console.RESET;
        super.damage = 0;
        super.defense = 0;
        super.hits = 0;
        super.type = Type.NOTYPE;
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
        return Console.STATUS_COLOR + "[" + Console.STATUS_COLOR + "]" + Console.RESET;
    }

    @Override
    public String getDesc() {
        return "Durante el resto del combate todos tus hechizos ganan 1 de danio";
    }
}
