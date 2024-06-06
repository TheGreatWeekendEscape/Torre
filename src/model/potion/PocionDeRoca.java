package model.potion;

import model.entity.Entity;
import model.spell.Spell;

public class PocionDeRoca extends Potion {

    public PocionDeRoca() {
        super.name = "Pocion de roca";
        super.desc = "Tus hechizos duplican su armadura durante este combate";

    }

    @Override
    public void drink(Entity target) {
        for (Spell s : target.getSpells()) {

        }
    }
}
