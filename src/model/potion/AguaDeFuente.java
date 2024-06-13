package model.potion;

import model.entity.Entity;
import model.entity.Player;
import model.entity.enemy.Enemy;
import util.Console;

public class AguaDeFuente extends Potion {

    public AguaDeFuente() {
        super.name = Console.POTION_COLOR + "Agua de fuente"+ Console.RESET;
        super.desc = "Recupera 10 puntos de vida";

    }

    @Override
    public void drink(Player caster, Enemy target) {
        int heal = caster.gainHp(10);
        Console.printDefault("Te curas " + heal + " puntos de vida");
    }
}
