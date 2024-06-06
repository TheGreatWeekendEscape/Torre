package model.potion;

import model.entity.Entity;
import util.Console;

public class PocionDeFuego extends Potion{

    public PocionDeFuego() {
        super.name = Console.POTION_COLOR + "Pocion de fuego"+ Console.RESET;
        super.desc = "Inflige 15 de danio";

    }

    @Override
    public void drink(Entity caster, Entity target) {
        int damageReceived = target.getHit(15);
        Console.printDamage(caster.getName() + " inflige a " + target.getName() + " ", damageReceived);
    }
}
