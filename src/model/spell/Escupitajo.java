package model.spell;

import model.entity.Entity;
import util.Console;

public class Escupitajo extends Spell {


    @Override
    void init() {
        super.name = Console.SPELL_COLOR + "Escupitajo" + Console.RESET;
        super.damage = 6;
        super.defense = 0;
        super.hits = 1;
        super.heal = 2;
        super.type = Type.WATER;
    }

    @Override
    public void cast(Entity target) {
        int damage = target.getHit(getTotalDamage(target));
        int healed = super.caster.gainHp(super.heal);
        Console.printDamage(super.caster.getName() + " inflige a " + target.getName() + " ", damage);
        Console.printDefault(super.caster.getName() + " se cura " + healed + " puntos de vida");
    }

    @Override
    public String getSummary() {
        return Console.DEFAULT_COLOR + " [" + Console.DAMAGE_COLOR + super.damage + Console.DMG_CHAR + Console.DEFAULT_COLOR + "][" +
               Console.HEALTH_COLOR + super.heal + Console.HP_CHAR + Console.DEFAULT_COLOR + "] " + type.getDisplayName();
    }

    @Override
    public String getDesc() {
        return "Inflige " + super.damage + " de daño y te curas " + super.heal + " de vida";
    }
}
