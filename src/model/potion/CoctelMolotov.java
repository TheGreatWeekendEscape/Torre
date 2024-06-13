package model.potion;

import model.entity.Entity;
import model.entity.Player;
import model.entity.enemy.Enemy;
import util.Console;

public class CoctelMolotov extends Potion{

    public CoctelMolotov() {
        super.name = Console.POTION_COLOR + "Coctel molotov"+ Console.RESET;
        super.desc = "Inflige 15 de danio";

    }

    @Override
    public void drink(Player caster, Enemy target) {
        int damageReceived = target.getHit(15);
        Console.printDamage(caster.getName() + " inflige a " + target.getName() + " ", damageReceived);
    }
}
