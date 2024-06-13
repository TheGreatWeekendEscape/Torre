package model.potion;

import model.entity.Player;
import model.entity.enemy.Enemy;
import model.spell.Spell;
import util.Console;

public class PocionDeViento extends Potion {

    public PocionDeViento() {
        super.name = Console.POTION_COLOR + "Pocion de viento"+ Console.RESET;
        super.desc = "Tus hechizos de mas de un golpe ganan un golpe extra este combate";

    }

    @Override
    public void drink(Player caster, Enemy target) {
        for (Spell spell : caster.getSpells()) {
            if (spell.getHits() > 1) {
                spell.setHits(spell.getHits() + 1);
                Console.printDefault(spell.getName() + Console.DEFAULT_COLOR + " gana un golpe");
            }
        }
    }
}
