package model.spell;

import model.entity.Entity;
import util.Console;

public class Muro extends Spell {

    @Override
    void init() {
        super.name = Console.SPELL_COLOR + "Muro" + Console.RESET;
        super.damage = 0;
        super.defense = 8;
        super.hits = 0;
        super.heal = 0;
        super.type = Type.ROCK;
    }

    @Override
    public void cast(Entity target) {
        caster.gainArmor(this.defense);
        Console.printArmor(super.caster.getName() + " gana ", super.defense + "");
    }

    @Override
    public String getSummary() {
        return Console.DEFAULT_COLOR + " [" + Console.ARMOR_COLOR + this.defense + Console.DEF_CHAR + Console.DEFAULT_COLOR + "] " +
                type.getDisplayName();
    }

    @Override
    public String getDesc() {
        return "Gana " + super.defense + " de defensa";
    }


}
