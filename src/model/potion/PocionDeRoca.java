package model.potion;

import model.entity.Entity;
import model.spell.Spell;
import util.Console;


public class PocionDeRoca extends Potion {

    public PocionDeRoca() {
        super.name = Console.POTION_COLOR + "Pocion de roca" + Console.RESET;
        super.desc = "Tus hechizos duplican su armadura durante este combate";

    }

    @Override
    public void drink(Entity caster, Entity target) {
        String spellsAffected = "";
        for (Spell s : caster.getSpells()) {
            if (s.getDefense() > 0) {
                s.setDefense(s.getDefense() * 2);
                spellsAffected +=  " | " + s.getName();
            }

        }

        if (spellsAffected.equals("")) {
            Console.print("No tienes ningun hechizo con armadura y la pocion no tuvo efecto", Console.DEFAULT_COLOR);
        } else {
            Console.print("Se ha duplicado la armadura de los siguientes hechizos: " + spellsAffected, Console.DEFAULT_COLOR);
        }

    }
}
