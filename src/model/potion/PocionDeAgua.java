package model.potion;

import model.entity.Entity;
import model.entity.Player;
import model.entity.enemy.Enemy;
import model.spell.Spell;
import util.Console;

public class PocionDeAgua extends Potion {

    public PocionDeAgua() {
        super.name = Console.POTION_COLOR + "Pocion de agua"+ Console.RESET;
        super.desc = "Tus hechizos curan el doble el resto del combate";

    }

    @Override
    public void drink(Player caster, Enemy target) {
        for (Spell spell : caster.getSpells()) {
            if (spell.getHeal() > 0) {
                spell.setHeal(spell.getHeal()*2);
                Console.printDefault(spell.getName() + Console.DEFAULT_COLOR + " ahora cura el doble");
            }
        }
    }
}
