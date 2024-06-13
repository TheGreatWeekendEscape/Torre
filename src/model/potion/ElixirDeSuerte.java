package model.potion;

import controller.SpellController;
import model.entity.Entity;
import model.entity.Player;
import model.entity.enemy.Enemy;
import model.spell.Spell;
import util.Console;

public class ElixirDeSuerte extends Potion {

    public ElixirDeSuerte() {
        super.name = Console.POTION_COLOR + "Elixir de suerte"+ Console.RESET;
        super.desc = "Duplica el oro y la probabilidad de recibir recompensas al final del combate";

    }

    @Override
    public void drink(Player caster, Enemy target) {
        target.setGold(target.getGold()*2);
        target.setKeyChance(target.getKeyChance()*2);
        target.setSpellDropChance(target.getSpellDropChance()*2);
        Console.printDefault("Te sientes afortunado");
    }

}
