package model.potion;

import model.entity.Entity;
import model.entity.Player;
import model.entity.enemy.Enemy;
import model.spell.Spell;
import util.Console;


public class PocionDeRoca extends Potion {

    public PocionDeRoca() {
        super.name = Console.POTION_COLOR + "Pocion de roca" + Console.RESET;
        super.desc = "Gana 15 de armadura";

    }

    @Override
    public void drink(Player caster, Enemy target) {
        caster.gainArmor(15);
        Console.printDefault("Ganas 15 de armadura");

    }
}
