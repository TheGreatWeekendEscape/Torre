package model.potion;

import model.entity.Entity;

public class PocionDeFuego extends Potion{

    public PocionDeFuego() {
        super.name = "Pocion de fuego";
        super.desc = "Inflige 15 de danio";

    }

    @Override
    public void drink(Entity target) {
        target.loseHp(20);
    }
}
