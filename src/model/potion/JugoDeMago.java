package model.potion;

import controller.SpellController;
import model.entity.Entity;
import model.entity.Player;
import model.entity.enemy.Enemy;
import model.spell.Spell;
import util.Console;

public class JugoDeMago extends Potion {

    public JugoDeMago() {
        super.name = Console.POTION_COLOR + "Jugo de mago"+ Console.RESET;
        super.desc = "Gana un hechizo aleatorio durante este combate";

    }

    @Override
    public void drink(Player caster, Enemy target) {
        Spell spell = SpellController.getNewRandSpell(caster);
        caster.addSpell(spell);
    }
}
