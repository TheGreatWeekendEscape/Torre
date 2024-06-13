package model.spell;

import model.entity.Entity;
import util.Console;

public class DefensaBasica extends Spell{

    public DefensaBasica () {
        super();
    }

    @Override
    void init() {
        super.name = Console.SPELL_COLOR + "Defensa basica" + Console.RESET;
        super.damage = 0;
        super.defense = 3;
        super.hits = 0;
        super.type = Type.NORMAL;
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
