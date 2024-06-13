package model.potion;

import model.entity.Entity;
import model.entity.Player;
import model.entity.enemy.Enemy;
import model.spell.Spell;
import util.Console;

public class PocionDeFuego extends Potion {

    public PocionDeFuego() {
        super.name = Console.POTION_COLOR + "Pocion de fuego"+ Console.RESET;
        super.desc = "Tus hechizos de un solo golpe ganan [" + Console.DAMAGE_COLOR + 5 + Console.DMG_CHAR +
        Console.DEFAULT_COLOR + "] este combate";

    }

    @Override
    public void drink(Player caster, Enemy target) {
        for (Spell spell : caster.getSpells()) {
            if (spell.getHits() == 1) {
                spell.setDamage(spell.getDamage() + 5);
                Console.printDefault(spell.getName() + " gana [" + Console.DAMAGE_COLOR + 5 + Console.DMG_CHAR + Console.DEFAULT_COLOR + "]");
            }
        }
    }
}
