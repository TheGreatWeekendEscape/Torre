package model.spell;

import model.entity.Entity;
import util.Console;

public class LanzaHelada extends Spell {

    @Override
    void init() {
        super.name = Console.SPELL_COLOR + "Lanza helada" + Console.RESET;
        super.damage = 5;
        super.defense = 5;
        super.hits = 1;
        super.heal = 0;
        super.type = Type.ICE;
    }

    @Override
    public void cast(Entity target) {
        int damage = target.getHit(getTotalDamage(target));
        caster.gainArmor(this.defense);
        Console.printDamage(super.caster.getName() + " inflige a " + target.getName() + " ", damage);
        Console.printArmor(super.caster.getName() + " gana ", super.defense + "");
    }

    @Override
    public String getSummary() {
        return Console.DEFAULT_COLOR + " [" + Console.DAMAGE_COLOR + super.damage + Console.DMG_CHAR + Console.DEFAULT_COLOR + "][" +
                Console.ARMOR_COLOR + super.defense + Console.DEF_CHAR + Console.DEFAULT_COLOR + "] " + type.getDisplayName();
    }

    @Override
    public String getDesc() {
        return "Inflige " + super.damage + " de daño y gana " + super.defense + " de armadura";
    }
}
